package com.srv.BMS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{

    private String name;

    @Column(name = "seat_row")
    private int row;

    @Column(name = "seat_column")
    private int column;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}
