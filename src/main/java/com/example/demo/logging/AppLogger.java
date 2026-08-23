package com.example.demo.logging;

import java.time.Instant;

import org.springframework.stereotype.Component;

@Component
public class AppLogger {

    public enum Level {
        DEBUG,
        INFO,
        ERROR
    }

    private final Level threshold;

    public AppLogger() {
        String configuredLevel = System.getenv().getOrDefault("LOG_LEVEL", "INFO");
        Level configuredThreshold;

        try {
            configuredThreshold = Level.valueOf(configuredLevel.toUpperCase());
        } catch (IllegalArgumentException exception) {
            configuredThreshold = Level.INFO;
        }

        this.threshold = configuredThreshold;
    }

    public void debug(String message, Object... context) {
        log(Level.DEBUG, message, null, context);
    }

    public void info(String message, Object... context) {
        log(Level.INFO, message, null, context);
    }

    public void error(String message, Throwable cause, Object... context) {
        log(Level.ERROR, message, cause, context);
    }

    private void log(Level level, String message, Throwable cause, Object... context) {
        if (level.ordinal() < threshold.ordinal()) {
            return;
        }

        StringBuilder output = new StringBuilder()
                .append(Instant.now())
                .append(" ")
                .append(level)
                .append(" ")
                .append(message);

        for (int i = 0; i + 1 < context.length; i += 2) {
            output.append(" ")
                    .append(context[i])
                    .append("=")
                    .append(context[i + 1]);
        }

        System.out.println(output);

        if (cause != null) {
            System.out.println("cause=" + cause.getClass().getSimpleName()
                    + " message=" + cause.getMessage());
        }
    }
}
