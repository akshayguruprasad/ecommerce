package io.indreams.ecommerceuserinfoservice.model.responseDTO;

import io.indreams.ecommerceuserinfoservice.model.Address;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class UserResponseDTO {
    private String userName;
    private String emailId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String gender;
    private List<Address> addressList;
}
