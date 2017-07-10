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
import com.sphereon.sdk.ocr.model.Anchor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * region
 */
@ApiModel(description = "region")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-07-10T16:52:55.758+02:00")
public class Region   {
  @SerializedName("bottomLeft")
  private Anchor bottomLeft = null;

  @SerializedName("bottomRight")
  private Anchor bottomRight = null;

  @SerializedName("center")
  private Anchor center = null;

  @SerializedName("topLeft")
  private Anchor topLeft = null;

  @SerializedName("topRight")
  private Anchor topRight = null;

  public Region bottomLeft(Anchor bottomLeft) {
    this.bottomLeft = bottomLeft;
    return this;
  }

   /**
   * Get bottomLeft
   * @return bottomLeft
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Anchor getBottomLeft() {
    return bottomLeft;
  }

  public void setBottomLeft(Anchor bottomLeft) {
    this.bottomLeft = bottomLeft;
  }

  public Region bottomRight(Anchor bottomRight) {
    this.bottomRight = bottomRight;
    return this;
  }

   /**
   * Get bottomRight
   * @return bottomRight
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Anchor getBottomRight() {
    return bottomRight;
  }

  public void setBottomRight(Anchor bottomRight) {
    this.bottomRight = bottomRight;
  }

  public Region center(Anchor center) {
    this.center = center;
    return this;
  }

   /**
   * Get center
   * @return center
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Anchor getCenter() {
    return center;
  }

  public void setCenter(Anchor center) {
    this.center = center;
  }

  public Region topLeft(Anchor topLeft) {
    this.topLeft = topLeft;
    return this;
  }

   /**
   * Get topLeft
   * @return topLeft
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Anchor getTopLeft() {
    return topLeft;
  }

  public void setTopLeft(Anchor topLeft) {
    this.topLeft = topLeft;
  }

  public Region topRight(Anchor topRight) {
    this.topRight = topRight;
    return this;
  }

   /**
   * Get topRight
   * @return topRight
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Anchor getTopRight() {
    return topRight;
  }

  public void setTopRight(Anchor topRight) {
    this.topRight = topRight;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Region region = (Region) o;
    return Objects.equals(this.bottomLeft, region.bottomLeft) &&
        Objects.equals(this.bottomRight, region.bottomRight) &&
        Objects.equals(this.center, region.center) &&
        Objects.equals(this.topLeft, region.topLeft) &&
        Objects.equals(this.topRight, region.topRight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bottomLeft, bottomRight, center, topLeft, topRight);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Region {\n");
    
    sb.append("    bottomLeft: ").append(toIndentedString(bottomLeft)).append("\n");
    sb.append("    bottomRight: ").append(toIndentedString(bottomRight)).append("\n");
    sb.append("    center: ").append(toIndentedString(center)).append("\n");
    sb.append("    topLeft: ").append(toIndentedString(topLeft)).append("\n");
    sb.append("    topRight: ").append(toIndentedString(topRight)).append("\n");
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

