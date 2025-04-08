package com.app.service;

import java.util.List;

import com.app.entity.Contact;

public interface ContactService {

	String addContact(Contact contact);

	List<Contact> getAllContact();

	String deleteContact(Integer id);

	Contact getContact(Integer id);

	String editContact(Contact contact);

}
