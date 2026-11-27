#!/usr/bin/env bash
# Pin both the distribution and its independently verified Apache SHA-512.
set -euo pipefail
: "${RUNNER_TEMP:?}" "${GITHUB_ENV:?}"
work="$(mktemp -d "$RUNNER_TEMP/ic4j-kafka.XXXXXX")"
version=4.3.1
distribution="kafka_2.13-$version"
archive="$work/$distribution.tgz"
for mirror in downloads.apache.org archive.apache.org/dist; do
  if curl --fail --silent --show-error --location --retry 2 --max-time 180 \
    "https://$mirror/kafka/$version/$distribution.tgz" -o "$archive"; then break; fi
done
printf 'c7d7b2318cb51aa0c61d3246a51c349210073c5c9b754947ef965a439f2f939e8600f204e134a75ac31faf3829c9370960ef7c6a9886c8a1dbf0339a21f4c54c  %s\n' "$archive" | sha512sum -c -
tar -xzf "$archive" -C "$work"
printf 'KAFKA_HOME=%s\n' "$work/$distribution" >> "$GITHUB_ENV"
