package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    public AddressBook addAddressDetails(AddressBookDTO addressBookDTO);

    public List<AddressBook> getAddressBookData();

    public AddressBook findAddressDetailsById(int addressBookId);
}
