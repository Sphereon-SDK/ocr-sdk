
# OCRResultResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**result** | [**OCRResult**](OCRResult.md) |  |  [optional]
**completionTime** | [**OffsetDateTime**](OffsetDateTime.md) | The completion date/time of this job in ISO 8601 format |  [optional]
**jobId** | **String** |  |  [optional]
**creationTime** | [**OffsetDateTime**](OffsetDateTime.md) | The creation date/time of this job in ISO 8601 format |  [optional]
**inputs** | **List&lt;String&gt;** | The original input files. Currently supported inputs are: tiffs | 
**updateTime** | [**OffsetDateTime**](OffsetDateTime.md) | The last update date/time of this job in ISO 8601 format |  [optional]
**job** | [**OCRJob**](OCRJob.md) |  |  [optional]
**statusMessage** | **String** | A status message, which can be informational, warning or error. AA message here does not indicate an error perse |  [optional]
**tasks** | [**List&lt;OCRTask&gt;**](OCRTask.md) | The server supplied OCR task(s) |  [optional]
**queueTime** | [**OffsetDateTime**](OffsetDateTime.md) | The conversion queue date/time of this job in ISO 8601 format |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the job | 


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
INPUTS_UPLOADED | &quot;INPUTS_UPLOADED&quot;
PROCESSING | &quot;PROCESSING&quot;
DONE | &quot;DONE&quot;
ERROR | &quot;ERROR&quot;
DELETED | &quot;DELETED&quot;



