package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

import java.util.List;

/**
 * Purpose : To implement all the methods of service class
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 15-12-2021
 */

public interface IAddressBookService {

    public String addAddressDetails(AddressBookDTO addressBookDTO);

    public List<AddressBook> getAddressBookData();

    public AddressBook findAddressDetailsById(int addressBookId);

    public String updateAddressBookDataById(int addressBookId, AddressBookDTO addressBookDTO);

    public String deleteAddressBookDataById(int addressBookId);
}
