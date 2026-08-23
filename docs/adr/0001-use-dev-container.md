# ADR 0001: Use a Dev Container for Development

- **Status:** Accepted
- **Date:** 2026-08-23

## Context

The Java Dev Container API requires a consistent development environment for Java, Maven, and project tooling.

Installing these tools directly on every developer's host machine can result in differences between development environments.

For example, developers may have different Java versions, Maven versions, operating system configurations, or supporting tools installed.

The project already uses Docker and VS Code Dev Containers to provide a controlled development environment.

## Decision

The project will use a VS Code Dev Container as the standard development environment.

The container provides the development tools required by the project, including:

- Java 21
- Maven
- Git
- Python 3
- MkDocs

The environment is defined by the files in `.devcontainer/` and is built automatically when the project is opened in a Dev Container.

Development tools that are specific to the project should be installed or configured through the container rather than requiring manual installation on the developer's host machine.

## Consequences

### Positive consequences

- Developers use a consistent Java 21 environment.
- Maven and other development tools are available inside the container.
- New contributors do not need to manually install Java and Maven on the host.
- The development environment is version-controlled alongside the application.
- Documentation tooling such as MkDocs is also available inside the same environment.
- The setup can be reproduced on another machine that supports Docker and VS Code Dev Containers.

### Negative consequences

- Docker Desktop is required for the development workflow.
- Container startup and rebuilds introduce additional overhead compared with running the application directly on the host.
- Developers need to understand the basic VS Code Dev Containers workflow.
- File-system performance can vary depending on the host operating system and Docker configuration.
- The container configuration itself must be maintained when development dependencies change.

## Alternatives Considered

### Install Java and Maven directly on the host

This would require each developer to maintain compatible versions of Java, Maven, and other tools.

It provides a simpler local execution model but makes environment consistency more difficult.

### Use Docker only to run the application

Docker could be used only for application execution while development tools remain installed on the host.

This would reduce container usage during development but would not provide the same level of consistency for the complete development environment.

## Decision Outcome

The Dev Container approach is preferred because environment consistency and reproducibility are more important for this project than the additional Docker setup and operational overhead.