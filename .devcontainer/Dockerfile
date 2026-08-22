FROM eclipse-temurin:21-jdk-jammy

WORKDIR /workspace

RUN apt-get update \
    && apt-get install -y git curl maven \
    && rm -rf /var/lib/apt/lists/*

CMD ["sleep", "infinity"]