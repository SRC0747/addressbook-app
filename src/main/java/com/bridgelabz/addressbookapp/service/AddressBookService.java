package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.builder.AddressBookBuilder;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.CustomException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Purpose : To implement all the methods in controller class
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 15-12-2021
 */
@Service
public class AddressBookService implements IAddressBookService{

    private static final String ADDRESSBOOK_DETAILS_UPDATED_SUCCESSFULLY = "AddressBook Details are updated successfully.";
    private static final String ADDRESSBOOK_RECORD_DELETED_SUCCESSFULLY = "AddressBook Details are deleted successfully";
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private AddressBookBuilder addressBookBuilder;

    /**
     * Purpose : This method is used to add the details of addressBook
     *
     * @param addressBookDTO defines data added in DTO
     * @return message if data is added successfully;
     */
    @Override
    public String addAddressDetails(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook();
        addressBook = addressBookBuilder.buildAddressBookEntity(addressBookDTO, addressBook);
        //BeanUtils.copyProperties(adderesBookDTO, addressBook);
        addressBookRepository.save(addressBook);
        //return addressBookRepository.save(addressBook);
        return "Added successfully";
    }

    /**
     * Purpose : This method is used to get list of details of all the addressBook
     *
     * @return the list of addressBook data added
     */
    @Override
    public List<AddressBook> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    /**
     * Purpose : This method is used to find the details of addressBook corresponding to the id
     *
     * @param addressBookId defines the id of the addressBook
     * @return the details of the particular addressBook
     */
    @Override
    public AddressBook findAddressDetailsById(int addressBookId) {
        return addressBookRepository.findById(addressBookId).
                orElseThrow(() -> new CustomException("Employee data not found of this id :" + addressBookId));
    }

    /**
     * Purpose : This method is used to update the details of the addressBook of corresponding id
     *
     * @param addressBookId defines  id of address book
     * @param addressBookDTO defines the data stores in addressBook DTO
     * @return the message if updated successfully
     */
    @Override
    public String updateAddressBookDataById(int addressBookId, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = findAddressDetailsById(addressBookId);
        addressBook = addressBookBuilder.buildAddressBookEntity(addressBookDTO, addressBook);
        System.out.println(addressBook.toString());
        addressBookRepository.save(addressBook);
        return ADDRESSBOOK_DETAILS_UPDATED_SUCCESSFULLY;
    }

    /**
     * Purpose : This method is used to delete the addressBook details of corresponding id
     *
     * @param addressBookId defines id of the addressBook
     * @return message if deleted successfully
     */
    @Override
    public String deleteAddressBookDataById(int addressBookId) {
        AddressBook addressBook = findAddressDetailsById(addressBookId);
        addressBookRepository.deleteById(addressBookId);
        return ADDRESSBOOK_RECORD_DELETED_SUCCESSFULLY;
    }

}
