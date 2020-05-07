package io.indreams.ecommerceuserinfoservice.model;

import lombok.Data;

@Data
public class Address {

    private String tag;
    private String house;
    private String line_1;
    private int zipCode;

}
