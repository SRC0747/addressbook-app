package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressBookControllerTest {

    @InjectMocks
    private AddressBookController addressBookController;

    @Mock
    private AddressBookService addressBookService;

    @Test
    void whenGetAllAddressBookDataMethodIsCalled_ShouldReturnTheListOfAllAddressBookResponseDTO() {

        List<AddressBook> addressBooks = new ArrayList<>();
        AddressBook addressBook1 = new AddressBook();
        addressBook1.setFirstName("Sampriti");
        addressBook1.setFirstName("Roy");
        addressBook1.setCity("Kolkata");
        addressBook1.setState("West Bengal");
        addressBook1.setZipcode(700234);
        addressBook1.setPhoneNo("9836704556");

        AddressBook addressBook2 = new AddressBook();
        addressBook2.setFirstName("Rakesh");
        addressBook2.setFirstName("Jaiswal");
        addressBook2.setCity("Kolkata");
        addressBook2.setState("West Bengal");
        addressBook2.setZipcode(700235);
        addressBook2.setPhoneNo("9832365556");
        String successString = "Get Call Success";
        when(addressBookService.getAddressBookData()).thenReturn(addressBooks);
        HttpStatus actualValue = addressBookController.getAddressBookData().getStatusCode();
        assertEquals(HttpStatus.OK, actualValue);
    }

    @Test
    void whenAddAddressBookMethodIsCalled_ShouldAddAdrressBookDataAndGenerateSuccessMessage() {
        String successString = "Created Address Book Data For";
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successString, HttpStatus.OK);
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Sampriti");
        addressBookDTO.setFirstName("Roy");
        addressBookDTO.setCity("Kolkata");
        addressBookDTO.setState("West Bengal");
        addressBookDTO.setZipcode(700234);
        addressBookDTO.setPhoneNo("9836704556");
        when(addressBookService.addAddressDetails(addressBookDTO)).thenReturn(successString);
        ResponseEntity<String> actualResponseString = addressBookController.addAddressBookData(addressBookDTO);
        assertEquals(expectedResponseEntity, actualResponseString);
    }

    @Test
    void whenUpdateAddressBookData_ShouldUpdateAddressBookAndGenerateSuccessMessage() {
        String successString = "Update AddressBook Data For";
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successString, HttpStatus.OK);
        int id = 1;
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Sampriti");
        addressBookDTO.setFirstName("Roy");
        addressBookDTO.setCity("Kolkata");
        addressBookDTO.setState("West Bengal");
        addressBookDTO.setZipcode(700234);
        addressBookDTO.setPhoneNo("9836704556");
        when(addressBookService.updateAddressBookDataById(id, addressBookDTO)).thenReturn(successString);
        ResponseEntity<String> actualResponseString = addressBookController.updateAddressBookData(id, addressBookDTO);
        assertEquals(expectedResponseEntity, actualResponseString);
    }

    @Test
    void whenDeleteAddressBookData_ShouldDeleteAddressBookAndGenerateSuccessMessage() {
        String successString = "Deleted Successfully";
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successString, HttpStatus.OK);
        int id = 1;
        when(addressBookService.deleteAddressBookDataById(id)).thenReturn(successString);
        ResponseEntity<String> actualResponseString = addressBookController.deleteAddressBookDataById(id);
        assertEquals(expectedResponseEntity, actualResponseString);
    }
}