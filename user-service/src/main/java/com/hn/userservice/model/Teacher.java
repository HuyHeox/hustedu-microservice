package com.hn.userservice.model;

import com.hn.userservice.config.Config;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Teacher {
    @Id
    private Long id;
    private String staffCode = Config.NULL_TXT;

    private Long title = Config.NULL_ID;
    private Long degree = Config.NULL_ID;
    private Long jobType = Config.NULL_ID;
    private Long positionId = Config.NULL_ID;
    private Long partyUnitId = Config.NULL_ID;

    private String signature = Config.NULL_TXT;

    private String taxNumber = Config.NULL_TXT;

    private String passportNumber = Config.NULL_TXT;

    private String idNumber = Config.NULL_TXT;
    private String idNumberPlace = Config.NULL_TXT;
    private Long idNumberPlaceId = Config.NULL_ID;
    private Long idNumberDate = Config.NULL_ID;
    private String idNumberFront = Config.NULL_TXT;
    private String idNumberBack = Config.NULL_TXT;
    private String bankAccount = Config.NULL_TXT;
    private String bankInfo = Config.NULL_TXT;
    private String assuranceNumber = Config.NULL_TXT;    //Số BHXH
    private Long assuranceDate = Config.NULL_ID;
    private String insuranceNumber = Config.NULL_TXT; //Số BHYT
    private Long insuranceDate = Config.NULL_ID;

    private String residentAddress = Config.NULL_TXT;
    private Long residentCountryId = Config.NULL_ID;
    private Long residentProvinceId = Config.NULL_ID;
    private Long residentDistrictId = Config.NULL_ID;
    private Long residentCommuneId = Config.NULL_ID;

    private String homeTownAddress = Config.NULL_TXT;
    private Long homeTownCountryId = Config.NULL_ID;
    private Long homeTownProvinceId = Config.NULL_ID;
    private Long homeTownDistrictId = Config.NULL_ID;
    private Long homeTownCommuneId = Config.NULL_ID;
}
