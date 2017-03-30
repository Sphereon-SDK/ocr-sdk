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

(function(factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['com.sphereon.sdk.ocr.handler/ApiClient', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Anchor', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Error', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/ErrorResponse', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Input', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Lifecycle', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Line', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJob', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJobResponse', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRResult', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRResultResponse', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRSettings', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRTask', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Page', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Pass', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Point', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Region', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/RegionSettings', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Word', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.api/OcrApi'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('./ApiClient'), require('./com.sphereon.sdk.ocr.model/Anchor'), require('./com.sphereon.sdk.ocr.model/Error'), require('./com.sphereon.sdk.ocr.model/ErrorResponse'), require('./com.sphereon.sdk.ocr.model/Input'), require('./com.sphereon.sdk.ocr.model/Lifecycle'), require('./com.sphereon.sdk.ocr.model/Line'), require('./com.sphereon.sdk.ocr.model/OCRJob'), require('./com.sphereon.sdk.ocr.model/OCRJobResponse'), require('./com.sphereon.sdk.ocr.model/OCRResult'), require('./com.sphereon.sdk.ocr.model/OCRResultResponse'), require('./com.sphereon.sdk.ocr.model/OCRSettings'), require('./com.sphereon.sdk.ocr.model/OCRTask'), require('./com.sphereon.sdk.ocr.model/Page'), require('./com.sphereon.sdk.ocr.model/Pass'), require('./com.sphereon.sdk.ocr.model/Point'), require('./com.sphereon.sdk.ocr.model/Region'), require('./com.sphereon.sdk.ocr.model/RegionSettings'), require('./com.sphereon.sdk.ocr.model/Word'), require('./com.sphereon.sdk.ocr.api/OcrApi'));
  }
}(function(ApiClient, Anchor, Error, ErrorResponse, Input, Lifecycle, Line, OCRJob, OCRJobResponse, OCRResult, OCRResultResponse, OCRSettings, OCRTask, Page, Pass, Point, Region, RegionSettings, Word, OcrApi) {
  'use strict';

  /**
   * OCR Javascript SDK.<br>
   * The <code>index</code> module provides access to constructors for all the classes which comprise the public API.
   * <p>
   * An AMD (recommended!) or CommonJS application will generally do something equivalent to the following:
   * <pre>
   * var ocr = require('com.sphereon.sdk.ocr.handler/index'); // See note below*.
   * var xxxSvc = new ocr.XxxApi(); // Allocate the API class we're going to use.
   * var yyyModel = new ocr.Yyy(); // Construct a model instance.
   * yyyModel.someProperty = 'someValue';
   * ...
   * var zzz = xxxSvc.doSomething(yyyModel); // Invoke the service.
   * ...
   * </pre>
   * <em>*NOTE: For a top-level AMD script, use require(['com.sphereon.sdk.ocr.handler/index'], function(){...})
   * and put the application logic within the callback function.</em>
   * </p>
   * <p>
   * A non-AMD browser application (discouraged) might do something like this:
   * <pre>
   * var xxxSvc = new ocr.XxxApi(); // Allocate the API class we're going to use.
   * var yyy = new ocr.Yyy(); // Construct a model instance.
   * yyyModel.someProperty = 'someValue';
   * ...
   * var zzz = xxxSvc.doSomething(yyyModel); // Invoke the service.
   * ...
   * </pre>
   * </p>
   * @module com.sphereon.sdk.ocr.handler/index
   * @version 0.3.2
   */
  var exports = {
    /**
     * The ApiClient constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/ApiClient}
     */
    ApiClient: ApiClient,
    /**
     * The Anchor model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Anchor}
     */
    Anchor: Anchor,
    /**
     * The Error model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Error}
     */
    Error: Error,
    /**
     * The ErrorResponse model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/ErrorResponse}
     */
    ErrorResponse: ErrorResponse,
    /**
     * The Input model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Input}
     */
    Input: Input,
    /**
     * The Lifecycle model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Lifecycle}
     */
    Lifecycle: Lifecycle,
    /**
     * The Line model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Line}
     */
    Line: Line,
    /**
     * The OCRJob model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJob}
     */
    OCRJob: OCRJob,
    /**
     * The OCRJobResponse model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRJobResponse}
     */
    OCRJobResponse: OCRJobResponse,
    /**
     * The OCRResult model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRResult}
     */
    OCRResult: OCRResult,
    /**
     * The OCRResultResponse model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRResultResponse}
     */
    OCRResultResponse: OCRResultResponse,
    /**
     * The OCRSettings model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRSettings}
     */
    OCRSettings: OCRSettings,
    /**
     * The OCRTask model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/OCRTask}
     */
    OCRTask: OCRTask,
    /**
     * The Page model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Page}
     */
    Page: Page,
    /**
     * The Pass model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Pass}
     */
    Pass: Pass,
    /**
     * The Point model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Point}
     */
    Point: Point,
    /**
     * The Region model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Region}
     */
    Region: Region,
    /**
     * The RegionSettings model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/RegionSettings}
     */
    RegionSettings: RegionSettings,
    /**
     * The Word model constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Word}
     */
    Word: Word,
    /**
     * The OcrApi service constructor.
     * @property {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.api/OcrApi}
     */
    OcrApi: OcrApi
  };

  return exports;
}));
