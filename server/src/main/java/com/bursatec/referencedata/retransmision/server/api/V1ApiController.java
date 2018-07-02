package com.bursatec.referencedata.retransmision.server.api;
import com.bursatec.referencedata.retransmision.server.model.ReferenceData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-27T22:57:54.477Z")

@Controller
public class V1ApiController implements V1Api {

    private static final Logger log = LoggerFactory.getLogger(V1ApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public V1ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<ReferenceData>> v1ReferenceDataRetransmitGet(@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "userid", required = true) String userid,@NotNull @ApiParam(value = "MD5 digest of password", required = true) @Valid @RequestParam(value = "password", required = true) String password,@NotNull @ApiParam(value = "Initial (Inclusive) Id to retransmit", required = true) @Valid @RequestParam(value = "startId", required = true) Long startId,@NotNull @ApiParam(value = "End (Inclusive) Id to retransmit", required = true) @Valid @RequestParam(value = "endId", required = true) Long endId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //TODO: Implementar logica de recepcion, validación y respuesta
                return new ResponseEntity<List<ReferenceData>>(objectMapper.readValue("[ {  \"refData\" : \"2018XXXXXXXXXXXXXXXXX\",  \"refDataType\" : \"Zx\",  \"refDataId\" : 1}, {  \"refData\" : \"2018XXXXXXXXXXXXXXXXX\",  \"refDataType\" : \"Zx\",  \"refDataId\" : 1} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ReferenceData>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ReferenceData>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
