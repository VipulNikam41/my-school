package com.myscool.response;

import com.myscool.domain.dto.UserProfileDTO;
import lombok.Data;

@Data
public class GetUserResponse extends BaseResponse {
    private UserProfileDTO userProfileDTO;
}
