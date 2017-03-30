
# Pass

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**engine** | [**EngineEnum**](#EngineEnum) | OCR engine used in this pass | 
**pass** | **Integer** | OCR pass number | 
**words** | [**List&lt;Word&gt;**](Word.md) | words found by OCR engine | 
**lines** | [**List&lt;Line&gt;**](Line.md) | lines found by OCR engine (when supported by engine) |  [optional]


<a name="EngineEnum"></a>
## Enum: EngineEnum
Name | Value
---- | -----
ADVANCED | &quot;ADVANCED&quot;
PREMIUM | &quot;PREMIUM&quot;
BASIC | &quot;BASIC&quot;



