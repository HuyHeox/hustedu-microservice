package com.hn.authenticationservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.hn.authenticationservice.config.Constant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private ObjectId id;
    private String itemType = Constant.NULL_TXT;
    private String username = Constant.NULL_TXT;
    private String email = Constant.NULL_TXT;
    private String personalEmail = Constant.NULL_TXT;

    private String fullName = Constant.NULL_TXT;
    private String firstName = Constant.NULL_TXT;
    private String lastName = Constant.NULL_TXT;

    private String phoneNumber = Constant.NULL_TXT;
    private int gender = -1;
    private Long birthdate = Constant.NULL_ID;

    private Long departmentId = Constant.NULL_ID;
    private String departmentName = Constant.NULL_TXT;
    private Long rootId = Constant.NULL_ID;
    private String rootName = Constant.NULL_TXT;
}
