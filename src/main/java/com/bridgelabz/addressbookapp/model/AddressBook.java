package com.bridgelabz.addressbookapp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Purpose : To demonstrate all the fields of addressBook in the entity database format
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 15-12-2021
 */

@Data
@Table(name="addressBook")
@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMP_ID")
    private int id;

    @Column(name = "FIRST_NAME", length=25)
    private String firstName;

    @Column(name = "LAST_NAME", length=25)
    private String lastName;

    @Column(name = "CITY", length=22)
    private String city;

    @Column(name = "STATE", length=33)
    private String state;

    @Column(name = "ZIPCODE", length=11)
    private int zipcode;

    @Column(name = "CONTACT_NUMBER", length=10)
    private String phoneNo;
}
