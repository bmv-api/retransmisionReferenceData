package com.bursatec.referencedata.retransmision.client.api;

import com.bursatec.referencedata.retransmision.client.ApiException;
import com.bursatec.referencedata.retransmision.client.model.ReferenceData;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * API tests for BmvApi
 */
@Ignore
public class ClientApiTest {

    private final ClientApi api = new ClientApi();

    MockWebServer server;

    @Before
    public void init() throws IOException {
        server = new MockWebServer();
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("[{\"refDataId\":1,\"refDataType\":\"Zx\",\"refData\":\"2018XXXXXXXXXX\"},{\"refDataId\":2,\"refDataType\":\"Zx\",\"refData\":\"2018XXXXXXXXXY\"}]"));
        server.start();
    }

    /**
     * Receives Data Reference.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void v1ReferenceDataRetransmitGetTest() throws ApiException, InterruptedException {
        String userid = "bmv";
        String password = "c893bad68927b457dbed39460e6afd62";
        Long startId = 1L;
        Long endId = 1L;
        String path = server.url("/").toString();
        path = path.substring(0, path.length() - 1);
        api.getApiClient().setBasePath(path);
        List<ReferenceData> response = api.v1ReferenceDataRetransmitGet(userid, password, startId, endId);
        assertEquals(2, response.size());
        assertEquals(1L, response.get(0).getRefDataId().longValue());
        assertEquals("Zx", response.get(0).getRefDataType());
        assertEquals("2018XXXXXXXXXX", response.get(0).getRefData());
        assertEquals(2L, response.get(1).getRefDataId().longValue());
        assertEquals("Zx", response.get(1).getRefDataType());
        assertEquals("2018XXXXXXXXXY", response.get(1).getRefData());

        RecordedRequest request1 = server.takeRequest();
        assertEquals("/v1/referenceData/retransmit?userid=" + userid + "&password=" + password + "&startId=" + startId + "&endId=" + endId, request1.getPath());
    }


}
