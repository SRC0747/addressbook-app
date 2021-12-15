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

@RestController
@RequestMapping("/api")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping(value = "/welcome")
    public String welcome() {
        return "Welcome to AddressBook App Server.";
    }

    @PostMapping("/create")
    public ResponseEntity<String> addAddressBookData(
            @RequestBody AddressBookDTO addressBookDTO) {
        String addressBookData = addressBookService.addAddressDetails(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data For ", addressBookData);
        //return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        return new ResponseEntity<>("Created Address Book Data For", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBook> addressBookData = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{addressBookId}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(
            @PathVariable int addressBookDataId) {
        AddressBook addressBookData = addressBookService.findAddressDetailsById(addressBookDataId);
        ResponseDTO responseDto = new ResponseDTO("Get Call Success For Id", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{addressBookId}")
    public ResponseEntity<String> updateAddressBookData(
            @PathVariable int addressBookId,
            @RequestBody AddressBookDTO addressBookDTO) {
        String addressBookData = addressBookService.updateAddressBookDataById(addressBookId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update AddressBook Data For", addressBookData);
       // return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        return new ResponseEntity<>("Update AddressBook Data For", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{addressBookId}")
    public ResponseEntity<String> deleteAddressBookDataById(
            @PathVariable int addressBookId) {
        addressBookService.deleteAddressBookDataById(addressBookId);
        ResponseDTO responseDto = new ResponseDTO("Deleted Successfully", "deleted id: " + addressBookId);
        //return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
