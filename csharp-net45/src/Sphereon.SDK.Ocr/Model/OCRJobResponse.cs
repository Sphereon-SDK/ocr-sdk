/* 
 * OCR
 *
 * <b>The OCR API 'ocr' performs Optical Character Resolution on input files.</b>    The flow is generally as follows:  1. First upload an image/file using the /ocr POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /ocr/{jobid} endpoint, with the Job and Settings JSON as request body. The ocr extraction will now start.  3. Check the job status from the /ocr/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the OCR result using the /ocr/{jobid}/result GET endpoint. This will return the OCR result only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 1.0
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
    /// The OCR job. Has access to the job settings as well as ocr engine tasks
    /// </summary>
    [DataContract]
    public partial class OCRJobResponse :  IEquatable<OCRJobResponse>
    {
        /// <summary>
        /// The status of the job
        /// </summary>
        /// <value>The status of the job</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum StatusEnum
        {
            
            /// <summary>
            /// Enum INPUTSUPLOADED for "INPUTS_UPLOADED"
            /// </summary>
            [EnumMember(Value = "INPUTS_UPLOADED")]
            INPUTSUPLOADED,
            
            /// <summary>
            /// Enum PROCESSING for "PROCESSING"
            /// </summary>
            [EnumMember(Value = "PROCESSING")]
            PROCESSING,
            
            /// <summary>
            /// Enum DONE for "DONE"
            /// </summary>
            [EnumMember(Value = "DONE")]
            DONE,
            
            /// <summary>
            /// Enum ERROR for "ERROR"
            /// </summary>
            [EnumMember(Value = "ERROR")]
            ERROR,
            
            /// <summary>
            /// Enum DELETED for "DELETED"
            /// </summary>
            [EnumMember(Value = "DELETED")]
            DELETED
        }

        /// <summary>
        /// The status of the job
        /// </summary>
        /// <value>The status of the job</value>
        [DataMember(Name="status", EmitDefaultValue=false)]
        public StatusEnum? Status { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="OCRJobResponse" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected OCRJobResponse() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="OCRJobResponse" /> class.
        /// </summary>
        /// <param name="JobId">JobId.</param>
        /// <param name="Inputs">The original input files. Currently supported inputs are: tiffs (required).</param>
        /// <param name="Job">Job.</param>
        /// <param name="Tasks">The server supplied OCR task(s).</param>
        public OCRJobResponse(string JobId = null, List<string> Inputs = null, OCRJob Job = null, List<OCRTask> Tasks = null)
        {
            // to ensure "Inputs" is required (not null)
            if (Inputs == null)
            {
                throw new InvalidDataException("Inputs is a required property for OCRJobResponse and cannot be null");
            }
            else
            {
                this.Inputs = Inputs;
            }
            this.JobId = JobId;
            this.Job = Job;
            this.Tasks = Tasks;
        }
        
        /// <summary>
        /// The completion date/time of this job in ISO 8601 format
        /// </summary>
        /// <value>The completion date/time of this job in ISO 8601 format</value>
        [DataMember(Name="completionTime", EmitDefaultValue=false)]
        public DateTime? CompletionTime { get; private set; }
        /// <summary>
        /// Gets or Sets JobId
        /// </summary>
        [DataMember(Name="jobId", EmitDefaultValue=false)]
        public string JobId { get; set; }
        /// <summary>
        /// The creation date/time of this job in ISO 8601 format
        /// </summary>
        /// <value>The creation date/time of this job in ISO 8601 format</value>
        [DataMember(Name="creationTime", EmitDefaultValue=false)]
        public DateTime? CreationTime { get; private set; }
        /// <summary>
        /// The original input files. Currently supported inputs are: tiffs
        /// </summary>
        /// <value>The original input files. Currently supported inputs are: tiffs</value>
        [DataMember(Name="inputs", EmitDefaultValue=false)]
        public List<string> Inputs { get; set; }
        /// <summary>
        /// The last update date/time of this job in ISO 8601 format
        /// </summary>
        /// <value>The last update date/time of this job in ISO 8601 format</value>
        [DataMember(Name="updateTime", EmitDefaultValue=false)]
        public DateTime? UpdateTime { get; private set; }
        /// <summary>
        /// Gets or Sets Job
        /// </summary>
        [DataMember(Name="job", EmitDefaultValue=false)]
        public OCRJob Job { get; set; }
        /// <summary>
        /// A status message, which can be informational, warning or error. AA message here does not indicate an error perse
        /// </summary>
        /// <value>A status message, which can be informational, warning or error. AA message here does not indicate an error perse</value>
        [DataMember(Name="statusMessage", EmitDefaultValue=false)]
        public string StatusMessage { get; private set; }
        /// <summary>
        /// The server supplied OCR task(s)
        /// </summary>
        /// <value>The server supplied OCR task(s)</value>
        [DataMember(Name="tasks", EmitDefaultValue=false)]
        public List<OCRTask> Tasks { get; set; }
        /// <summary>
        /// The conversion queue date/time of this job in ISO 8601 format
        /// </summary>
        /// <value>The conversion queue date/time of this job in ISO 8601 format</value>
        [DataMember(Name="queueTime", EmitDefaultValue=false)]
        public DateTime? QueueTime { get; private set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class OCRJobResponse {\n");
            sb.Append("  CompletionTime: ").Append(CompletionTime).Append("\n");
            sb.Append("  JobId: ").Append(JobId).Append("\n");
            sb.Append("  CreationTime: ").Append(CreationTime).Append("\n");
            sb.Append("  Inputs: ").Append(Inputs).Append("\n");
            sb.Append("  UpdateTime: ").Append(UpdateTime).Append("\n");
            sb.Append("  Job: ").Append(Job).Append("\n");
            sb.Append("  StatusMessage: ").Append(StatusMessage).Append("\n");
            sb.Append("  Tasks: ").Append(Tasks).Append("\n");
            sb.Append("  QueueTime: ").Append(QueueTime).Append("\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
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
            return this.Equals(obj as OCRJobResponse);
        }

        /// <summary>
        /// Returns true if OCRJobResponse instances are equal
        /// </summary>
        /// <param name="other">Instance of OCRJobResponse to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(OCRJobResponse other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.CompletionTime == other.CompletionTime ||
                    this.CompletionTime != null &&
                    this.CompletionTime.Equals(other.CompletionTime)
                ) && 
                (
                    this.JobId == other.JobId ||
                    this.JobId != null &&
                    this.JobId.Equals(other.JobId)
                ) && 
                (
                    this.CreationTime == other.CreationTime ||
                    this.CreationTime != null &&
                    this.CreationTime.Equals(other.CreationTime)
                ) && 
                (
                    this.Inputs == other.Inputs ||
                    this.Inputs != null &&
                    this.Inputs.SequenceEqual(other.Inputs)
                ) && 
                (
                    this.UpdateTime == other.UpdateTime ||
                    this.UpdateTime != null &&
                    this.UpdateTime.Equals(other.UpdateTime)
                ) && 
                (
                    this.Job == other.Job ||
                    this.Job != null &&
                    this.Job.Equals(other.Job)
                ) && 
                (
                    this.StatusMessage == other.StatusMessage ||
                    this.StatusMessage != null &&
                    this.StatusMessage.Equals(other.StatusMessage)
                ) && 
                (
                    this.Tasks == other.Tasks ||
                    this.Tasks != null &&
                    this.Tasks.SequenceEqual(other.Tasks)
                ) && 
                (
                    this.QueueTime == other.QueueTime ||
                    this.QueueTime != null &&
                    this.QueueTime.Equals(other.QueueTime)
                ) && 
                (
                    this.Status == other.Status ||
                    this.Status != null &&
                    this.Status.Equals(other.Status)
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
                if (this.CompletionTime != null)
                    hash = hash * 59 + this.CompletionTime.GetHashCode();
                if (this.JobId != null)
                    hash = hash * 59 + this.JobId.GetHashCode();
                if (this.CreationTime != null)
                    hash = hash * 59 + this.CreationTime.GetHashCode();
                if (this.Inputs != null)
                    hash = hash * 59 + this.Inputs.GetHashCode();
                if (this.UpdateTime != null)
                    hash = hash * 59 + this.UpdateTime.GetHashCode();
                if (this.Job != null)
                    hash = hash * 59 + this.Job.GetHashCode();
                if (this.StatusMessage != null)
                    hash = hash * 59 + this.StatusMessage.GetHashCode();
                if (this.Tasks != null)
                    hash = hash * 59 + this.Tasks.GetHashCode();
                if (this.QueueTime != null)
                    hash = hash * 59 + this.QueueTime.GetHashCode();
                if (this.Status != null)
                    hash = hash * 59 + this.Status.GetHashCode();
                return hash;
            }
        }
    }

}
