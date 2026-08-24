FROM eclipse-temurin:21-jdk-jammy

WORKDIR /workspace

RUN apt-get update \
    && apt-get install -y \
        git \
        curl \
        maven \
        python3 \
        python3-pip \
        python3-venv \
        python3.10-venv \
        docker.io \
    && rm -rf /var/lib/apt/lists/*

RUN python3 -m venv /opt/pre-commit \
    && /opt/pre-commit/bin/pip install --no-cache-dir pre-commit \
    && ln -s /opt/pre-commit/bin/pre-commit /usr/local/bin/pre-commit

RUN curl -s https://raw.githubusercontent.com/nektos/act/master/install.sh | bash \
    && mv /workspace/bin/act /usr/local/bin/act \
    && rm -rf /workspace/bin

RUN groupmod -g 986 docker \
    && useradd -m -s /bin/bash -G docker developer

RUN chown -R developer:developer /workspace

USER developer

CMD ["sleep", "infinity"]