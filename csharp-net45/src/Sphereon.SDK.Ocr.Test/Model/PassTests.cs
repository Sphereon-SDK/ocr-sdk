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


using NUnit.Framework;

using System;
using System.Linq;
using System.IO;
using System.Collections.Generic;
using Sphereon.SDK.Ocr.Api;
using Sphereon.SDK.Ocr.Model;
using Sphereon.SDK.Ocr.Client;
using System.Reflection;

namespace Sphereon.SDK.Ocr.Test
{
    /// <summary>
    ///  Class for testing Pass
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by Swagger Codegen.
    /// Please update the test case below to test the model.
    /// </remarks>
    [TestFixture]
    public class PassTests
    {
        // TODO uncomment below to declare an instance variable for Pass
        //private Pass instance;

        /// <summary>
        /// Setup before each test
        /// </summary>
        [SetUp]
        public void Init()
        {
            // TODO uncomment below to create an instance of Pass
            //instance = new Pass();
        }

        /// <summary>
        /// Clean up after each test
        /// </summary>
        [TearDown]
        public void Cleanup()
        {

        }

        /// <summary>
        /// Test an instance of Pass
        /// </summary>
        [Test]
        public void PassInstanceTest()
        {
            // TODO uncomment below to test "IsInstanceOfType" Pass
            //Assert.IsInstanceOfType<Pass> (instance, "variable 'instance' is a Pass");
        }

        /// <summary>
        /// Test the property '_Pass'
        /// </summary>
        [Test]
        public void _PassTest()
        {
            // TODO unit test for the property '_Pass'
        }
        /// <summary>
        /// Test the property 'Words'
        /// </summary>
        [Test]
        public void WordsTest()
        {
            // TODO unit test for the property 'Words'
        }
        /// <summary>
        /// Test the property 'Lines'
        /// </summary>
        [Test]
        public void LinesTest()
        {
            // TODO unit test for the property 'Lines'
        }

    }

}
