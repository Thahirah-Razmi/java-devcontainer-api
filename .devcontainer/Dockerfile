FROM eclipse-temurin:21-jdk-jammy

WORKDIR /workspace

RUN apt-get update \
    && apt-get install -y git curl maven python3 python3-pip python3-venv python3.10-venv \
    && rm -rf /var/lib/apt/lists/*

RUN useradd -m -s /bin/bash developer

RUN chown -R developer:developer /workspace

USER developer

CMD ["sleep", "infinity"]