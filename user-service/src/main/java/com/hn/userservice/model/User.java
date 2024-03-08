package com.hn.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.hn.userservice.config.Config;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@ToString(exclude = {"password"})
@Document(collection = "User")
public class User {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String itemType = Config.NULL_TXT;
    private String username = Config.NULL_TXT;
    @JsonIgnore
    private String password = Config.NULL_TXT;
    private String email = Config.NULL_TXT;
    private String personalEmail = Config.NULL_TXT;

    private String fullName = Config.NULL_TXT;
    private String firstName = Config.NULL_TXT;
    private String lastName = Config.NULL_TXT;

    private String phoneNumber = Config.NULL_TXT;
    private int gender = -1;
    private Long birthdate = Config.NULL_ID;

    private Long departmentId = Config.NULL_ID;
    private String departmentName = Config.NULL_TXT;
    private Long rootId = Config.NULL_ID;
    private String rootName = Config.NULL_TXT;
}
