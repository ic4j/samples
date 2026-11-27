#!/usr/bin/env bash
set -euo pipefail
: "$CI_MAVEN_REPO" "$SAMPLES" "$TOOL"
(cd "$CI_MAVEN_REPO" && sha256sum -c jars.sha256)
# Tracked example keys are not used or packaged in the CI checkout.
git ls-files -z -- '*.pem' | xargs -0 -r rm -f --
if [[ "$TOOL" == android ]]; then
  sdkmanager 'platforms;android-34' 'build-tools;35.0.0'
fi
read -r -a projects <<< "$SAMPLES"
failed=()
for sample in "${projects[@]}"; do
  [[ "$sample" =~ ^(IC4J[A-Za-z0-9]+|AndroidHelloWorld)$ ]]
  echo "::group::$sample"
  case "$TOOL" in
    maven)
      mvn --batch-mode --no-transfer-progress -f "$sample/pom.xml" \
        -Dmaven.repo.local="$CI_MAVEN_REPO" verify || failed+=("$sample")
      ;;
    gradle)
      gradle --no-daemon -p "$sample" -Dmaven.repo.local="$CI_MAVEN_REPO" build || failed+=("$sample")
      ;;
    android)
      gradle --no-daemon -p "$sample" -Dmaven.repo.local="$CI_MAVEN_REPO" \
        assembleDebug testDebugUnitTest || failed+=("$sample")
      ;;
    *) exit 2 ;;
  esac
  echo '::endgroup::'
done
if (( ${#failed[@]} )); then
  printf 'Failed projects: %s\n' "${failed[*]}" >&2
  exit 1
fi
