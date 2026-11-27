#!/usr/bin/env bash
set -euo pipefail
: "$RUNNER_TEMP" "$GITHUB_PATH"
work="$(mktemp -d "$RUNNER_TEMP/ic4j-icp-tools.XXXXXX")"
mkdir "$work/bin" "$work/icp"
fetch() {
  local url="$1" digest="$2" dest="$3"
  curl --fail --silent --show-error --location --retry 3 --max-time 180 "$url" -o "$dest"
  printf '%s  %s\n' "$digest" "$dest" | sha256sum -c -
}
fetch https://github.com/dfinity/sdk/releases/download/0.32.0/dfx-0.32.0-x86_64-linux.tar.gz \
  218dad11e0519e11c7a310b5c7cb1eadff109bb5db1ea3432f08c870432a80fc "$work/dfx.tgz"
tar -xzf "$work/dfx.tgz" -C "$work/bin" dfx
fetch https://github.com/dfinity/icp-cli/releases/download/v1.7.0/icp-cli-x86_64-unknown-linux-gnu.tar.xz \
  aa5f0c102ae66e414fa43e119a249f4237998141b001cbccd523a81dadc7d01d "$work/icp.tar.xz"
tar -xJf "$work/icp.tar.xz" -C "$work/icp"
icp="$(find "$work/icp" -type f -name icp -print -quit)"
test -n "$icp"
install -m 0755 "$icp" "$work/bin/icp"
launcher=v16.1.0-2026-10-16-03-29
fetch "https://github.com/dfinity/icp-cli-network-launcher/releases/download/$launcher/icp-cli-network-launcher-x86_64-linux-$launcher.tar.gz" \
  3cc832995318ad9f0a8392c6c7b0b7cf59ed498ad4eb2fd51ff0d34cb7735c01 "$work/launcher.tgz"
mkdir "$work/launcher"
tar -xzf "$work/launcher.tgz" --strip-components=1 -C "$work/launcher"
test -x "$work/launcher/icp-cli-network-launcher"
test -x "$work/launcher/pocket-ic"
printf 'ICP_CLI_NETWORK_LAUNCHER_PATH=%s\n' "$work/launcher/icp-cli-network-launcher" >> "$GITHUB_ENV"

"$work/bin/dfx" --version
"$work/bin/icp" --version
printf '%s\n' "$work/bin" >> "$GITHUB_PATH"
