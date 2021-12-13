package com.bridgelabz.addressbookapp.builder;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressBookBuilder {

    public AddressBook buildAddressBookEntity(AddressBookDTO addressBookDTO, AddressBook addressBook) {
        BeanUtils.copyProperties(addressBookDTO, addressBook);
        return addressBook;
    }
}
