/* 
 * OCR
 *
 * <b>The OCR API 'ocr' performs Optical Character Resolution on input files.</b>    The flow is generally as follows:  1. First upload an image/file using the /ocr POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /ocr/{jobid} endpoint, with the Job and Settings JSON as request body. The ocr extraction will now start.  3. Check the job status from the /ocr/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the OCR result using the /ocr/{jobid}/result GET endpoint. This will return the OCR result only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
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
    /// pass
    /// </summary>
    [DataContract]
    public partial class Pass :  IEquatable<Pass>
    {
        /// <summary>
        /// OCR engine used in this pass
        /// </summary>
        /// <value>OCR engine used in this pass</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum EngineEnum
        {
            
            /// <summary>
            /// Enum ADVANCED for "ADVANCED"
            /// </summary>
            [EnumMember(Value = "ADVANCED")]
            ADVANCED,
            
            /// <summary>
            /// Enum PREMIUM for "PREMIUM"
            /// </summary>
            [EnumMember(Value = "PREMIUM")]
            PREMIUM,
            
            /// <summary>
            /// Enum BASIC for "BASIC"
            /// </summary>
            [EnumMember(Value = "BASIC")]
            BASIC
        }

        /// <summary>
        /// OCR engine used in this pass
        /// </summary>
        /// <value>OCR engine used in this pass</value>
        [DataMember(Name="engine", EmitDefaultValue=false)]
        public EngineEnum? Engine { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="Pass" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Pass() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Pass" /> class.
        /// </summary>
        /// <param name="Engine">OCR engine used in this pass (required).</param>
        /// <param name="_Pass">pass number (required).</param>
        /// <param name="Words">words found by OCR engine (required).</param>
        /// <param name="Lines">lines found by OCR engine (required).</param>
        public Pass(EngineEnum? Engine = null, int? _Pass = null, List<Word> Words = null, List<Line> Lines = null)
        {
            // to ensure "Engine" is required (not null)
            if (Engine == null)
            {
                throw new InvalidDataException("Engine is a required property for Pass and cannot be null");
            }
            else
            {
                this.Engine = Engine;
            }
            // to ensure "_Pass" is required (not null)
            if (_Pass == null)
            {
                throw new InvalidDataException("_Pass is a required property for Pass and cannot be null");
            }
            else
            {
                this._Pass = _Pass;
            }
            // to ensure "Words" is required (not null)
            if (Words == null)
            {
                throw new InvalidDataException("Words is a required property for Pass and cannot be null");
            }
            else
            {
                this.Words = Words;
            }
            // to ensure "Lines" is required (not null)
            if (Lines == null)
            {
                throw new InvalidDataException("Lines is a required property for Pass and cannot be null");
            }
            else
            {
                this.Lines = Lines;
            }
        }
        
        /// <summary>
        /// pass number
        /// </summary>
        /// <value>pass number</value>
        [DataMember(Name="pass", EmitDefaultValue=false)]
        public int? _Pass { get; set; }
        /// <summary>
        /// words found by OCR engine
        /// </summary>
        /// <value>words found by OCR engine</value>
        [DataMember(Name="words", EmitDefaultValue=false)]
        public List<Word> Words { get; set; }
        /// <summary>
        /// lines found by OCR engine
        /// </summary>
        /// <value>lines found by OCR engine</value>
        [DataMember(Name="lines", EmitDefaultValue=false)]
        public List<Line> Lines { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Pass {\n");
            sb.Append("  Engine: ").Append(Engine).Append("\n");
            sb.Append("  _Pass: ").Append(_Pass).Append("\n");
            sb.Append("  Words: ").Append(Words).Append("\n");
            sb.Append("  Lines: ").Append(Lines).Append("\n");
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
            return this.Equals(obj as Pass);
        }

        /// <summary>
        /// Returns true if Pass instances are equal
        /// </summary>
        /// <param name="other">Instance of Pass to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Pass other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Engine == other.Engine ||
                    this.Engine != null &&
                    this.Engine.Equals(other.Engine)
                ) && 
                (
                    this._Pass == other._Pass ||
                    this._Pass != null &&
                    this._Pass.Equals(other._Pass)
                ) && 
                (
                    this.Words == other.Words ||
                    this.Words != null &&
                    this.Words.SequenceEqual(other.Words)
                ) && 
                (
                    this.Lines == other.Lines ||
                    this.Lines != null &&
                    this.Lines.SequenceEqual(other.Lines)
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
                if (this.Engine != null)
                    hash = hash * 59 + this.Engine.GetHashCode();
                if (this._Pass != null)
                    hash = hash * 59 + this._Pass.GetHashCode();
                if (this.Words != null)
                    hash = hash * 59 + this.Words.GetHashCode();
                if (this.Lines != null)
                    hash = hash * 59 + this.Lines.GetHashCode();
                return hash;
            }
        }
    }

}
