package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Contact;
import com.app.repository.ContactRepository;
import com.app.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String addContact(Contact contact) {
		contactRepository.save(contact);
		return "Contact information saved for : " + contact.getId();
	}

	@Override
	public Contact getContact(Integer id) {
		if (contactRepository.existsById(id))
		{
			return contactRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> findAllByActiveStatusTrue = contactRepository.findByActiveStatus(true);
		return findAllByActiveStatusTrue;
	}

	@Override
	public String deleteContact(Integer id) {	
		Contact contact = getContact(id);
			if(contact!=null) {
			contact.setActiveStatus(false);
			addContact(contact);
			return "contact information is deleted for user id : " + id;
		}
		return "contact information is not existed for user id : " + id;
	}

	@Override
	public String editContact(Contact contact) {
		Contact contact2 = getContact(contact.getId());
		if (contact2 != null) {
			contactRepository.deleteById(contact.getId());
			addContact(contact);
			return "Contact information updated for contact id : " + contact.getId();
		}
		return "contact information is not existed for user id : " + contact.getId();
	}
}
