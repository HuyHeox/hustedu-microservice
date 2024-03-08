package com.hn.userservice.model;

import com.hn.userservice.config.Config;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long programId = Config.NULL_ID;                //4: DHCQ
    private String programName = Config.NULL_TXT;
    private long majorId = Config.NULL_ID;
    private String majorName = Config.NULL_TXT;
    private String majorCode = Config.NULL_TXT;
    private String studentYear = Config.NULL_TXT;        //K50, K51, K52
    private int year = 0;        //2015, 2016, ...

}
