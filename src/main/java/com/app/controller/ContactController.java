package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Contact;
import com.app.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping(value = "/register")
	private ResponseEntity<String> addContact(@RequestBody Contact contact) {

		String addedContact = contactService.addContact(contact);

		return new ResponseEntity<String>(addedContact, HttpStatus.OK);
	}

	@GetMapping(value = "/getContact/{id}")
	private ResponseEntity<Contact> getContact(@PathVariable Integer id) {
		Contact contact = contactService.getContact(id);
		if (contact != null) {
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		}
		return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getAllContact")
	private ResponseEntity<List<Contact>> getAllContact() {
		List<Contact> allContactList = contactService.getAllContact();
		if (allContactList != null) {
			return new ResponseEntity<List<Contact>>(allContactList, HttpStatus.OK);
		}
		return new ResponseEntity<List<Contact>>(null);
	}

	@DeleteMapping(value = "/delete/{id}")
	private ResponseEntity<String> deleteContact(@PathVariable Integer id) {
		String deleteContact = contactService.deleteContact(id);
		return new ResponseEntity<String>(deleteContact, HttpStatus.OK);
	}

	@PutMapping(value = "/edit")
	private String updateContact(@RequestBody Contact contact) {
		String editedContact = contactService.editContact(contact);
		return editedContact;
	}

	private void m1() {
		System.out.println("this is m1 method..");
	}
}
