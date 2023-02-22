package com.srv.BMS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreCreationRequestDto {

    private Long cityId;
    private String theatreName;
    private String theatreAddress;
}
