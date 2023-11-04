package com.myschool.response;

import com.myschool.domain.dto.UserProfileDTO;
import lombok.Data;

@Data
public class GetUserResponse extends BaseResponse {
    private UserProfileDTO userProfileDTO;
}
