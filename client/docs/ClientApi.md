# ClientApi

All URIs are relative to *https://<server-ip>:<port>*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1ReferenceDataRetransmitGet**](ClientApi.md#v1ReferenceDataRetransmitGet) | **GET** /v1/referenceData/retransmit | Request retransmission of Reference Data


<a name="v1ReferenceDataRetransmitGet"></a>
# **v1ReferenceDataRetransmitGet**
> List&lt;ReferenceData&gt; v1ReferenceDataRetransmitGet(userid, password, startId, endId)

Retransmit Data Reference.



### Example
```java
// Import classes:
//import ApiException;
//import ClientApi;


ClientApi apiInstance = new ClientApi();
String userid = "userid_example"; // String | The user name for login
String password = "password_example"; // String | MD5 digest of password
Long startId = 789L; // Long | Initial (Inclusive) Id to retransmit
Long endId = 789L; // Long | End (Inclusive) Id to retransmit
try {
    List<ReferenceData> result = apiInstance.v1ReferenceDataRetransmitGet(userid, password, startId, endId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClientApi#v1ReferenceDataRetransmitGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userid** | **String**| The user name for login |
 **password** | **String**| MD5 digest of password |
 **startId** | **Long**| Initial (Inclusive) Id to retransmit |
 **endId** | **Long**| End (Inclusive) Id to retransmit |

### Return type

[**List&lt;ReferenceData&gt;**](ReferenceData.md)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

