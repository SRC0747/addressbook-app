package com.bridgelabz.addressbookapp.integration;

import com.bridgelabz.addressbookapp.controller.AddressBookController;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AddressBookController.class)
public class AddressBookControllerIntegrationTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookService addressBookService;

    @Test
    void name() throws Exception {
        when(addressBookService.getAddressBookData()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/get"))
                .andExpect(status().isOk());
    }

    @Test
    void addAddressBookData() throws Exception {
        when(addressBookService.addAddressDetails(any())).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/create")
                        .content("{\"firstName\":\"Atreyee\",\"lastName\":\"Chakrobarty\",\"city\":\"Kolkata\",\"state\":\"WestBengal\",\"zipcode\":711104,\"phoneNo\":\"9631256978\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void updateAddressBookData() throws Exception {
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Sampriti");
        addressBookDTO.setLastName("Roy");
        addressBookDTO.setCity("Kolkata");
        addressBookDTO.setState("West Bengal");
        addressBookDTO.setZipcode(711104);
        addressBookDTO.setPhoneNo("8536966789");
        int id = 1;
        when(addressBookService.updateAddressBookDataById(id,addressBookDTO)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/update/1")
                        .content("{\"firstName\":\"Atreyee\",\"lastName\":\"Chakrobarty\",\"city\":\"Kolkata\",\"state\":\"WestBengal\",\"zipcode\":711104,\"phoneNo\":\"9631256978\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void deleteAddressBookData() throws Exception {
        when(addressBookService.deleteAddressBookDataById(1)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/delete/1")
                        .content("{\"firstName\":\"Atreyee\",\"lastName\":\"Chakrobarty\",\"city\":\"Kolkata\",\"state\":\"WestBengal\",\"zipcode\":711104,\"phoneNo\":\"9631256978\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}
