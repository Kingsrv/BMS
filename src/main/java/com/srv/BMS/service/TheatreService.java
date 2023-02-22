package com.srv.BMS.service;

import com.srv.BMS.dto.TheatreCreationResponseDto;
import com.srv.BMS.exception.CityNotFoundException;
import com.srv.BMS.model.City;
import com.srv.BMS.model.Theatre;
import com.srv.BMS.repository.CityRepository;
import com.srv.BMS.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TheatreService {

    private TheatreRepository theatreRepository;

    private CityRepository cityRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository, CityRepository cityRepository) {
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
    }

    public Theatre createTheatre(String name, String address, Long cityId){
        //check if the city exists or not
        Optional<City> cityOptional = cityRepository.findById(cityId);

        if(cityOptional.isEmpty()){
            throw new CityNotFoundException("City not found with Id : " + cityId);
        }

        // create a theatre object

        Theatre t = new Theatre();
        t.setName(name);
        t.setAddress(address);
        t.setCity(cityOptional.get());

        //saving the theatre in DB
        Theatre savedTheatre = theatreRepository.save(t);

        //getting saved city from the database
        City dbCity = cityOptional.get();

        //add the theatre to the city

        if(dbCity.getTheatres() == null){
            dbCity.setTheatres(new ArrayList<>());
        }

        dbCity.getTheatres().add(t);

        //update the city in the database
        this.cityRepository.save(dbCity);

        return savedTheatre;



    }
}
