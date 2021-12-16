package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Purpose : To demonstrate various HTTP request methods
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 15-12-2021
 */

@RestController
@RequestMapping("/api")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * Purpose : This method is used to print the welcome message
     *
     * @return welcome message
     */
    @GetMapping(value = "/welcome")
    public String welcome() {
        return "Welcome to AddressBook App Server.";
    }

    /**
     * Purpose : This method to add new addressBook data in addressBook service
     *
     * @param addressBookDTO defines the input data of addressBook in DTO  format
     * @return response message if new addressBook data is added
     */
    @PostMapping("/create")
    public ResponseEntity<String> addAddressBookData(
            @RequestBody AddressBookDTO addressBookDTO) {
        String addressBookData = addressBookService.addAddressDetails(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data For ", addressBookData);
        //return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        return new ResponseEntity<>("Created Address Book Data For", HttpStatus.OK);
    }

    /**
     * Purpose : This method is used to get list of all the addressBook data added
     *
     * @return the list of addressBook details
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBook> addressBookData = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : This method is used to get the addressBook data by using particular id
     *
     * @param addressBookDataId defines addressBook id
     * @return addressBook data corresponding to the id
     */
    @GetMapping("/get/{addressBookId}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(
            @PathVariable int addressBookDataId) {
        AddressBook addressBookData = addressBookService.findAddressDetailsById(addressBookDataId);
        ResponseDTO responseDto = new ResponseDTO("Get Call Success For Id", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
    }

    /**
     * Purpose : This method is used to update the addressBook data corresponding to the id
     *
     * @param addressBookId defines the addressBook id
     * @param addressBookDTO defines the data in DTO format
     * @return message if data is updated successfully
     */
    @PutMapping("/update/{addressBookId}")
    public ResponseEntity<String> updateAddressBookData(
            @PathVariable int addressBookId,
            @RequestBody AddressBookDTO addressBookDTO) {
        String addressBookData = addressBookService.updateAddressBookDataById(addressBookId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update AddressBook Data For", addressBookData);
       // return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        return new ResponseEntity<>("Update AddressBook Data For", HttpStatus.OK);
    }

    /**
     * Purpose : This method is used to delete the addressBook details corresponding to it's id
     *
     * @param addressBookId defines addressBook id
     * @return message if addressBook details of corresponding id is deleted successfully
     */
    @DeleteMapping("/delete/{addressBookId}")
    public ResponseEntity<String> deleteAddressBookDataById(
            @PathVariable int addressBookId) {
        addressBookService.deleteAddressBookDataById(addressBookId);
        ResponseDTO responseDto = new ResponseDTO("Deleted Successfully", "deleted id: " + addressBookId);
        //return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
