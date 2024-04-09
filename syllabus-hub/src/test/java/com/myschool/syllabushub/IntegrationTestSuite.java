package com.myschool.syllabushub;

import com.myschool.syllabushub.controller.CrudControllerTest;
import com.myschool.syllabushub.domain.mapper.AttendanceMapperTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = {
        AttendanceMapperTest.class,
        CrudControllerTest.class
})
public class IntegrationTestSuite {
}

