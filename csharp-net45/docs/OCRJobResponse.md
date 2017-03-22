# Sphereon.SDK.Ocr.Model.OCRJobResponse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**CompletionTime** | **DateTime?** | The completion date/time of this job in ISO 8601 format | [optional] 
**JobId** | **string** |  | [optional] 
**CreationTime** | **DateTime?** | The creation date/time of this job in ISO 8601 format | [optional] 
**Inputs** | **List&lt;string&gt;** | The original input files. Currently supported inputs are: tiffs | 
**UpdateTime** | **DateTime?** | The last update date/time of this job in ISO 8601 format | [optional] 
**Job** | [**OCRJob**](OCRJob.md) |  | [optional] 
**StatusMessage** | **string** | A status message, which can be informational, warning or error. AA message here does not indicate an error perse | [optional] 
**Tasks** | [**List&lt;OCRTask&gt;**](OCRTask.md) | The server supplied OCR task(s) | [optional] 
**QueueTime** | **DateTime?** | The conversion queue date/time of this job in ISO 8601 format | [optional] 
**Status** | **string** | The status of the job | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

