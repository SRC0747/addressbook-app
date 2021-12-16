package com.bridgelabz.addressbookapp.builder;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Purpose : Implement builder to handle BeanUtils so that not to ignore boilerPlate not to break dry principle
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 15-12-2021
 */

@Component
public class AddressBookBuilder {

    /**
     * Purpose : This method is used to convert the input of DTO into entity using BeanUtils
     *
     * @param addressBookDTO defines the field of address book in DTO
     * @param addressBook defines the field of address book in entity
     * @return the fiels of adress book in the format of entity
     */

    public AddressBook buildAddressBookEntity(AddressBookDTO addressBookDTO, AddressBook addressBook) {
        BeanUtils.copyProperties(addressBookDTO, addressBook);
        return addressBook;
    }
}
