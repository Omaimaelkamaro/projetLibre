package com.example.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AdresseDto;
import com.example.entities.Adresse;
import com.example.repository.AdresseRepository;
import com.example.service.AdresseService;

@Service
public class AdresseServiceImpl implements AdresseService {

    @Autowired
    private AdresseRepository adresseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdresseDto addAdresse(AdresseDto adresseDTO) {
        Adresse adresse = modelMapper.map(adresseDTO, Adresse.class);
        adresse = adresseRepository.save(adresse);
        return modelMapper.map(adresse, AdresseDto.class);
    }

    @Override
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

    @Override
    public AdresseDto getAdresseById(int id) {
        Adresse adresse = adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse not found"));
        return modelMapper.map(adresse, AdresseDto.class);
    }

    @Override
    public List<AdresseDto> getAllAdresses() {
        return adresseRepository.findAll()
                .stream()
                .map(adresse -> modelMapper.map(adresse, AdresseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAdresse(int id) {
        Adresse adresse = adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse not found"));
        adresseRepository.delete(adresse);
    }
}