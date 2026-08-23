# Java Dev Container API

A simple **Java 21 Spring Boot REST API** running inside a **VS Code Dev Container**.

## Technologies

* Java 21
* Spring Boot
* Maven
* Docker
* VS Code Dev Containers

## Project Structure

```text
java-devcontainer-api/
├── .devcontainer/
│   ├── Dockerfile
│   └── devcontainer.json
├── src/
│   └── main/
│       └── java/
│           └── com/example/demo/
│               └── DemoApplication.java
├── .env.example
├── .gitignore
├── pom.xml
└── README.md
```

## Requirements

Before getting started, make sure you have:

* [Docker Desktop](https://www.docker.com/products/docker-desktop/)
* [Visual Studio Code](https://code.visualstudio.com/)
* [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

> **Note:** Java does not need to be installed on the host machine because the Java runtime is provided by the development container.

## Getting Started

### 1. Clone the Repository

```bash
git clone <your-repository-url>
cd java-devcontainer-api
```

### 2. Open the Project in VS Code

```bash
code .
```

### 3. Reopen in Container

Open the VS Code Command Palette:

```text
Ctrl + Shift + P
```

Then select:

```text
Dev Containers: Reopen in Container
```

VS Code will build and start the development container using the configuration in `.devcontainer/`.

### 4. Verify Java

Open the terminal inside the container and run:

```bash
java --version
```

You should see Java 21 installed in the container.

### 5. Start the Application

Run:

```bash
mvn spring-boot:run
```

The Spring Boot application will start on port `8080`.

### 6. Access the API

Open the following URL in your browser:

```text
http://localhost:8080/api/hello
```

Expected response:

```text
Hello from my Java Dev Container!
```

## API Endpoints

### GET /api/hello

Returns a greeting message from the Java Dev Container API.

### GET /api/info

Returns basic application information including the runtime and framework.

Example response:

Java Dev Container API - Java 21 - Spring Boot

## Environment Configuration

Copy `.env.example` to `.env` and update the values when required.

```bash
cp .env.example .env
```

The `.env` file is intentionally excluded from Git because it may contain environment-specific or sensitive configuration.

## Development

All Java, Maven, and other development dependencies are provided through the Dev Container. This allows the project to maintain a consistent development environment without requiring Java to be installed directly on the host machine.

## License

This project is intended for learning and development purposes.
