# Development Environment

The project uses a VS Code Dev Container to provide a consistent development environment.

Instead of requiring each developer to install Java, Maven, and documentation tooling directly on their host machine, these tools are provided by the container.

## Why use a Dev Container?

A container makes the development environment reproducible.

The project's `.devcontainer/` directory defines the environment required to work on the application.

The environment currently provides:

- Java 21
- Maven
- Git
- Python 3
- MkDocs

The Java application runs inside the container, while VS Code connects to the container as the development environment.

## Documentation tooling

MkDocs is installed automatically through the Dev Container's `postCreateCommand`.

The project uses a Python virtual environment located at:

```text
.venv/

The virtual environment is ignored by Git because it is generated development tooling rather than project source code.