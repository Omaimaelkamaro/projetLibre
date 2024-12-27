package com.example.contactLaboratoire.controller;



import com.example.contactLaboratoire.client.LaboratoireDTO;
import com.example.contactLaboratoire.entity.ContactLaboratoire;
import com.example.contactLaboratoire.service.ContactLaboratoireService;
import com.example.contactLaboratoire.serviceClient.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactLaboratoireController {

    @Autowired
    private ContactLaboratoireService service;

    @PostMapping
    public ResponseEntity<ContactLaboratoire> addContact(@RequestBody ContactLaboratoire contact) {
        return ResponseEntity.ok(service.addContact(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactLaboratoire> updateContact(
            @PathVariable Long id,
            @RequestBody ContactLaboratoire updatedContact) {
        return ResponseEntity.ok(service.updateContact(id, updatedContact));
    }

    @GetMapping
    public ResponseEntity<List<ContactLaboratoire>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/laboratoire/{laboratoireId}")
    public ResponseEntity<List<ContactLaboratoire>> getContactsByLaboratoireId(@PathVariable Long laboratoireId) {
        return ResponseEntity.ok(service.getContactsByLaboratoireId(laboratoireId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
        return ResponseEntity.ok("Contact deleted successfully");
    }

    private final LaboratoireService laboratoireService;

    @Autowired
    public ContactLaboratoireController(LaboratoireService laboratoireService) {
        this.laboratoireService = laboratoireService;
    }

    @GetMapping("/laboratoires/{id}")
    public LaboratoireDTO getLaboratoireById(@PathVariable Long id) {
        return laboratoireService.getLaboratoireDetails(id);
    }
}