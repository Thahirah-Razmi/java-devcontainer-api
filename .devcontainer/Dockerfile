FROM eclipse-temurin:21-jdk-jammy

WORKDIR /workspace

RUN apt-get update \
    && apt-get install -y git curl maven \
    && rm -rf /var/lib/apt/lists/*

RUN useradd -m -s /bin/bash developer

RUN chown -R developer:developer /workspace

USER developer

CMD ["sleep", "infinity"]