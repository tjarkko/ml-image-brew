# Local development

NOTE: Tested to work only on MacOS

Copy .env.example -> .env and fill in the values

## IntelliJ

Install JDK with Java 18 e.g. AWS Corretto via IntelliJ
NOTE: Java 20 seems to cause some compatibility issue with gradle

Use the EnvVar plugin to add env variables to run configuration
https://plugins.jetbrains.com/plugin/7861-envfile

## Terminal

Use gradle directly. Install JDK and set JAVA_HOME.

Set the env vars:

```source .env```

## Authenticate to GCS for local dev

Use e.g. application default credentials:

```gcloud auth application-default login```

# Deploying to GCS

## Build a Docker container

todo

## Deploy

todo

## Authentication in GCS

<p>Authentication is done automatically when using the GCS client libraries at least when running e.g.
via Cloud Run</p>

Just setup e.g. the needed service accounts to use when running the Cloud Run revision.