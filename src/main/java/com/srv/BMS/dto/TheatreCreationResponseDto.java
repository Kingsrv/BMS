package com.srv.BMS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreCreationResponseDto {

    private Long theatreId;
    private String theatreName;
    private String theatreAddress;
    private String cityName;
}
