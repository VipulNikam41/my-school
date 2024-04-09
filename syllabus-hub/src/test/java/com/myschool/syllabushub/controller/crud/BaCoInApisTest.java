package com.myschool.syllabushub.controller.crud;

import com.myschool.commons.dto.syllabushub.AddBaCoIn;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.syllabushub.controller.TestClient;
import com.myschool.syllabushub.domain.entities.BatchCourseInstructor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class BaCoInApisTest {
    @Autowired
    private TestClient testClient;

    public UUID createBaCoInEntry() {
        AddBaCoIn addBaCoIn = new AddBaCoIn();
        addBaCoIn.setBatchId(UUID.randomUUID());
        UUID baCoInId = testClient.callApi(SyllabusHubApi.ADD_BACOIN, addBaCoIn, UUID.class);
        return baCoInId;
    }
}
