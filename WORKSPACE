workspace(name = "design_patterns_cheat_sheet")

# https://github.com/bazelbuild/rules_scala#getting-started
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

rules_scala_version="45fa926fb046eb46931b14e5f0fc7f684d4d17d9" # update this as needed

http_archive(
    name = "io_bazel_rules_scala",
    url = "https://github.com/bazelbuild/rules_scala/archive/%s.zip"%rules_scala_version,
    type = "zip",
    strip_prefix= "rules_scala-%s" % rules_scala_version
)

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")
scala_repositories()

# register default scala toolchain
load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")
scala_register_toolchains()

# load("//3rdparty:workspace.bzl", "maven_dependencies")
# maven_dependencies()
