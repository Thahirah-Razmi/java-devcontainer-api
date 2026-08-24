# Java Dev Container API

A simple **Java 21 Spring Boot REST API** running inside a **VS Code Dev Container**.

## Prerequisites

Install:

- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- [Visual Studio Code](https://code.visualstudio.com/)
- [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

Java does not need to be installed on the host machine because the development container provides Java 21 and Maven.

## Run the Project

Clone the repository:

```bash
git clone <your-repository-url>
cd java-devcontainer-api
```

## Pre-commit Hooks

Install the repository's Git hooks after cloning:

```bash
pre-commit install
```

Every contributor must run this command once in each clone because Git hooks are stored locally in `.git/hooks` and are not version controlled.