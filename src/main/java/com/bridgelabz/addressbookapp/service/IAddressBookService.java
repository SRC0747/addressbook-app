package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

public interface IAddressBookService {

    public AddressBook addAddressDetails(AddressBookDTO addressBookDTO);
}
