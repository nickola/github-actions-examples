[![Build "java-spring-boot-gradle"](https://github.com/nickola/github-actions-examples/actions/workflows/build-java-spring-boot-gradle.yaml/badge.svg)](https://github.com/nickola/github-actions-examples/actions/workflows/build-java-spring-boot-gradle.yaml)
[![Deploy "java-spring-boot-gradle"](https://github.com/nickola/github-actions-examples/actions/workflows/deploy-java-spring-boot-gradle.yaml/badge.svg)](https://github.com/nickola/github-actions-examples/actions/workflows/deploy-java-spring-boot-gradle.yaml)

# Actions

- [Build "java-spring-boot-gradle"](https://github.com/nickola/github-actions-examples/actions/workflows/build-java-spring-boot-gradle.yaml)
  action (see: [build-java-spring-boot-gradle.yaml](.github/workflows/build-java-spring-boot-gradle.yaml)).
  This action will build the Docker image (will run tests during the build) and will push it to the
  [GitHub Packages](https://github.com/nickola/github-actions-examples/pkgs/container/github-actions-examples%2Fjava-spring-boot-gradle).
  Push to `master` with changes in `java-spring-boot-gradle/*` directory will automatically trigger this action
  (in can be easily customized for `pull_request` trigger as well).
  Tests coverage and vulnerability analysis can also be implemented.
  And Git tags can be used for Docker tags if necessary.

- [Deploy "java-spring-boot-gradle"](https://github.com/nickola/github-actions-examples/actions/workflows/deploy-java-spring-boot-gradle.yaml)
  manual action (see: [deploy-java-spring-boot-gradle.yaml](.github/workflows/deploy-java-spring-boot-gradle.yaml)).
  This action can be used to deploy a specified tag, that was pushed by `build-java-spring-boot-gradle` action
  (see: [all tags](https://github.com/nickola/github-actions-examples/pkgs/container/github-actions-examples%2Fjava-spring-boot-gradle)).
  It will make sure that the tag exists in the registry (it will not deploy non-existent tag).
  At the final step it will just show the image that should be deployed (deploy logic can be various, based on the requirements).

# Local build

```shell
cd java-spring-boot-gradle
docker build . --progress plain --tag java-spring-boot-gradle
```

# Start application

Local version:

```shell
docker run --rm --tty --interactive --publish 8080:8080 java-spring-boot-gradle
```

Published version:

```shell
docker run --rm --tty --interactive --publish 8080:8080 ghcr.io/nickola/github-actions-examples/java-spring-boot-gradle:latest
```

# Access started application

```shell
curl http://localhost:8080
```

Output:

```json
{"data": "Hello world!"}
```
