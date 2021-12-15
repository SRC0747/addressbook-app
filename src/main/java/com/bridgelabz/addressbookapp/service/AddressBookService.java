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

    private static final String ADDRESSBOOK_DETAILS_UPDATED_SUCCESSFULLY = "AddressBook Details are updated successfully.";
    private static final String ADDRESSBOOK_RECORD_DELETED_SUCCESSFULLY = "AddressBook Details are deleted successfully";
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private AddressBookBuilder addressBookBuilder;

    @Override
    public String addAddressDetails(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook();
        addressBook = addressBookBuilder.buildAddressBookEntity(addressBookDTO, addressBook);
        //BeanUtils.copyProperties(adderesBookDTO, addressBook);
        addressBookRepository.save(addressBook);
        //return addressBookRepository.save(addressBook);
        return "Added successfully";
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

    @Override
    public String updateAddressBookDataById(int addressBookId, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = findAddressDetailsById(addressBookId);
        addressBook = addressBookBuilder.buildAddressBookEntity(addressBookDTO, addressBook);
        System.out.println(addressBook.toString());
        addressBookRepository.save(addressBook);
        return ADDRESSBOOK_DETAILS_UPDATED_SUCCESSFULLY;
    }

    @Override
    public String deleteAddressBookDataById(int addressBookId) {
        AddressBook addressBook = findAddressDetailsById(addressBookId);
        addressBookRepository.deleteById(addressBookId);
        return ADDRESSBOOK_RECORD_DELETED_SUCCESSFULLY;
    }

}
