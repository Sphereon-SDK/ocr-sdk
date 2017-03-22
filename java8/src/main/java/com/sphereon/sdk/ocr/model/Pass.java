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


package com.sphereon.sdk.ocr.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import com.sphereon.sdk.ocr.model.Line;
import com.sphereon.sdk.ocr.model.Word;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * pass
 */
@ApiModel(description = "pass")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-03-22T10:09:02.404+01:00")
public class Pass   {
  /**
   * OCR engine used in this pass
   */
  public enum EngineEnum {
    @SerializedName("ADVANCED")
    ADVANCED("ADVANCED"),
    
    @SerializedName("PREMIUM")
    PREMIUM("PREMIUM"),
    
    @SerializedName("BASIC")
    BASIC("BASIC");

    private String value;

    EngineEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("engine")
  private EngineEnum engine = null;

  @SerializedName("pass")
  private Integer pass = null;

  @SerializedName("words")
  private List<Word> words = new ArrayList<Word>();

  @SerializedName("lines")
  private List<Line> lines = new ArrayList<Line>();

  public Pass engine(EngineEnum engine) {
    this.engine = engine;
    return this;
  }

   /**
   * OCR engine used in this pass
   * @return engine
  **/
  @ApiModelProperty(example = "null", required = true, value = "OCR engine used in this pass")
  public EngineEnum getEngine() {
    return engine;
  }

  public void setEngine(EngineEnum engine) {
    this.engine = engine;
  }

  public Pass pass(Integer pass) {
    this.pass = pass;
    return this;
  }

   /**
   * pass number
   * @return pass
  **/
  @ApiModelProperty(example = "null", required = true, value = "pass number")
  public Integer getPass() {
    return pass;
  }

  public void setPass(Integer pass) {
    this.pass = pass;
  }

  public Pass words(List<Word> words) {
    this.words = words;
    return this;
  }

  public Pass addWordsItem(Word wordsItem) {
    this.words.add(wordsItem);
    return this;
  }

   /**
   * words found by OCR engine
   * @return words
  **/
  @ApiModelProperty(example = "null", required = true, value = "words found by OCR engine")
  public List<Word> getWords() {
    return words;
  }

  public void setWords(List<Word> words) {
    this.words = words;
  }

  public Pass lines(List<Line> lines) {
    this.lines = lines;
    return this;
  }

  public Pass addLinesItem(Line linesItem) {
    this.lines.add(linesItem);
    return this;
  }

   /**
   * lines found by OCR engine
   * @return lines
  **/
  @ApiModelProperty(example = "null", required = true, value = "lines found by OCR engine")
  public List<Line> getLines() {
    return lines;
  }

  public void setLines(List<Line> lines) {
    this.lines = lines;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pass pass = (Pass) o;
    return Objects.equals(this.engine, pass.engine) &&
        Objects.equals(this.pass, pass.pass) &&
        Objects.equals(this.words, pass.words) &&
        Objects.equals(this.lines, pass.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(engine, pass, words, lines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pass {\n");
    
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    pass: ").append(toIndentedString(pass)).append("\n");
    sb.append("    words: ").append(toIndentedString(words)).append("\n");
    sb.append("    lines: ").append(toIndentedString(lines)).append("\n");
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

