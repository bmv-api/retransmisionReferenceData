/**
 * Bursatec - BMV 12/10/2018
 * This software is the confidential and proprietary information of
 * Bursatec and Bolsa Mexicana de Valores("Confidential Information").
 *
 * You shall not disclose such confidential information and shall use
 * it only within a project and/or the offices of Bursatec or Bolsa Mexicana de Valores
*/
package com.bursatec.referencedata.retransmision.example;

import java.util.List;

import com.bursatec.referencedata.retransmision.client.ApiException;
import com.bursatec.referencedata.retransmision.client.api.ClientApi;
import com.bursatec.referencedata.retransmision.client.model.ReferenceData;

/**
 * Clase de Ejemplo.
 * 
 * @author bmv - Bursatec
 * @version 1.0
 */
public class ClientApiExample {

    public static void main(String[] args) {

        ClientApi apiInstance = new ClientApi();
        String userid = "userid_example"; // String | The user name for login
        String password = "password_example"; // String | The password delivered
                                              // by BMV
        Long startId = 789L; // Long | Initial (Inclusive) Id to retransmit
        Long endId = 789L; // Long | End (Inclusive) Id to retransmit

        try {
            // BMV server's URL
            apiInstance.getApiClient().setBasePath("https://localhost:1234");
            List<ReferenceData> result = apiInstance
                    .v1ReferenceDataRetransmitGet(userid, password, startId,
                            endId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println(e.getCode());
            System.err.println(e.getResponseBody());
        }
    }
}
