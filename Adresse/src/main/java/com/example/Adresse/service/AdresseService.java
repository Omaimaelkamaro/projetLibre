package com.example.Adresse.service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Adresse.dto.AdresseDto;
import com.example.Adresse.entity.Adresse;
import com.example.Adresse.Repository.AdresseRepository;
@Service
public class AdresseService  {

    @Autowired
    private AdresseRepository adresseRepository;

    @Autowired
    private ModelMapper modelMapper;


    public AdresseDto addAdresse(AdresseDto adresseDTO) {
        Adresse adresse = modelMapper.map(adresseDTO, Adresse.class);
        adresse = adresseRepository.save(adresse);
        return modelMapper.map(adresse, AdresseDto.class);
    }


    public AdresseDto updateAdresse(int id, AdresseDto adresseDTO) {
        Adresse adresse = adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse not found"));

        adresse.setNumVoie(adresseDTO.getNumVoie());
        adresse.setNomVoie(adresseDTO.getNomVoie());
        adresse.setCodePostal(adresseDTO.getCodePostal());
        adresse.setVille(adresseDTO.getVille());
        adresse.setCommune(adresseDTO.getCommune());

        adresse = adresseRepository.save(adresse);
        return modelMapper.map(adresse, AdresseDto.class);
    }


    public AdresseDto getAdresseById(int id) {
        Adresse adresse = adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse not found"));
        return modelMapper.map(adresse, AdresseDto.class);
    }


    public List<AdresseDto> getAllAdresses() {
        return adresseRepository.findAll()
                .stream()
                .map(adresse -> modelMapper.map(adresse, AdresseDto.class))
                .collect(Collectors.toList());
    }


    public void deleteAdresse(int id) {
        Adresse adresse = adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse not found"));
        adresseRepository.delete(adresse);
    }
}