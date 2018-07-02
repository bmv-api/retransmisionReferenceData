

package com.bursatec.referencedata.recepcion.client.api;

import com.bursatec.referencedata.recepcion.client.ApiCallback;
import com.bursatec.referencedata.recepcion.client.ApiClient;
import com.bursatec.referencedata.recepcion.client.ApiException;
import com.bursatec.referencedata.recepcion.client.ApiResponse;
import com.bursatec.referencedata.recepcion.client.Configuration;
import com.bursatec.referencedata.recepcion.client.Pair;
import com.bursatec.referencedata.recepcion.client.ProgressRequestBody;
import com.bursatec.referencedata.recepcion.client.ProgressResponseBody;
import com.bursatec.referencedata.recepcion.client.model.ReferenceData;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientApi {
    private ApiClient apiClient;

    public ClientApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ClientApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for v1ReferenceDataRetransmitGet
     * @param userid The user name for login (required)
     * @param password MD5 digest of password (required)
     * @param startId Initial (Inclusive) Id to retransmit (required)
     * @param endId End (Inclusive) Id to retransmit (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1ReferenceDataRetransmitGetCall(String userid, String password, Long startId, Long endId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/referenceData/retransmit";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (userid != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("userid", userid));
        if (password != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("password", password));
        if (startId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("startId", startId));
        if (endId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("endId", endId));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1ReferenceDataRetransmitGetValidateBeforeCall(String userid, String password, Long startId, Long endId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userid' is set
        if (userid == null) {
            throw new ApiException("Missing the required parameter 'userid' when calling v1ReferenceDataRetransmitGet(Async)");
        }
        
        // verify the required parameter 'password' is set
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling v1ReferenceDataRetransmitGet(Async)");
        }
        
        // verify the required parameter 'startId' is set
        if (startId == null) {
            throw new ApiException("Missing the required parameter 'startId' when calling v1ReferenceDataRetransmitGet(Async)");
        }
        
        // verify the required parameter 'endId' is set
        if (endId == null) {
            throw new ApiException("Missing the required parameter 'endId' when calling v1ReferenceDataRetransmitGet(Async)");
        }
        

        com.squareup.okhttp.Call call = v1ReferenceDataRetransmitGetCall(userid, password, startId, endId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Request retransmission of Reference Data
     * &lt;p&gt;Reference data retransmission mechanism to request a minimum of 1 and a maximum of 30 records.&lt;/p&gt;&lt;p&gt;(endId - startId + 1), must be between 1 and 30&lt;/p&gt;
     * @param userid The user name for login (required)
     * @param password MD5 digest of password (required)
     * @param startId Initial (Inclusive) Id to retransmit (required)
     * @param endId End (Inclusive) Id to retransmit (required)
     * @return List&lt;ReferenceData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<ReferenceData> v1ReferenceDataRetransmitGet(String userid, String password, Long startId, Long endId) throws ApiException {
        ApiResponse<List<ReferenceData>> resp = v1ReferenceDataRetransmitGetWithHttpInfo(userid, password, startId, endId);
        return resp.getData();
    }

    /**
     * Request retransmission of Reference Data
     * &lt;p&gt;Reference data retransmission mechanism to request a minimum of 1 and a maximum of 30 records.&lt;/p&gt;&lt;p&gt;(endId - startId + 1), must be between 1 and 30&lt;/p&gt;
     * @param userid The user name for login (required)
     * @param password MD5 digest of password (required)
     * @param startId Initial (Inclusive) Id to retransmit (required)
     * @param endId End (Inclusive) Id to retransmit (required)
     * @return ApiResponse&lt;List&lt;ReferenceData&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<ReferenceData>> v1ReferenceDataRetransmitGetWithHttpInfo(String userid, String password, Long startId, Long endId) throws ApiException {
        com.squareup.okhttp.Call call = v1ReferenceDataRetransmitGetValidateBeforeCall(userid, password, startId, endId, null, null);
        Type localVarReturnType = new TypeToken<List<ReferenceData>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Request retransmission of Reference Data (asynchronously)
     * &lt;p&gt;Reference data retransmission mechanism to request a minimum of 1 and a maximum of 30 records.&lt;/p&gt;&lt;p&gt;(endId - startId + 1), must be between 1 and 30&lt;/p&gt;
     * @param userid The user name for login (required)
     * @param password MD5 digest of password (required)
     * @param startId Initial (Inclusive) Id to retransmit (required)
     * @param endId End (Inclusive) Id to retransmit (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1ReferenceDataRetransmitGetAsync(String userid, String password, Long startId, Long endId, final ApiCallback<List<ReferenceData>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1ReferenceDataRetransmitGetValidateBeforeCall(userid, password, startId, endId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<ReferenceData>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
