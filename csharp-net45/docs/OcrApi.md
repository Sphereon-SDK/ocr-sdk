# Sphereon.SDK.Ocr.Api.OcrApi

All URIs are relative to *https://gw.api.cloud.sphereon.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**DeleteJob**](OcrApi.md#deletejob) | **DELETE** /recognition/ocr/1.0/ocr/{jobid} | Delete a job manually
[**GetJob**](OcrApi.md#getjob) | **GET** /recognition/ocr/1.0/ocr/{jobid} | Job definition and state
[**GetJobs**](OcrApi.md#getjobs) | **GET** /recognition/ocr/1.0/ocr | Get all jobs
[**GetResult**](OcrApi.md#getresult) | **GET** /recognition/ocr/1.0/ocr/{jobid}/result | Get the current ocr result
[**SubmitJob**](OcrApi.md#submitjob) | **PUT** /recognition/ocr/1.0/ocr/{jobid} | Submit OCR job for processing
[**UploadFile**](OcrApi.md#uploadfile) | **POST** /recognition/ocr/1.0/ocr | Upload first file


<a name="deletejob"></a>
# **DeleteJob**
> OCRJobResponse DeleteJob (string jobid)

Delete a job manually

Delete the OCR job and all related files

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Ocr.Api;
using Sphereon.SDK.Ocr.Client;
using Sphereon.SDK.Ocr.Model;

namespace Example
{
    public class DeleteJobExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new OcrApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Delete a job manually
                OCRJobResponse result = apiInstance.DeleteJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OcrApi.DeleteJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getjob"></a>
# **GetJob**
> OCRJobResponse GetJob (string jobid)

Job definition and state

Get the OCR job definition and current state. Please not that you can differentiate based on http response status

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Ocr.Api;
using Sphereon.SDK.Ocr.Client;
using Sphereon.SDK.Ocr.Model;

namespace Example
{
    public class GetJobExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new OcrApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Job definition and state
                OCRJobResponse result = apiInstance.GetJob(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OcrApi.GetJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getjobs"></a>
# **GetJobs**
> OCRJobResponse GetJobs (List<string> status = null)

Get all jobs

Get all OCR job definitions and their current state.

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Ocr.Api;
using Sphereon.SDK.Ocr.Client;
using Sphereon.SDK.Ocr.Model;

namespace Example
{
    public class GetJobsExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new OcrApi();
            var status = new List<string>(); // List<string> | A list of status to filter on. (optional) 

            try
            {
                // Get all jobs
                OCRJobResponse result = apiInstance.GetJobs(status);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OcrApi.GetJobs: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**List<string>**](string.md)| A list of status to filter on. | [optional] 

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getresult"></a>
# **GetResult**
> OCRResultResponse GetResult (string jobid)

Get the current ocr result

Get the OCR result  This API only returns the OCR when the response status code is 200! In other cases nothing is returned or the Job JSON when it is still being executed

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Ocr.Api;
using Sphereon.SDK.Ocr.Client;
using Sphereon.SDK.Ocr.Model;

namespace Example
{
    public class GetResultExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new OcrApi();
            var jobid = jobid_example;  // string | jobid

            try
            {
                // Get the current ocr result
                OCRResultResponse result = apiInstance.GetResult(jobid);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OcrApi.GetResult: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 

### Return type

[**OCRResultResponse**](OCRResultResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="submitjob"></a>
# **SubmitJob**
> OCRJobResponse SubmitJob (string jobid, OCRJob job)

Submit OCR job for processing

Apply OCR on the previously uploaded file(s), using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Ocr.Api;
using Sphereon.SDK.Ocr.Client;
using Sphereon.SDK.Ocr.Model;

namespace Example
{
    public class SubmitJobExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new OcrApi();
            var jobid = jobid_example;  // string | jobid
            var job = new OCRJob(); // OCRJob | jobEntity

            try
            {
                // Submit OCR job for processing
                OCRJobResponse result = apiInstance.SubmitJob(jobid, job);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OcrApi.SubmitJob: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **jobid** | **string**| jobid | 
 **job** | [**OCRJob**](OCRJob.md)| jobEntity | 

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="uploadfile"></a>
# **UploadFile**
> OCRJobResponse UploadFile (System.IO.Stream stream)

Upload first file

Upload the first image file.

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Ocr.Api;
using Sphereon.SDK.Ocr.Client;
using Sphereon.SDK.Ocr.Model;

namespace Example
{
    public class UploadFileExample
    {
        public void main()
        {
            
            // Configure OAuth2 access token for authorization: oauth2schema
            Configuration.Default.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new OcrApi();
            var stream = new System.IO.Stream(); // System.IO.Stream | The image file to convert to OCR

            try
            {
                // Upload first file
                OCRJobResponse result = apiInstance.UploadFile(stream);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OcrApi.UploadFile: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stream** | **System.IO.Stream**| The image file to convert to OCR | 

### Return type

[**OCRJobResponse**](OCRJobResponse.md)

### Authorization

[oauth2schema](../README.md#oauth2schema)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

