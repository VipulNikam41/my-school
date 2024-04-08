package com.myschool.syllabushub.service;

import com.myschool.commons.dto.support.ApiResponseDescription;
import com.myschool.commons.dto.support.ApiResponseStatus;
import com.myschool.commons.dto.syllabushub.LectureResponse;
import com.myschool.constants.ResponseCode;
import com.myschool.constants.ResponseId;
import lombok.experimental.UtilityClass;

import java.util.Date;

@UtilityClass
public class ResponseConstructor {
    public static void setOverlappingLectureError(LectureResponse lectureResponse) {
        ApiResponseDescription apiResponseDescription = new ApiResponseDescription();
        apiResponseDescription.setDate(new Date());
        apiResponseDescription.setMessage("Overlapping Lecture Found");
        lectureResponse.setApiResponseDescription(apiResponseDescription);

        ApiResponseStatus apiResponseStatus = new ApiResponseStatus();
        apiResponseStatus.setId(ResponseId.FAILURE);
        apiResponseStatus.setCode(ResponseCode.LECTURE_202);
        lectureResponse.setApiResponseStatus(apiResponseStatus);
    }

    public static void setFaultyLectureError(LectureResponse lectureResponse) {
        ApiResponseDescription apiResponseDescription = new ApiResponseDescription();
        apiResponseDescription.setDate(new Date());
        apiResponseDescription.setMessage("start time after end time");
        lectureResponse.setApiResponseDescription(apiResponseDescription);

        ApiResponseStatus apiResponseStatus = new ApiResponseStatus();
        apiResponseStatus.setId(ResponseId.FAILURE);
        apiResponseStatus.setCode(ResponseCode.LECTURE_201);
        lectureResponse.setApiResponseStatus(apiResponseStatus);
    }

    public static void setSuccess(LectureResponse lectureResponse) {
        ApiResponseStatus apiResponseStatus = new ApiResponseStatus();
        apiResponseStatus.setId(ResponseId.SUCCESS);
        apiResponseStatus.setCode(ResponseCode.SUCCESSFUL_100);
        lectureResponse.setApiResponseStatus(apiResponseStatus);
    }
}
