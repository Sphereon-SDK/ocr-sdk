/**
 * OCR
 * <b>The OCR API 'ocr' extracts ocr from input files.</b>    The flow is generally as follows:  1. First upload an image/file using the /ocr POST endpoint. You will get back a job response that contains a job with its associated settings.  2. Start the job from a PUT request to the /ocr/{jobid} endpoint, with the Job and Settings JSON as request body. The ocr extraction will now start.  3. Check the job status from the /ocr/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the OCR result using the /ocr/{jobid}/result GET endpoint. This will return the OCR result only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
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

package com.sphereon.sdk.ocr.api;

import com.sphereon.sdk.ocr.handler.ApiException;
import com.sphereon.sdk.ocr.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
 * API tests for OCRApi
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OcrApiTests {
    private final OcrApi api = new OcrApi();
    private static OCRJob ocrJob;
    private static final String IMAGE_NAME = "CCITT_1.TIF";
    private static final URL IMAGE_URL = OcrApiTests.class.getResource( IMAGE_NAME);
    private static final String ACCESS_TOKEN = "0dbd17f1-c108-350e-807e-42d13e543b32";


    /**
     * Temporarily use local microservice
     */
    @Before
    public void setToLocalMicroservice(){
        api.getApiClient().setBasePath(getServiceUrl());
    }


    /**
     * Upload (first) file
     * <p>
     * Upload an file for ocr extraction. Ocr extraction will not be started yet
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _01UploadFile() throws ApiException {
        api.getApiClient().setAccessToken(ACCESS_TOKEN);
        File stream = new File(IMAGE_URL.getFile());
        OCRJobResponse response = api.uploadFile(stream);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getJobId());
        Assert.assertNotNull(response.getJob());
        Assert.assertEquals(OCRJobResponse.StatusEnum.INPUTS_UPLOADED, response.getStatus());
        ocrJob = response.getJob();
    }
    /**
     * Submit OCR job for processing
     * <p>
     * Extract the OCR from the previously uploaded file, using the supplied settings associated with the job in the request body. You can only submit the job after a new Job is created with status IMAGE_UPLOADED or resubmit an existing Job with status ERROR. In all cases the job Id in the path must match the jobId in the request
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _02submitJob() throws ApiException {
        // Change the default deletion after first retrieval to manual deletion for the manual deletion test
        ocrJob.getSettings().getLifecycle().setType(Lifecycle.TypeEnum.TIME);
        ocrJob.getSettings().engine(OCRSettings.EngineEnum.ADVANCED);
        OCRJobResponse response = api.submitJob(ocrJob.getJobId(), ocrJob);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getJob());
        Assert.assertEquals(OCRJobResponse.StatusEnum.PROCESSING, response.getStatus());
    }
    /**
     * Job definition and state
     * <p>
     * Get the PDF job definition and current state. Please not that you can differentiate based on http response status
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _03getJob() throws ApiException {
        OCRJobResponse response = api.getJob(ocrJob.getJobId());
        Assert.assertNotNull(response);
        Assert.assertTrue(response.getStatus() == OCRJobResponse.StatusEnum.PROCESSING || response.getStatus() == OCRJobResponse.StatusEnum.DONE);
    }
    /**
     * Get the current OCR result
     * <p>
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _04getOCR() throws ApiException, InterruptedException, IOException {
        OCRJobResponse response = null;
        int count = 0;
        do {
            Thread.sleep(500);
            count++;
            response = api.getJob(ocrJob.getJobId());
        }
        while (count < 100 && response.getStatus() != OCRJobResponse.StatusEnum.DONE && response.getStatus() != OCRJobResponse.StatusEnum.ERROR);
        OCRResultResponse ocrResult = api.getOcrResult(ocrJob.getJobId());
        Assert.assertNotNull(ocrResult);
        // We could write the output to file of course
        // Files.write(new File("/tmp/out.pdf").toPath(), pdfOutput);
    }
    /**
     * Delete a job manually
     * <p>
     * Delete the PDF job and all related files
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void _05deleteJob() throws ApiException {
        OCRJobResponse response = api.deleteJob(ocrJob.getJobId());
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getJob());
        Assert.assertEquals(OCRJobResponse.StatusEnum.DELETED, response.getStatus());
    }


    private String getServiceUrl() {
        return "http://localhost:18078";
    }

}