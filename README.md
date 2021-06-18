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

The build uses [Tycho](http://www.eclipse.org/tycho/). To build the product, issue
```
mvn clean verify -P full -P product
```
from the top-level directory.

The resulting product can be found in `releng/plugins/org.polarsys.capella.studio.releng.product/target/products/`.
