# ocr-sdk-java8

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
    <groupId>com.sphereon.sdk</groupId>
    <artifactId>ocr-sdk-java8</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.sphereon.sdk:ocr-sdk-java8:1.0.0-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/ocr-sdk-java8-1.0.0-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.sphereon.sdk.ocr.handler.*;
import com.sphereon.sdk.ocr.handler.auth.*;
import com.sphereon.sdk.ocr.handler.model.*;
import com.sphereon.sdk.ocr.api.OcrApi;

import java.io.File;
import java.util.*;

public class OcrApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure OAuth2 access token for authorization: oauth2schema
        OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
        oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

        OcrApi apiInstance = new OcrApi();
        String jobid = "jobid_example"; // String | jobid
        try {
            OCRJobResponse result = apiInstance.deleteJob(jobid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OcrApi#deleteJob");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*OcrApi* | [**deleteJob**](docs/OcrApi.md#deleteJob) | **DELETE** /ocr/1.0.0/ocr/{jobid} | Delete a job manually
*OcrApi* | [**getJob**](docs/OcrApi.md#getJob) | **GET** /ocr/1.0.0/ocr/{jobid} | Job definition and state
*OcrApi* | [**getJobs**](docs/OcrApi.md#getJobs) | **GET** /ocr/1.0.0/ocr | Get all jobs
*OcrApi* | [**getOcrResult**](docs/OcrApi.md#getOcrResult) | **GET** /ocr/1.0.0/ocr/{jobid}/result | Get the current ocr result
*OcrApi* | [**submitJob**](docs/OcrApi.md#submitJob) | **PUT** /ocr/1.0.0/ocr/{jobid} | Submit OCR job for processing
*OcrApi* | [**uploadFile**](docs/OcrApi.md#uploadFile) | **POST** /ocr/1.0.0/ocr | Upload first file


## Documentation for Models

 - [Anchor](docs/Anchor.md)
 - [Error](docs/Error.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [Input](docs/Input.md)
 - [Item](docs/Item.md)
 - [Lifecycle](docs/Lifecycle.md)
 - [Line](docs/Line.md)
 - [OCRJob](docs/OCRJob.md)
 - [OCRJobResponse](docs/OCRJobResponse.md)
 - [OCRResult](docs/OCRResult.md)
 - [OCRResultResponse](docs/OCRResultResponse.md)
 - [OCRSettings](docs/OCRSettings.md)
 - [OcrTask](docs/OcrTask.md)
 - [Page](docs/Page.md)
 - [Pass](docs/Pass.md)
 - [Point](docs/Point.md)
 - [Region](docs/Region.md)
 - [Word](docs/Word.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### oauth2schema

- **Type**: OAuth
- **Flow**: application
- **Authorizatoin URL**: 
- **Scopes**: 
  - global: accessEverything


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

dev@sphereon.com

