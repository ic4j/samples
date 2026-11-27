#!/usr/bin/env bash
set -euo pipefail
: "$RUNNER_TEMP"
root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
work="$(mktemp -d "$RUNNER_TEMP/ic4j-deps.XXXXXX")"
repo="$work/maven"
bundle="$RUNNER_TEMP/ic4j-sample-artifacts"
mkdir -p "$repo" "$bundle/org"
cp "$root/scripts/ic4j-ci-lock.tsv" "$bundle/sources.tsv"

while IFS=$'\t' read -r name sha; do
  [[ "$name" =~ ^ic4j-[a-z0-9]+$ && "$sha" =~ ^[a-f0-9]{40}$ ]]
  dir="$work/$name"
  git -c init.defaultBranch=main init -q "$dir"
  git -C "$dir" -c credential.helper= fetch --no-tags --depth=1 "https://github.com/ic4j/$name.git" "$sha"
  git -C "$dir" checkout --quiet --detach FETCH_HEAD
  [[ "$(git -C "$dir" rev-parse HEAD)" == "$sha" ]]
  echo "::group::Build $name @ $sha"
  if [[ "$name" == ic4j-camel ]]; then
    mvn --batch-mode --no-transfer-progress -f "$dir/pom.xml" \
      -Dmaven.repo.local="$repo" -pl ic4j-camel-core -am -Dmaven.test.skip=true clean install
  elif [[ "$name" == ic4j-candid ]]; then
    gradle --no-daemon -p "$dir" -Dmaven.repo.local="$repo" -PrunJavacc=true publishToMavenLocal
  else
    gradle --no-daemon -p "$dir" -Dmaven.repo.local="$repo" publishToMavenLocal
  fi
  echo '::endgroup::'
done < "$root/scripts/ic4j-ci-lock.tsv"

# No remote cache, application data or dependencies outside the IC4J group are uploaded.
cp -R "$repo/org/ic4j" "$bundle/org/"
(
  cd "$bundle"
  version=0.8.5
  for module in candid agent java11transport internetidentity management spring camel-core; do
    file="org/ic4j/ic4j-$module/$version/ic4j-$module-$version.jar"
    test -s "$file"
    jar tf "$file" >/dev/null
    sha256sum "$file"
  done > jars.sha256
  test -s "org/ic4j/ic4j-camel-parent/$version/ic4j-camel-parent-$version.pom"
)
