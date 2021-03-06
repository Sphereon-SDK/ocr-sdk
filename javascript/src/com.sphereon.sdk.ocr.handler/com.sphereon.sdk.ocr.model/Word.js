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
    define(['com.sphereon.sdk.ocr.handler/ApiClient', 'com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Region'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./Region'));
  } else {
    // Browser globals (root is window)
    if (!root.ocr) {
      root.ocr = {};
    }
    root.ocr.Word = factory(root.ocr.ApiClient, root.ocr.Region);
  }
}(this, function(ApiClient, Region) {
  'use strict';




  /**
   * The Word model module.
   * @module com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Word
   * @version 0.3.2
   */

  /**
   * Constructs a new <code>Word</code>.
   * word
   * @alias module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Word
   * @class
   * @param text {String} the text found by the OCR engine
   * @param region {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Region} 
   */
  var exports = function(text, region) {
    var _this = this;





    _this['text'] = text;
    _this['region'] = region;
  };

  /**
   * Constructs a <code>Word</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Word} obj Optional instance to populate.
   * @return {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Word} The populated <code>Word</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('top')) {
        obj['top'] = ApiClient.convertToType(data['top'], 'Integer');
      }
      if (data.hasOwnProperty('left')) {
        obj['left'] = ApiClient.convertToType(data['left'], 'Integer');
      }
      if (data.hasOwnProperty('bottom')) {
        obj['bottom'] = ApiClient.convertToType(data['bottom'], 'Integer');
      }
      if (data.hasOwnProperty('right')) {
        obj['right'] = ApiClient.convertToType(data['right'], 'Integer');
      }
      if (data.hasOwnProperty('text')) {
        obj['text'] = ApiClient.convertToType(data['text'], 'String');
      }
      if (data.hasOwnProperty('region')) {
        obj['region'] = Region.constructFromObject(data['region']);
      }
    }
    return obj;
  }

  /**
   * Simple location. See RegionSettings for more advanced location/region responses
   * @member {Integer} top
   */
  exports.prototype['top'] = undefined;
  /**
   * Simple location. See RegionSettings for more advanced location/region responses
   * @member {Integer} left
   */
  exports.prototype['left'] = undefined;
  /**
   * Simple location. See RegionSettings for more advanced location/region responses
   * @member {Integer} bottom
   */
  exports.prototype['bottom'] = undefined;
  /**
   * Simple location. See RegionSettings for more advanced location/region responses
   * @member {Integer} right
   */
  exports.prototype['right'] = undefined;
  /**
   * the text found by the OCR engine
   * @member {String} text
   */
  exports.prototype['text'] = undefined;
  /**
   * @member {module:com.sphereon.sdk.ocr.handler/com.sphereon.sdk.ocr.model/Region} region
   */
  exports.prototype['region'] = undefined;



  return exports;
}));


