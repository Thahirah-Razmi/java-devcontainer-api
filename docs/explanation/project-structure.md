# Project Structure

The repository separates application source code, development environment configuration, and project documentation.

```text
java-devcontainer-api/
├── .devcontainer/
│   ├── Dockerfile
│   └── devcontainer.json
├── docs/
│   ├── tutorial/
│   ├── how-to/
│   ├── reference/
│   └── explanation/
├── src/
│   └── main/
│       └── java/
│           └── com/example/demo/
│               └── DemoApplication.java
├── .env.example
├── .gitignore
├── pom.xml
└── README.md

.devcontainer/

Contains the configuration used to create the development container.

src/

Contains the Java application source code.

docs/

Contains project documentation organized by reader intent.

tutorial/

Learning-oriented, step-by-step documentation.

how-to/

Task-oriented instructions for accomplishing specific tasks.

reference/

Factual information such as API endpoints, configuration values, and prerequisites.

explanation/

Conceptual and architectural information explaining how and why the project is structured.

.env.example

Provides an example of the environment configuration expected by the application.

pom.xml

Defines the Maven project, dependencies, plugins, and build configuration.

README.md

Acts as the front door to the project's documentation and provides the shortest path to getting started.