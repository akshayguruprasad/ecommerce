package io.indreams.ecommerceuserinfoservice.model.requestDTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserRegisterationRequestDTO {

    private String userName;
    private String password;
    private String emailId;
    private String contactNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String gender;

}
