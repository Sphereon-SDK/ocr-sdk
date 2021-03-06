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


package com.sphereon.sdk.ocr.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import com.sphereon.sdk.ocr.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * OCR Result
 */
@ApiModel(description = "OCR Result")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-07-10T16:52:55.758+02:00")
public class OCRResult   {
  @SerializedName("pages")
  private List<Page> pages = new ArrayList<Page>();

  /**
   * Gets or Sets engines
   */
  public enum EnginesEnum {
    @SerializedName("ADVANCED")
    ADVANCED("ADVANCED"),
    
    @SerializedName("PREMIUM")
    PREMIUM("PREMIUM"),
    
    @SerializedName("BASIC")
    BASIC("BASIC");

    private String value;

    EnginesEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("engines")
  private List<EnginesEnum> engines = new ArrayList<EnginesEnum>();

  @SerializedName("id")
  private String id = null;

  public OCRResult pages(List<Page> pages) {
    this.pages = pages;
    return this;
  }

  public OCRResult addPagesItem(Page pagesItem) {
    this.pages.add(pagesItem);
    return this;
  }

   /**
   * pages
   * @return pages
  **/
  @ApiModelProperty(example = "null", required = true, value = "pages")
  public List<Page> getPages() {
    return pages;
  }

  public void setPages(List<Page> pages) {
    this.pages = pages;
  }

  public OCRResult engines(List<EnginesEnum> engines) {
    this.engines = engines;
    return this;
  }

  public OCRResult addEnginesItem(EnginesEnum enginesItem) {
    this.engines.add(enginesItem);
    return this;
  }

   /**
   * OCR engines used
   * @return engines
  **/
  @ApiModelProperty(example = "null", required = true, value = "OCR engines used")
  public List<EnginesEnum> getEngines() {
    return engines;
  }

  public void setEngines(List<EnginesEnum> engines) {
    this.engines = engines;
  }

  public OCRResult id(String id) {
    this.id = id;
    return this;
  }

   /**
   * unique id
   * @return id
  **/
  @ApiModelProperty(example = "null", required = true, value = "unique id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OCRResult oCRResult = (OCRResult) o;
    return Objects.equals(this.pages, oCRResult.pages) &&
        Objects.equals(this.engines, oCRResult.engines) &&
        Objects.equals(this.id, oCRResult.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pages, engines, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OCRResult {\n");
    
    sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
    sb.append("    engines: ").append(toIndentedString(engines)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

