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
    define(['com.sphereon.sdk.ocr.handler/ApiClient', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Line', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Word'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./Line'), require('./Word'));
  } else {
    // Browser globals (root is window)
    if (!root.ocr) {
      root.ocr = {};
    }
    root.ocr.Pass = factory(root.ocr.ApiClient, root.ocr.Line, root.ocr.Word);
  }
}(this, function(ApiClient, Line, Word) {
  'use strict';




  /**
   * The Pass model module.
   * @module com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Pass
   * @version 0.3.2
   */

  /**
   * Constructs a new <code>Pass</code>.
   * pass
   * @alias module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Pass
   * @class
   * @param engine {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Pass.EngineEnum} OCR engine used in this pass
   * @param pass {Integer} OCR pass number
   * @param words {Array.<module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Word>} words found by OCR engine
   */
  var exports = function(engine, pass, words) {
    var _this = this;

    _this['engine'] = engine;
    _this['pass'] = pass;
    _this['words'] = words;

  };

  /**
   * Constructs a <code>Pass</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Pass} obj Optional instance to populate.
   * @return {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Pass} The populated <code>Pass</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('engine')) {
        obj['engine'] = ApiClient.convertToType(data['engine'], 'String');
      }
      if (data.hasOwnProperty('pass')) {
        obj['pass'] = ApiClient.convertToType(data['pass'], 'Integer');
      }
      if (data.hasOwnProperty('words')) {
        obj['words'] = ApiClient.convertToType(data['words'], [Word]);
      }
      if (data.hasOwnProperty('lines')) {
        obj['lines'] = ApiClient.convertToType(data['lines'], [Line]);
      }
    }
    return obj;
  }

  /**
   * OCR engine used in this pass
   * @member {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Pass.EngineEnum} engine
   */
  exports.prototype['engine'] = undefined;
  /**
   * OCR pass number
   * @member {Integer} pass
   */
  exports.prototype['pass'] = undefined;
  /**
   * words found by OCR engine
   * @member {Array.<module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Word>} words
   */
  exports.prototype['words'] = undefined;
  /**
   * lines found by OCR engine (when supported by engine)
   * @member {Array.<module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Line>} lines
   */
  exports.prototype['lines'] = undefined;


  /**
   * Allowed values for the <code>engine</code> property.
   * @enum {String}
   * @readonly
   */
  exports.EngineEnum = {
    /**
     * value: "ADVANCED"
     * @const
     */
    "ADVANCED": "ADVANCED",
    /**
     * value: "PREMIUM"
     * @const
     */
    "PREMIUM": "PREMIUM",
    /**
     * value: "BASIC"
     * @const
     */
    "BASIC": "BASIC"  };


  return exports;
}));

