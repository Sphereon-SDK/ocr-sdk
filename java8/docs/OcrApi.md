# OcrApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteJob**](OcrApi.md#deleteJob) | **DELETE** /ocr/1.0.0/ocr/{jobid} | Delete a job manually
[**getJob**](OcrApi.md#getJob) | **GET** /ocr/1.0.0/ocr/{jobid} | Job definition and state
[**getJobs**](OcrApi.md#getJobs) | **GET** /ocr/1.0.0/ocr | Get all jobs
[**getOcrResult**](OcrApi.md#getOcrResult) | **GET** /ocr/1.0.0/ocr/{jobid}/result | Get the current ocr result
[**submitJob**](OcrApi.md#submitJob) | **PUT** /ocr/1.0.0/ocr/{jobid} | Submit OCR job for processing
[**uploadFile**](OcrApi.md#uploadFile) | **POST** /ocr/1.0.0/ocr | Upload first file


<a name="deleteJob"></a>
# **deleteJob**
> OCRJobResponse deleteJob(jobid)

Delete a job manually

Delete the OCR job and all related files

### Example
```java
// Import classes:
//import com.sphereon.sdk.ocr.handler.ApiClient;
//import com.sphereon.sdk.ocr.handler.ApiException;
//import com.sphereon.sdk.ocr.handler.Configuration;
//import com.sphereon.sdk.ocr.handler.auth.*;
//import com.sphereon.sdk.ocr.api.OcrApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getJob"></a>
# **getJob**
> OCRJobResponse getJob(jobid)

Job definition and state

Get the OCR job definition and current state. Please not that you can differentiate based on http response status

### Example
```java
// Import classes:
//import com.sphereon.sdk.ocr.handler.ApiClient;
//import com.sphereon.sdk.ocr.handler.ApiException;
//import com.sphereon.sdk.ocr.handler.Configuration;
//import com.sphereon.sdk.ocr.handler.auth.*;
//import com.sphereon.sdk.ocr.api.OcrApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

OcrApi apiInstance = new OcrApi();
String jobid = "jobid_example"; // String | jobid
try {
    OCRJobResponse result = apiInstance.getJob(jobid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OcrApi#getJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getJobs"></a>
# **getJobs**
> OCRJobResponse getJobs(status)

Get all jobs

Get all OCR job definitions and their current state.

### Example
```java
// Import classes:
//import com.sphereon.sdk.ocr.handler.ApiClient;
//import com.sphereon.sdk.ocr.handler.ApiException;
//import com.sphereon.sdk.ocr.handler.Configuration;
//import com.sphereon.sdk.ocr.handler.auth.*;
//import com.sphereon.sdk.ocr.api.OcrApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

OcrApi apiInstance = new OcrApi();
List<String> status = Arrays.asList("status_example"); // List<String> | A list of status to filter on.
try {
    OCRJobResponse result = apiInstance.getJobs(status);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OcrApi#getJobs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**List&lt;String&gt;**](String.md)| A list of status to filter on. | [optional] [enum: INPUTS_UPLOADED, PROCESSING, DONE, ERROR, DELETED]

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getOcrResult"></a>
# **getOcrResult**
> OCRResultResponse getOcrResult(jobid)

Get the current ocr result

Get the OCR result  Our API generation does not allow changing the media type based on the Accepted header unfortunately.&lt;br/&gt;This means we use a seperate path postfix with the value &#39;/result&#39;.  This API only returns the OCR when the response status code is 200! In other cases nothing is returned or the Job JSON when it is still being executed

### Example
```java
// Import classes:
//import com.sphereon.sdk.ocr.handler.ApiClient;
//import com.sphereon.sdk.ocr.handler.ApiException;
//import com.sphereon.sdk.ocr.handler.Configuration;
//import com.sphereon.sdk.ocr.handler.auth.*;
//import com.sphereon.sdk.ocr.api.OcrApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

OcrApi apiInstance = new OcrApi();
String jobid = "jobid_example"; // String | jobid
try {
    OCRResultResponse result = apiInstance.getOcrResult(jobid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OcrApi#getOcrResult");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |

### Return type

[**OCRResultResponse**](OCRResultResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="submitJob"></a>
# **submitJob**
> OCRJobResponse submitJob(jobid, job)

Submit OCR job for processing

Convert the previously uploaded file(s) to OCR, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request

### Example
```java
// Import classes:
//import com.sphereon.sdk.ocr.handler.ApiClient;
//import com.sphereon.sdk.ocr.handler.ApiException;
//import com.sphereon.sdk.ocr.handler.Configuration;
//import com.sphereon.sdk.ocr.handler.auth.*;
//import com.sphereon.sdk.ocr.api.OcrApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

OcrApi apiInstance = new OcrApi();
String jobid = "jobid_example"; // String | jobid
OCRJob job = new OCRJob(); // OCRJob | jobEntity
try {
    OCRJobResponse result = apiInstance.submitJob(jobid, job);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OcrApi#submitJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **String**| jobid |
 **job** | [**OCRJob**](OCRJob.md)| jobEntity |

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

<a name="uploadFile"></a>
# **uploadFile**
> OCRJobResponse uploadFile(stream)

Upload first file

Upload the first image, office or ocr file.

### Example
```java
// Import classes:
//import com.sphereon.sdk.ocr.handler.ApiClient;
//import com.sphereon.sdk.ocr.handler.ApiException;
//import com.sphereon.sdk.ocr.handler.Configuration;
//import com.sphereon.sdk.ocr.handler.auth.*;
//import com.sphereon.sdk.ocr.api.OcrApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2schema
OAuth oauth2schema = (OAuth) defaultClient.getAuthentication("oauth2schema");
oauth2schema.setAccessToken("YOUR ACCESS TOKEN");

OcrApi apiInstance = new OcrApi();
File stream = new File("/path/to/file.txt"); // File | The image file to convert to OCR
try {
    OCRJobResponse result = apiInstance.uploadFile(stream);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OcrApi#uploadFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stream** | **File**| The image file to convert to OCR |

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

