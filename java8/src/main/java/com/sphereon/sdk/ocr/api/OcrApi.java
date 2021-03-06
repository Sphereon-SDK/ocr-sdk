/**
 * OCR
 * <b>The OCR API 'ocr' performs Optical Character Resolution on input files.</b>    The flow is generally as follows:  1. First upload an image/file using the /ocr POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /ocr/{jobid} endpoint, with the Job and Settings JSON as request body. The ocr extraction will now start.  3. Check the job status from the /ocr/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the OCR result using the /ocr/{jobid}/result GET endpoint. This will return the OCR result only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.0
 * Contact: dev@sphereon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.sphereon.sdk.ocr.api;

import com.sphereon.sdk.ocr.handler.ApiCallback;
import com.sphereon.sdk.ocr.handler.ApiClient;
import com.sphereon.sdk.ocr.handler.ApiException;
import com.sphereon.sdk.ocr.handler.ApiResponse;
import com.sphereon.sdk.ocr.handler.Configuration;
import com.sphereon.sdk.ocr.handler.Pair;
import com.sphereon.sdk.ocr.handler.ProgressRequestBody;
import com.sphereon.sdk.ocr.handler.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import com.sphereon.sdk.ocr.model.OCRJobResponse;
import com.sphereon.sdk.ocr.model.ErrorResponse;
import com.sphereon.sdk.ocr.model.OCRResultResponse;
import com.sphereon.sdk.ocr.model.OCRJob;
import java.io.File;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OcrApi {
    public static final String BASEPATH = "/recognition/ocr/1.0/ocr";
    private ApiClient apiClient;

    public OcrApi() {
        this(Configuration.getDefaultApiClient());
    }

    public OcrApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for deleteJob */
    private com.squareup.okhttp.Call deleteJobCall(String jobid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'jobid' is set
        if (jobid == null) {
            throw new ApiException("Missing the required parameter 'jobid' when calling deleteJob(Async)");
        }
        

        // create path and map variables
        String localVarPath = BASEPATH+"/{jobid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "jobid" + "\\}", apiClient.escapeString(jobid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Delete a job manually
     * Delete the OCR job and all related files
     * @param jobid jobid (required)
     * @return OCRJobResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OCRJobResponse deleteJob(String jobid) throws ApiException {
        ApiResponse<OCRJobResponse> resp = deleteJobWithHttpInfo(jobid);
        return resp.getData();
    }

    /**
     * Delete a job manually
     * Delete the OCR job and all related files
     * @param jobid jobid (required)
     * @return ApiResponse&lt;OCRJobResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<OCRJobResponse> deleteJobWithHttpInfo(String jobid) throws ApiException {
        com.squareup.okhttp.Call call = deleteJobCall(jobid, null, null);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a job manually (asynchronously)
     * Delete the OCR job and all related files
     * @param jobid jobid (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteJobAsync(String jobid, final ApiCallback<OCRJobResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteJobCall(jobid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getJob */
    private com.squareup.okhttp.Call getJobCall(String jobid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'jobid' is set
        if (jobid == null) {
            throw new ApiException("Missing the required parameter 'jobid' when calling getJob(Async)");
        }
        

        // create path and map variables
        String localVarPath = BASEPATH+"/{jobid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "jobid" + "\\}", apiClient.escapeString(jobid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Job definition and state
     * Get the OCR job definition and current state. Please not that you can differentiate based on http response status
     * @param jobid jobid (required)
     * @return OCRJobResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OCRJobResponse getJob(String jobid) throws ApiException {
        ApiResponse<OCRJobResponse> resp = getJobWithHttpInfo(jobid);
        return resp.getData();
    }

    /**
     * Job definition and state
     * Get the OCR job definition and current state. Please not that you can differentiate based on http response status
     * @param jobid jobid (required)
     * @return ApiResponse&lt;OCRJobResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<OCRJobResponse> getJobWithHttpInfo(String jobid) throws ApiException {
        com.squareup.okhttp.Call call = getJobCall(jobid, null, null);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Job definition and state (asynchronously)
     * Get the OCR job definition and current state. Please not that you can differentiate based on http response status
     * @param jobid jobid (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getJobAsync(String jobid, final ApiCallback<OCRJobResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getJobCall(jobid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getJobs */
    private com.squareup.okhttp.Call getJobsCall(List<String> status, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = BASEPATH.replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (status != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "status", status));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Get all jobs
     * Get all OCR job definitions and their current state.
     * @param status A list of status to filter on. (optional)
     * @return OCRJobResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OCRJobResponse getJobs(List<String> status) throws ApiException {
        ApiResponse<OCRJobResponse> resp = getJobsWithHttpInfo(status);
        return resp.getData();
    }

    /**
     * Get all jobs
     * Get all OCR job definitions and their current state.
     * @param status A list of status to filter on. (optional)
     * @return ApiResponse&lt;OCRJobResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<OCRJobResponse> getJobsWithHttpInfo(List<String> status) throws ApiException {
        com.squareup.okhttp.Call call = getJobsCall(status, null, null);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all jobs (asynchronously)
     * Get all OCR job definitions and their current state.
     * @param status A list of status to filter on. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getJobsAsync(List<String> status, final ApiCallback<OCRJobResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getJobsCall(status, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getResult */
    private com.squareup.okhttp.Call getResultCall(String jobid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'jobid' is set
        if (jobid == null) {
            throw new ApiException("Missing the required parameter 'jobid' when calling getResult(Async)");
        }
        

        // create path and map variables
        String localVarPath = BASEPATH+"/{jobid}/result".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "jobid" + "\\}", apiClient.escapeString(jobid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Get the current ocr result
     * Get the OCR result  This API only returns the OCR when the response status code is 200! In other cases nothing is returned or the Job JSON when it is still being executed
     * @param jobid jobid (required)
     * @return OCRResultResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OCRResultResponse getResult(String jobid) throws ApiException {
        ApiResponse<OCRResultResponse> resp = getResultWithHttpInfo(jobid);
        return resp.getData();
    }

    /**
     * Get the current ocr result
     * Get the OCR result  This API only returns the OCR when the response status code is 200! In other cases nothing is returned or the Job JSON when it is still being executed
     * @param jobid jobid (required)
     * @return ApiResponse&lt;OCRResultResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<OCRResultResponse> getResultWithHttpInfo(String jobid) throws ApiException {
        com.squareup.okhttp.Call call = getResultCall(jobid, null, null);
        Type localVarReturnType = new TypeToken<OCRResultResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the current ocr result (asynchronously)
     * Get the OCR result  This API only returns the OCR when the response status code is 200! In other cases nothing is returned or the Job JSON when it is still being executed
     * @param jobid jobid (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResultAsync(String jobid, final ApiCallback<OCRResultResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getResultCall(jobid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OCRResultResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for submitJob */
    private com.squareup.okhttp.Call submitJobCall(String jobid, OCRJob job, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = job;
        
        // verify the required parameter 'jobid' is set
        if (jobid == null) {
            throw new ApiException("Missing the required parameter 'jobid' when calling submitJob(Async)");
        }
        
        // verify the required parameter 'job' is set
        if (job == null) {
            throw new ApiException("Missing the required parameter 'job' when calling submitJob(Async)");
        }
        

        // create path and map variables
        String localVarPath = BASEPATH+"/{jobid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "jobid" + "\\}", apiClient.escapeString(jobid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json;charset=UTF-8"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Submit OCR job for processing
     * Apply OCR on the previously uploaded file(s), using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     * @param jobid jobid (required)
     * @param job jobEntity (required)
     * @return OCRJobResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OCRJobResponse submitJob(String jobid, OCRJob job) throws ApiException {
        ApiResponse<OCRJobResponse> resp = submitJobWithHttpInfo(jobid, job);
        return resp.getData();
    }

    /**
     * Submit OCR job for processing
     * Apply OCR on the previously uploaded file(s), using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     * @param jobid jobid (required)
     * @param job jobEntity (required)
     * @return ApiResponse&lt;OCRJobResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<OCRJobResponse> submitJobWithHttpInfo(String jobid, OCRJob job) throws ApiException {
        com.squareup.okhttp.Call call = submitJobCall(jobid, job, null, null);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Submit OCR job for processing (asynchronously)
     * Apply OCR on the previously uploaded file(s), using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     * @param jobid jobid (required)
     * @param job jobEntity (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call submitJobAsync(String jobid, OCRJob job, final ApiCallback<OCRJobResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = submitJobCall(jobid, job, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for uploadFile */
    private com.squareup.okhttp.Call uploadFileCall(File stream, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'stream' is set
        if (stream == null) {
            throw new ApiException("Missing the required parameter 'stream' when calling uploadFile(Async)");
        }
        

        // create path and map variables
        String localVarPath = BASEPATH.replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (stream != null)
        localVarFormParams.put("stream", stream);

        final String[] localVarAccepts = {
            "application/json;charset=UTF-8"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2schema" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Upload first file
     * Upload the first image file.
     * @param stream The image file to convert to OCR (required)
     * @return OCRJobResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OCRJobResponse uploadFile(File stream) throws ApiException {
        ApiResponse<OCRJobResponse> resp = uploadFileWithHttpInfo(stream);
        return resp.getData();
    }

    /**
     * Upload first file
     * Upload the first image file.
     * @param stream The image file to convert to OCR (required)
     * @return ApiResponse&lt;OCRJobResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<OCRJobResponse> uploadFileWithHttpInfo(File stream) throws ApiException {
        com.squareup.okhttp.Call call = uploadFileCall(stream, null, null);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Upload first file (asynchronously)
     * Upload the first image file.
     * @param stream The image file to convert to OCR (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call uploadFileAsync(File stream, final ApiCallback<OCRJobResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = uploadFileCall(stream, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OCRJobResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
