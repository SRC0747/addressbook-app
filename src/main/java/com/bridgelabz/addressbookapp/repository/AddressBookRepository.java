package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose : To demonstrate all the fields of AddressBook repository connected with JpaRepository format
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 15-12-2021
 */
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
