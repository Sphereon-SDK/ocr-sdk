/* 
 * OCR 
 *
 * <b>The OCR API 'ocr' extracts ocr from input files.</b>    The flow is generally as follows:  1. First upload an image/file using the /ocr POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /ocr/{jobid} endpoint, with the Job and Settings JSON as request body. The ocr extraction will now start.  3. Check the job status from the /ocr/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the OCR result using the /ocr/{jobid}/result GET endpoint. This will return the OCR result only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@sphereon.com
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;

namespace Sphereon.SDK.Ocr.Model
{
    /// <summary>
    /// Item
    /// </summary>
    [DataContract]
    public partial class Item :  IEquatable<Item>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Item" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Item() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Item" /> class.
        /// </summary>
        /// <param name="Confidence">confidence value of the text found by the OCR engine (required).</param>
        /// <param name="Text">the text found by the OCR engine (required).</param>
        /// <param name="Region">Region (required).</param>
        public Item(float? Confidence = null, string Text = null, Region Region = null)
        {
            // to ensure "Confidence" is required (not null)
            if (Confidence == null)
            {
                throw new InvalidDataException("Confidence is a required property for Item and cannot be null");
            }
            else
            {
                this.Confidence = Confidence;
            }
            // to ensure "Text" is required (not null)
            if (Text == null)
            {
                throw new InvalidDataException("Text is a required property for Item and cannot be null");
            }
            else
            {
                this.Text = Text;
            }
            // to ensure "Region" is required (not null)
            if (Region == null)
            {
                throw new InvalidDataException("Region is a required property for Item and cannot be null");
            }
            else
            {
                this.Region = Region;
            }
        }
        
        /// <summary>
        /// confidence value of the text found by the OCR engine
        /// </summary>
        /// <value>confidence value of the text found by the OCR engine</value>
        [DataMember(Name="confidence", EmitDefaultValue=false)]
        public float? Confidence { get; set; }
        /// <summary>
        /// the text found by the OCR engine
        /// </summary>
        /// <value>the text found by the OCR engine</value>
        [DataMember(Name="text", EmitDefaultValue=false)]
        public string Text { get; set; }
        /// <summary>
        /// Gets or Sets Region
        /// </summary>
        [DataMember(Name="region", EmitDefaultValue=false)]
        public Region Region { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Item {\n");
            sb.Append("  Confidence: ").Append(Confidence).Append("\n");
            sb.Append("  Text: ").Append(Text).Append("\n");
            sb.Append("  Region: ").Append(Region).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }
  
        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="obj">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object obj)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            return this.Equals(obj as Item);
        }

        /// <summary>
        /// Returns true if Item instances are equal
        /// </summary>
        /// <param name="other">Instance of Item to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Item other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Confidence == other.Confidence ||
                    this.Confidence != null &&
                    this.Confidence.Equals(other.Confidence)
                ) && 
                (
                    this.Text == other.Text ||
                    this.Text != null &&
                    this.Text.Equals(other.Text)
                ) && 
                (
                    this.Region == other.Region ||
                    this.Region != null &&
                    this.Region.Equals(other.Region)
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            // credit: http://stackoverflow.com/a/263416/677735
            unchecked // Overflow is fine, just wrap
            {
                int hash = 41;
                // Suitable nullity checks etc, of course :)
                if (this.Confidence != null)
                    hash = hash * 59 + this.Confidence.GetHashCode();
                if (this.Text != null)
                    hash = hash * 59 + this.Text.GetHashCode();
                if (this.Region != null)
                    hash = hash * 59 + this.Region.GetHashCode();
                return hash;
            }
        }
    }

}
