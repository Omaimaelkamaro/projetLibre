package com.example.contactLaboratoire.service;




import com.example.contactLaboratoire.entity.ContactLaboratoire;
import com.example.contactLaboratoire.repository.ContactLaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactLaboratoireService {

    @Autowired
    private ContactLaboratoireRepository repository;

    public ContactLaboratoire addContact(ContactLaboratoire contact) {
        return repository.save(contact);
    }

    public ContactLaboratoire updateContact(Long id, ContactLaboratoire updatedContact) {
        Optional<ContactLaboratoire> existingContact = repository.findById(id);
        if (existingContact.isPresent()) {
            ContactLaboratoire contact = existingContact.get();
            contact.setFkIdLaboratoire(updatedContact.getFkIdLaboratoire());
            contact.setFkIdAdresse(updatedContact.getFkIdAdresse());
            contact.setNumTel(updatedContact.getNumTel());
            contact.setFax(updatedContact.getFax());
            contact.setEmail(updatedContact.getEmail());
            return repository.save(contact);
        }
        throw new RuntimeException("Contact not found with id " + id);
    }

    public List<ContactLaboratoire> getAllContacts() {
        return repository.findAll();
    }

    public List<ContactLaboratoire> getContactsByLaboratoireId(Long laboratoireId) {
        return repository.findByFkIdLaboratoire(laboratoireId);
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }
}
