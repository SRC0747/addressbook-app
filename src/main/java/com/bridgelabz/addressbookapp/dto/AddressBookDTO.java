package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private int zipcode;
    private String phoneNo;
}
