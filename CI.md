# IC4J Samples CI

The workflow builds all 21 examples on Java 21 (including Android APK assembly
and host tests). Additional jobs build a subset on their target Java 8, Java 11
or Java 17 runtime. This does not claim runtime coverage of every sample on all
four JDKs. Bitcoin is compiled only: no node or transaction is started.

IC4J 0.8.5 modules are built from the commits listed in
`scripts/ic4j-ci-lock.tsv`, placed into a fresh Maven repository, and passed
between jobs as an artifact with SHA-256 checksums. To test a newer revision,
update the lock in a PR. The build neither publishes packages nor relies on
preinstalled IC4J artifacts.

The PocketIC job builds and installs 16 checked-in Motoko canisters into a
temporary loopback-only replica, then exercises 26 sample canister calls.
It does not run Java mains or read checked-in network defaults. Tracked example
PEM files are removed from CI build checkouts before packaging. The workflow
does not exercise Android device UI, the Java Internet Identity registration
flow, Kafka through the Camel sample, or the DocuTrack and OrigynNFT backends.
These require separate client/integration tests; a successful compile is not
an integration pass.
