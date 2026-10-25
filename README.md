# Eclipse Capella Studio

[![Master build status](https://img.shields.io/jenkins/build?jobUrl=https%3A%2F%2Fci.eclipse.org%2Fcapella%2Fview%2FCapella%2520Studio%2Fjob%2FCapella-Studio%2Fjob%2Fmaster%2F)](https://ci.eclipse.org/capella/view/Capella%20Studio/job/Capella-Studio/job/master/)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=eclipse_capella-studio&metric=alert_status)](https://sonarcloud.io/dashboard?id=eclipse_capella-studio)
![License](https://img.shields.io/github/license/eclipse/capella-studio)

Capella Studio provides a full-integrated development environment which aims at facilitating the development of extensions for Capella MBSE.

It provides developers with a platform containing both:
- Kitalpha and Eclipse modeling frameworks and tools
- Capella models and tools

For more details see [the project page](http://www.eclipse.org/Capella) and [the main wiki page](https://wiki.eclipse.org/Capella/Studio).

# Building

The build uses [Tycho](https://www.eclipse.org/tycho/) and requires Java 21 and Maven. From the top-level directory, generate the target platform, then build and install the unsigned products:

```sh
MAVEN_OPTS=-Xmx3g mvn clean verify -f releng/plugins/org.polarsys.capella.studio.releng.targets/pom.xml
MAVEN_OPTS=-Xmx3g mvn clean install -P 'full,product,!sign' -e
```

The resulting archives are in `releng/plugins/org.polarsys.capella.studio.releng.product/target/products/`:

- Linux x86_64 and aarch64: `.tar.gz`
- macOS x86_64 and aarch64: `.tar.gz`
- Windows x86_64: `.zip`

Product copy and publishing commands must include both `*.zip` and `*.tar.gz`.

After installation, run RCPTT tests on a host with a graphical display (Jenkins uses Xvnc):

```sh
MAVEN_OPTS=-Xmx3g mvn verify -P rcptt -Dtycho.localArtifacts=ignore -e
```

RCPTT resolves the installed product for the host platform. Its AUT archive extension defaults to `tar.gz` for Linux and macOS; on Windows, add `-Drcptt-aut-extension=zip` to the RCPTT command. Run `install` before starting RCPTT so the product archive is available in the local Maven repository.
