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
    /// OCR settings
    /// </summary>
    [DataContract]
    public partial class OCRSettings :  IEquatable<OCRSettings>
    {
        /// <summary>
        /// Gets or Sets Engine
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum EngineEnum
        {
            
            /// <summary>
            /// Enum BASIC for "BASIC"
            /// </summary>
            [EnumMember(Value = "BASIC")]
            BASIC,
            
            /// <summary>
            /// Enum ADVANCED for "ADVANCED"
            /// </summary>
            [EnumMember(Value = "ADVANCED")]
            ADVANCED,
            
            /// <summary>
            /// Enum PREMIUM for "PREMIUM"
            /// </summary>
            [EnumMember(Value = "PREMIUM")]
            PREMIUM
        }

        /// <summary>
        /// Gets or Sets Engine
        /// </summary>
        [DataMember(Name="engine", EmitDefaultValue=false)]
        public EngineEnum? Engine { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="OCRSettings" /> class.
        /// </summary>
        /// <param name="Lifecycle">Lifecycle.</param>
        /// <param name="Engine">Engine.</param>
        /// <param name="RegionSettings">RegionSettings.</param>
        public OCRSettings(Lifecycle Lifecycle = null, EngineEnum? Engine = null, RegionSettings RegionSettings = null)
        {
            this.Lifecycle = Lifecycle;
            this.Engine = Engine;
            this.RegionSettings = RegionSettings;
        }
        
        /// <summary>
        /// Gets or Sets Lifecycle
        /// </summary>
        [DataMember(Name="lifecycle", EmitDefaultValue=false)]
        public Lifecycle Lifecycle { get; set; }
        /// <summary>
        /// Gets or Sets RegionSettings
        /// </summary>
        [DataMember(Name="regionSettings", EmitDefaultValue=false)]
        public RegionSettings RegionSettings { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class OCRSettings {\n");
            sb.Append("  Lifecycle: ").Append(Lifecycle).Append("\n");
            sb.Append("  Engine: ").Append(Engine).Append("\n");
            sb.Append("  RegionSettings: ").Append(RegionSettings).Append("\n");
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
            return this.Equals(obj as OCRSettings);
        }

        /// <summary>
        /// Returns true if OCRSettings instances are equal
        /// </summary>
        /// <param name="other">Instance of OCRSettings to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(OCRSettings other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Lifecycle == other.Lifecycle ||
                    this.Lifecycle != null &&
                    this.Lifecycle.Equals(other.Lifecycle)
                ) && 
                (
                    this.Engine == other.Engine ||
                    this.Engine != null &&
                    this.Engine.Equals(other.Engine)
                ) && 
                (
                    this.RegionSettings == other.RegionSettings ||
                    this.RegionSettings != null &&
                    this.RegionSettings.Equals(other.RegionSettings)
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
                if (this.Lifecycle != null)
                    hash = hash * 59 + this.Lifecycle.GetHashCode();
                if (this.Engine != null)
                    hash = hash * 59 + this.Engine.GetHashCode();
                if (this.RegionSettings != null)
                    hash = hash * 59 + this.RegionSettings.GetHashCode();
                return hash;
            }
        }
    }

}
