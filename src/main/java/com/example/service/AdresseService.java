package com.example.service;
import com.example.dto.AdresseDto;
import java.util.List;

public interface AdresseService {
	AdresseDto  addAdresse(AdresseDto adresseDTO);
	AdresseDto  updateAdresse(int id, AdresseDto adresseDTO);
	AdresseDto  getAdresseById(int id);
    List<AdresseDto > getAllAdresses();
    void deleteAdresse(int id);
}