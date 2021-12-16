package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Purpose : To demonstrate various fields of addressBook in DTo
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 15-12-2021
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {

    @Pattern(regexp = "[A-Z][a-z]{2,}$", message = "Not a Valid First Name")
    private String firstName;

    @Pattern(regexp = "[A-Z][a-z]{2,}$", message = "Not a Valid Last Name")
    private String lastName;

    @NotNull(message = "City name should not be empty")
    private String city;

    @NotNull(message = "State name should not be empty")
    private String state;

    @Pattern(regexp = "^[0-9]{6}$",
            message = "Pin code should be 6 digit")
    private int zipcode;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number is invalid")
    private String phoneNo;
}
