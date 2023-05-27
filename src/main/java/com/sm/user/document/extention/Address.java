package com.sm.user.document.extention;

import lombok.Data;

@Data
public class Address {
    private String village;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private String addressLine1;
}
