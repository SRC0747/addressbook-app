package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.builder.AddressBookBuilder;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.CustomException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressBookServiceTest {

    @InjectMocks
    private AddressBookService addressBookService;

    @Mock
    private AddressBookRepository addressBookRepository;

    @Mock
    private AddressBookBuilder addressBookBuilder;
    @Test
    void whenGetAllAddressBookDetailsIsCalled_ShouldReturnListOfAddressBookResponseDto() {

        List<AddressBook> addressBooks = new ArrayList<>();

        AddressBook addressBook1 = new AddressBook();
        addressBook1.setFirstName("Sampriti");
        addressBook1.setFirstName("Roy");
        addressBook1.setCity("Kolkata");
        addressBook1.setState("West Bengal");
        addressBook1.setZipcode(700234);
        addressBook1.setPhoneNo("9836704556");
        addressBooks.add(addressBook1);

        AddressBook addressBook2 = new AddressBook();
        addressBook2.setFirstName("Rakesh");
        addressBook2.setFirstName("Jaiswal");
        addressBook2.setCity("Kolkata");
        addressBook2.setState("West Bengal");
        addressBook2.setZipcode(700235);
        addressBook2.setPhoneNo("9832365556");
        addressBooks.add(addressBook2);

        when(addressBookRepository.findAll()).thenReturn(addressBooks);
        List<AddressBook> actualListOfAddressBookEntity = addressBookService.getAddressBookData();
        assertEquals(2, actualListOfAddressBookEntity.size());
        assertEquals(addressBooks, actualListOfAddressBookEntity);
    }

    @Test
    void WhenFindAddressBookDetailsByIdCalled_ThenIfIdIsNotFound_ShouldThrowException() {
        int addressBookId = 1;
        when(addressBookRepository.findById(addressBookId)).thenReturn(Optional.empty());
        assertThrows(CustomException.class, () -> addressBookService.findAddressDetailsById(addressBookId));
    }

    @Test
    void whenAddAddressBook_ShouldAddAddressBookDetailsAndReturnResponseAndGenerateSuccessMessage() {
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        AddressBook addressBook = new AddressBook();
        addressBookDTO.setFirstName("Sampriti");
        addressBookDTO.setLastName("Roy");
        addressBookDTO.setCity("Kolkata");
        addressBookDTO.setState("West Bengal");
        addressBookDTO.setZipcode(711104);
        addressBookDTO.setPhoneNo("8536966789");
        when(addressBookBuilder.buildAddressBookEntity(addressBookDTO, addressBook)).thenReturn(addressBook);
        String actualValue = addressBookService.addAddressDetails(addressBookDTO);
        assertEquals("Added successfully", actualValue);
    }

    @Test
    void givenWhenUpdateAddressBook_ShouldUpdateAddressBookDataAndReturnSuccessMessage() {
        int addressBookId = 1;
        ArgumentCaptor<AddressBook> addressBookArgumentCaptor = ArgumentCaptor.forClass(AddressBook.class);
        String successMessage = "AddressBook Details are updated successfully.";
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Sampriti");
        addressBookDTO.setLastName("Roy");
        addressBookDTO.setCity("Kolkata");
        addressBookDTO.setState("West Bengal");
        addressBookDTO.setZipcode(711104);
        addressBookDTO.setPhoneNo("8536966789");

        AddressBook addressBook = new AddressBook();
        addressBook.setFirstName("Sampriti");
        addressBook.setLastName("Roy");
        addressBook.setCity("Kolkata");
        addressBook.setState("West Bengal");
        addressBook.setZipcode(711104);
        addressBook.setPhoneNo("8536966789");

        when(addressBookRepository.findById(addressBookId)).thenReturn(Optional.of(addressBook));
        when(addressBookBuilder.buildAddressBookEntity(addressBookDTO, addressBook)).thenReturn(addressBook);
        String actualMessage = addressBookService.updateAddressBookDataById(addressBookId, addressBookDTO);
        assertEquals(successMessage, actualMessage);
        verify(addressBookRepository, times(1)).save(addressBookArgumentCaptor.capture());
        assertEquals(addressBook.getFirstName(), addressBookArgumentCaptor.getValue().getFirstName());
        assertEquals(addressBook.getLastName(), addressBookArgumentCaptor.getValue().getLastName());
        assertEquals(addressBook.getCity(), addressBookArgumentCaptor.getValue().getCity());
        assertEquals(addressBook.getState(), addressBookArgumentCaptor.getValue().getState());
        assertEquals(addressBook.getZipcode(), addressBookArgumentCaptor.getValue().getZipcode());
        assertEquals(addressBook.getPhoneNo(), addressBookArgumentCaptor.getValue().getPhoneNo());
    }

    @Test
    void whenUpdateAddressBook_IfNotFoundId_shouldThrowExceptionMessage() {
        int id = 1;
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Sampriti");
        addressBookDTO.setLastName("Roy");
        addressBookDTO.setCity("Kolkata");
        addressBookDTO.setState("West Bengal");
        addressBookDTO.setZipcode(711104);
        addressBookDTO.setPhoneNo("8536966789");
        when(addressBookRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(CustomException.class, () -> addressBookService.updateAddressBookDataById(id, addressBookDTO));
    }

    @Test
    void givenDeleteAddressBookDetailsWithAnId_ShouldDeleteTheDataOfThatId() {
        int id = 1;
        AddressBook addressBook = new AddressBook();
        addressBook.setFirstName("Sampriti");
        addressBook.setLastName("Roy");
        addressBook.setCity("Kolkata");
        addressBook.setState("West Bengal");
        addressBook.setZipcode(711104);
        addressBook.setPhoneNo("8536966789");
        when(addressBookRepository.findById(id)).thenReturn(Optional.of(addressBook));
        String actualMessage = addressBookService.deleteAddressBookDataById(id);
        assertEquals("AddressBook Details are deleted successfully", actualMessage);
    }


    @Test
    void whenDeleteAddressBookWithId_IfIdNotFound_shouldThrowExceptionMessage() {
        int id = 1;
        when(addressBookRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(CustomException.class, () -> addressBookService.deleteAddressBookDataById(id));
    }
}