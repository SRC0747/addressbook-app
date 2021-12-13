package com.bridgelabz.addressbookapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @GetMapping(value = "/welcome")
    public String welcome() {
        return "Welcome to AddressBook App Server.";
    }
}
