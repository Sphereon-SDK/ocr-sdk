# ocr.OcrApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteJob**](OcrApi.md#deleteJob) | **DELETE** /ocr/1.0.0/ocr/{jobid} | Delete a job manually
[**getJob**](OcrApi.md#getJob) | **GET** /ocr/1.0.0/ocr/{jobid} | Job definition and state
[**getJobs**](OcrApi.md#getJobs) | **GET** /ocr/1.0.0/ocr | Get all jobs
[**getResult**](OcrApi.md#getResult) | **GET** /ocr/1.0.0/ocr/{jobid}/result | Get the current ocr result
[**submitJob**](OcrApi.md#submitJob) | **PUT** /ocr/1.0.0/ocr/{jobid} | Submit OCR job for processing
[**uploadFile**](OcrApi.md#uploadFile) | **POST** /ocr/1.0.0/ocr | Upload first file


<a name="deleteJob"></a>
# **deleteJob**
> OCRJobResponse deleteJob(jobid)

Delete a job manually

Delete the OCR job and all related files

### Example
```javascript
var ocr = require('ocr-sdk');
var defaultClient = ocr.ApiClient.default;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new ocr.OcrApi();

var jobid = "jobid_example"; // String | jobid

apiInstance.deleteJob(jobid).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

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
```javascript
var ocr = require('ocr-sdk');
var defaultClient = ocr.ApiClient.default;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new ocr.OcrApi();

var jobid = "jobid_example"; // String | jobid

apiInstance.getJob(jobid).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

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
> OCRJobResponse getJobs(opts)

Get all jobs

Get all OCR job definitions and their current state.

### Example
```javascript
var ocr = require('ocr-sdk');
var defaultClient = ocr.ApiClient.default;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new ocr.OcrApi();

var opts = { 
  'status': ["status_example"] // [String] | A list of status to filter on.
};
apiInstance.getJobs(opts).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**[String]**](String.md)| A list of status to filter on. | [optional] 

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

<a name="getResult"></a>
# **getResult**
> OCRResultResponse getResult(jobid)

Get the current ocr result

Get the OCR result  This API only returns the OCR when the response status code is 200! In other cases nothing is returned or the Job JSON when it is still being executed

### Example
```javascript
var ocr = require('ocr-sdk');
var defaultClient = ocr.ApiClient.default;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new ocr.OcrApi();

var jobid = "jobid_example"; // String | jobid

apiInstance.getResult(jobid).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

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

Apply OCR on the previously uploaded file(s), using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request

### Example
```javascript
var ocr = require('ocr-sdk');
var defaultClient = ocr.ApiClient.default;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new ocr.OcrApi();

var jobid = "jobid_example"; // String | jobid

var job = new ocr.OCRJob(); // OCRJob | jobEntity

apiInstance.submitJob(jobid, job).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

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

Upload the first image file.

### Example
```javascript
var ocr = require('ocr-sdk');
var defaultClient = ocr.ApiClient.default;

// Configure OAuth2 access token for authorization: oauth2schema
var oauth2schema = defaultClient.authentications['oauth2schema'];
oauth2schema.accessToken = 'YOUR ACCESS TOKEN';

var apiInstance = new ocr.OcrApi();

var stream = "/path/to/file.txt"; // File | The image file to convert to OCR

apiInstance.uploadFile(stream).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

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

