# retransmision-refdata-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.bursatec</groupId>
    <artifactId>retransmision-refdata-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.bursatec:retransmision-refdata-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/retransmision-refdata-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.bursatec.referencedata.retransmision.client.*;
import com.bursatec.referencedata.retransmision.client.auth.*;
import com.bursatec.referencedata.retransmision.client.*;
import com.bursatec.referencedata.retransmision.client.api.BmvApi;

import java.util.*;

public class ClientApiExample {

    public static void main(String[] args) {
        
        ClientApi apiInstance = new ClientApi();
        String userid = "userid_example"; // String | The user name for login
        String password = "password_example"; // String | MD5 digest of password
        Long startId = 789L; // Long | Initial (Inclusive) Id to retransmit
        Long endId = 789L; // Long | End (Inclusive) Id to retransmit
               
        try {
            // Here, set your server's URL
            apiInstance.getApiClient().setBasePath("https://localhost:1234");
            List<ReferenceData> result = apiInstance.v1ReferenceDataRetransmitGet(userid, password, startId, endId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ClientApi#v1ReferenceDataRetransmitGet");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://<server-ip>:<port>*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ClientApi* | [**v1ReferenceDataRetransmitGet**](docs/ClientApi.md#v1ReferenceDataRetransmitGet) | **GET** /v1/referenceData/retransmit | Request retransmission of Reference Data


## Documentation for Models

 - [ReferenceData](docs/ReferenceData.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



