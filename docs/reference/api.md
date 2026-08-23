# API Reference

The Java Dev Container API exposes REST endpoints through the Spring Boot application.

The application runs on port `8080` by default.

## GET `/api/hello`

Returns a greeting message from the application.

### Example request

```http
GET /api/hello
```
### Example response

Hello from my Java Dev Container!

```
GET /api/info
```

Returns basic information about the application and its technology stack.

### Example request

```
GET /api/info
```

### Example response

Java Dev Container API - Java 21 - Spring Boot
