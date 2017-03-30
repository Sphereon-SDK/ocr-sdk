/**
 * OCR
 * <b>The OCR API 'ocr' performs Optical Character Resolution on input files.</b>    The flow is generally as follows:  1. First upload an image/file using the /ocr POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /ocr/{jobid} endpoint, with the Job and Settings JSON as request body. The ocr extraction will now start.  3. Check the job status from the /ocr/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the OCR result using the /ocr/{jobid}/result GET endpoint. This will return the OCR result only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.0.0
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

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['com.sphereon.sdk.ocr.handler/ApiClient', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJobResponse', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/ErrorResponse', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRResultResponse', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJob'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../com.sphereon.sdk.ocr.model/OCRJobResponse'), require('../com.sphereon.sdk.ocr.model/ErrorResponse'), require('../com.sphereon.sdk.ocr.model/OCRResultResponse'), require('../com.sphereon.sdk.ocr.model/OCRJob'));
  } else {
    // Browser globals (root is window)
    if (!root.ocr) {
      root.ocr = {};
    }
    root.ocr.OcrApi = factory(root.ocr.ApiClient, root.ocr.OCRJobResponse, root.ocr.ErrorResponse, root.ocr.OCRResultResponse, root.ocr.OCRJob);
  }
}(this, function(ApiClient, OCRJobResponse, ErrorResponse, OCRResultResponse, OCRJob) {
  'use strict';

  /**
   * Ocr service.
   * @module com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.api/OcrApi
   * @version 0.3.2
   */

  /**
   * Constructs a new OcrApi. 
   * @alias module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.api/OcrApi
   * @class
   * @param {module:com.sphereon.sdk.ocr.handler/ApiClient} apiClient Optional API client implementation to use,
   * default to {@link module:com.sphereon.sdk.ocr.handler/ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;



    /**
     * Delete a job manually
     * Delete the OCR job and all related files
     * @param {String} jobid jobid
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJobResponse}
     */
    this.deleteJob = function(jobid) {
      var postBody = null;

      // verify the required parameter 'jobid' is set
      if (jobid == undefined || jobid == null) {
        throw "Missing the required parameter 'jobid' when calling deleteJob";
      }


      var pathParams = {
        'jobid': jobid
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['oauth2schema'];
      var contentTypes = ['application/json'];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = OCRJobResponse;

      return this.apiClient.callApi(
        '/ocr/1.0.0/ocr/{jobid}', 'DELETE',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Job definition and state
     * Get the OCR job definition and current state. Please not that you can differentiate based on http response status
     * @param {String} jobid jobid
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJobResponse}
     */
    this.getJob = function(jobid) {
      var postBody = null;

      // verify the required parameter 'jobid' is set
      if (jobid == undefined || jobid == null) {
        throw "Missing the required parameter 'jobid' when calling getJob";
      }


      var pathParams = {
        'jobid': jobid
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['oauth2schema'];
      var contentTypes = ['application/json'];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = OCRJobResponse;

      return this.apiClient.callApi(
        '/ocr/1.0.0/ocr/{jobid}', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Get all jobs
     * Get all OCR job definitions and their current state.
     * @param {Object} opts Optional parameters
     * @param {Array.<module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/String>} opts.status A list of status to filter on.
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJobResponse}
     */
    this.getJobs = function(opts) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'status': this.apiClient.buildCollectionParam(opts['status'], 'multi')
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['oauth2schema'];
      var contentTypes = ['application/json'];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = OCRJobResponse;

      return this.apiClient.callApi(
        '/ocr/1.0.0/ocr', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Get the current ocr result
     * Get the OCR result  This API only returns the OCR when the response status code is 200! In other cases nothing is returned or the Job JSON when it is still being executed
     * @param {String} jobid jobid
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRResultResponse}
     */
    this.getResult = function(jobid) {
      var postBody = null;

      // verify the required parameter 'jobid' is set
      if (jobid == undefined || jobid == null) {
        throw "Missing the required parameter 'jobid' when calling getResult";
      }


      var pathParams = {
        'jobid': jobid
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['oauth2schema'];
      var contentTypes = ['application/json'];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = OCRResultResponse;

      return this.apiClient.callApi(
        '/ocr/1.0.0/ocr/{jobid}/result', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Submit OCR job for processing
     * Apply OCR on the previously uploaded file(s), using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status INPUTS_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     * @param {String} jobid jobid
     * @param {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJob} job jobEntity
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJobResponse}
     */
    this.submitJob = function(jobid, job) {
      var postBody = job;

      // verify the required parameter 'jobid' is set
      if (jobid == undefined || jobid == null) {
        throw "Missing the required parameter 'jobid' when calling submitJob";
      }

      // verify the required parameter 'job' is set
      if (job == undefined || job == null) {
        throw "Missing the required parameter 'job' when calling submitJob";
      }


      var pathParams = {
        'jobid': jobid
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['oauth2schema'];
      var contentTypes = ['application/json;charset=UTF-8'];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = OCRJobResponse;

      return this.apiClient.callApi(
        '/ocr/1.0.0/ocr/{jobid}', 'PUT',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Upload first file
     * Upload the first image file.
     * @param {File} stream The image file to convert to OCR
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJobResponse}
     */
    this.uploadFile = function(stream) {
      var postBody = null;

      // verify the required parameter 'stream' is set
      if (stream == undefined || stream == null) {
        throw "Missing the required parameter 'stream' when calling uploadFile";
      }


      var pathParams = {
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
        'stream': stream
      };

      var authNames = ['oauth2schema'];
      var contentTypes = ['multipart/form-data'];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = OCRJobResponse;

      return this.apiClient.callApi(
        '/ocr/1.0.0/ocr', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }
  };

  return exports;
}));