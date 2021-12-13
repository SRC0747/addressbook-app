package com.bridgelabz.addressbookapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="addressBook")
@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMP_ID")
    private int id;

    @Column(name = "NAME", length=25)
    private String name;

    @Column(name = "CITY", length=22)
    private String city;

    @Column(name = "STATE", length=33)
    private String state;

    @Column(name = "ZIPCODE", length=11)
    private int zipcode;

    @Column(name = "CONTACT_NUMBER", length=10)
    private String phoneNo;
}
