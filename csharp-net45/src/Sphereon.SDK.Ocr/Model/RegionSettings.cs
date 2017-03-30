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
    /// Region settings. For now you can specify 3 result mode for regions/coordinates in a lost. Simple, Relative regions and Absolute regions
    /// </summary>
    [DataContract]
    public partial class RegionSettings :  IEquatable<RegionSettings>
    {

        /// <summary>
        /// Gets or Sets ResultModes
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum ResultModesEnum
        {
            
            /// <summary>
            /// Enum SIMPLEINLINE for "SIMPLE_INLINE"
            /// </summary>
            [EnumMember(Value = "SIMPLE_INLINE")]
            SIMPLEINLINE,
            
            /// <summary>
            /// Enum ABSOLUTEPOINTS for "ABSOLUTE_POINTS"
            /// </summary>
            [EnumMember(Value = "ABSOLUTE_POINTS")]
            ABSOLUTEPOINTS,
            
            /// <summary>
            /// Enum RELATIVEPOINTS for "RELATIVE_POINTS"
            /// </summary>
            [EnumMember(Value = "RELATIVE_POINTS")]
            RELATIVEPOINTS
        }

        /// <summary>
        /// Gets or Sets ResultModes
        /// </summary>
        [DataMember(Name="resultModes", EmitDefaultValue=false)]
        public List<ResultModesEnum> ResultModes { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="RegionSettings" /> class.
        /// </summary>
        /// <param name="ResultModes">ResultModes.</param>
        public RegionSettings(List<ResultModesEnum> ResultModes = null)
        {
            this.ResultModes = ResultModes;
        }
        
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class RegionSettings {\n");
            sb.Append("  ResultModes: ").Append(ResultModes).Append("\n");
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
            return this.Equals(obj as RegionSettings);
        }

        /// <summary>
        /// Returns true if RegionSettings instances are equal
        /// </summary>
        /// <param name="other">Instance of RegionSettings to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(RegionSettings other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.ResultModes == other.ResultModes ||
                    this.ResultModes != null &&
                    this.ResultModes.SequenceEqual(other.ResultModes)
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
                if (this.ResultModes != null)
                    hash = hash * 59 + this.ResultModes.GetHashCode();
                return hash;
            }
        }
    }

}
