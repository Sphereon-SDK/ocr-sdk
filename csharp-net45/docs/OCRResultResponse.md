# Sphereon.SDK.Ocr.Model.OCRResultResponse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**CompletionTime** | **DateTime?** | The completion date/time of this job in ISO 8601 format | [optional] 
**JobId** | **string** |  | [optional] 
**OcrResult** | [**OCRResult**](OCRResult.md) |  | [optional] 
**CreationTime** | **DateTime?** | The creation date/time of this job in ISO 8601 format | [optional] 
**Ocrtasks** | [**List&lt;OcrTask&gt;**](OcrTask.md) |  | [optional] 
**Inputs** | **List&lt;string&gt;** | The original input files. Currently supported inputs are: tiffs | 
**UpdateTime** | **DateTime?** | The last update date/time of this job in ISO 8601 format | [optional] 
**Job** | [**OCRJob**](OCRJob.md) |  | [optional] 
**StatusMessage** | **string** | A status message, which can be informational, warning or error. AA message here does not indicate an error perse | [optional] 
**QueueTime** | **DateTime?** | The conversion queue date/time of this job in ISO 8601 format | [optional] 
**Status** | **string** | The status of the job | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

