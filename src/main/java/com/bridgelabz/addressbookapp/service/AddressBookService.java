package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.builder.AddressBookBuilder;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.CustomException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private AddressBookBuilder addressBookBuilder;

    @Override
    public AddressBook addAddressDetails(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook();
        addressBook = addressBookBuilder.buildAddressBookEntity(addressBookDTO, addressBook);
        //BeanUtils.copyProperties(adderesBookDTO, addressBook);
        addressBookRepository.save(addressBook);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public List<AddressBook> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook findAddressDetailsById(int addressBookId) {
        return addressBookRepository.findById(addressBookId).
                orElseThrow(() -> new CustomException("Employee data not found of this id :" + addressBookId));
    }
}
