# Java Project Template for Snowpark

Use this template to start writing data applications on Snowflake using Java.

## Setup

Set the following environment variables with your Snowflake account information:

```bash
# Linux/MacOS
export SNOWSQL_ACCOUNT=<replace with your account identifer>
export SNOWSQL_USER=<replace with your username>
export SNOWSQL_PWD=<replace with your password>
export SNOWSQL_DATABASE=<replace with your database>
export SNOWSQL_SCHEMA=<replace with your schema>
export SNOWSQL_WAREHOUSE=<replace with your warehouse>
```

```powershell
# Windows/PowerShell
$env:SNOWSQL_ACCOUNT = "<replace with your account identifer>"
$env:SNOWSQL_USER = "<replace with your username>"
$env:SNOWSQL_PWD = "<replace with your password>"
$env:SNOWSQL_DATABASE = "<replace with your database>"
$env:SNOWSQL_SCHEMA = "<replace with your schema>"
$env:SNOWSQL_WAREHOUSE = "<replace with your warehouse>"
```

Optional: You can set this env var permanently by editing your bash profile (on Linux/MacOS) or using the System Properties menu (on Windows).

## Prereqs

To develop your applications locally, you will need

- A Snowflake account
- [Java 11](https://adoptium.net/temurin/releases/?version=11)
- An IDE or code editor (IntelliJ, VS Code, Eclipse)

## Usage

Once you've set your credentials, you can test your connection by running the `run()` command in [`App.java`](src/main/java/org/example/procedure/App.java). You can run this method directly from your IDE.

You should see the following output in your terminal:

```log
---------------------------------------------------
|"HELLO_WORLD"                                    |
---------------------------------------------------
|Welcome to Snowflake!                            |
|Learn more: https://www.snowflake.com/snowpark/  |
---------------------------------------------------
```

### Deploy the contents

The GitHub Actions [workflow file](.github/workflows/build-and-deploy.yml) allows you to continously deploy your objects to Snowflake whenever a commit is made on the main branch. To set this up, create secrets in your GitHub repository with the same name and values as the environment variables you created earler (`SNOWSQL_PWD`, `SNOWSQL_ACCOUNT`, etc.). The workflow will create a stage, upload the compiled .jar, and create the stored procedure and UDF objects using the [Snowflake Maven plugin](https://github.com/Snowflake-Labs/snowflake-maven-gradle-plugins)

## Project Structure

- [procedure/](src/main/java/org/example/procedure/): Directory for your stored procedures
- [udf/](src/main/java/org/example/udf/): Directory for your user-defined functions
- [util/](src/main/java/org/example/util/): Directory for methods/classes shared between procedures and UDFs
- [build-and-deploy.yaml](.github/workflows/build-and-deploy.yml): A GitHub Actions template to build and deploy your objects

## Docs

- [Snowpark JavaDoc](https://docs.snowflake.com/en/developer-guide/snowpark/reference/java/index.html)
- [Developer Guide](https://docs.snowflake.com/developer-guide/snowpark/java/index.html)
- [Writing Stored Procedures](https://docs.snowflake.com/en/sql-reference/stored-procedures-java.html)

## Contributing

Have a question or ran into a bug? Please [file an issue](https://github.com/Snowflake-Labs/snowpark-java-template/issues/new) and let us know.

Have an idea for an improvement? Fork this repository and open a PR with your idea!
