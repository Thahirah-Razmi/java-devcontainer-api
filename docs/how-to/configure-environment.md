# Configure Environment

Environment-specific application values are provided through environment variables.

## Create the environment file

Copy the example configuration:

```bash
cp .env.example .env
```

Edit .env and provide values appropriate for your environment.

The .env file is intentionally excluded from Git because it may contain environment-specific or sensitive configuration.

Apply configuration changes

After changing an environment value, restart the application so that the new value is loaded.

For the specific configuration keys currently supported by the application, see the Configuration Reference.
