package io.indreams.ecommerceuserinfoservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Document(collection = "users")
@Data
public class UserDAO {
    @Id
    private String userName;
    private String emailId;
    private String contactNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String gender;
    private List<Address> addressList;
}
