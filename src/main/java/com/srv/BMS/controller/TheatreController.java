package com.srv.BMS.controller;

import com.srv.BMS.dto.TheatreCreationRequestDto;
import com.srv.BMS.dto.TheatreCreationResponseDto;
import com.srv.BMS.model.Theatre;
import com.srv.BMS.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {

    private TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("/theatre")
    public TheatreCreationResponseDto createTheatre(@RequestBody TheatreCreationRequestDto theatreCreationRequestDto){
        Theatre savedTheatre = theatreService.createTheatre(theatreCreationRequestDto.getTheatreName(), theatreCreationRequestDto.getTheatreAddress(), theatreCreationRequestDto.getCityId());

        //create a dto to return

        TheatreCreationResponseDto theatreCreationResponseDto = new TheatreCreationResponseDto();
        theatreCreationResponseDto.setTheatreId(savedTheatre.getId());
        theatreCreationResponseDto.setTheatreName(savedTheatre.getName());
        theatreCreationResponseDto.setTheatreAddress(savedTheatre.getAddress());
        theatreCreationResponseDto.setCityName(savedTheatre.getCity().getName());

        return theatreCreationResponseDto;
    }
}
