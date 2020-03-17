# Apigee with Apache Freemarker

You can use [Apache Freemarker](https://freemarker.apache.org/) templates inside Apigee [Java Callouts](https://docs.apigee.com/api-platform/reference/policies/java-callout-policy).

Here is an example.

## Prerequisites

- Java 1.8+
- Maven 3
- An Apigee Free Organization

To deploy:

``` shell
mvn clean install -Ptest -Dapigee.org=ORG -Dapigee.username=EMAIL -Dapigee.password=PASS
```
To test:

Open your browser to `https://{org}-{env}.apigee.net/apigee-freemarker/v1`.

You should see:

> The message is: Today is a beautiful day
