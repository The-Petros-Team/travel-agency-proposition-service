package com.bobocode.petros.propositionservice.domain.dto.response;

import com.bobocode.petros.propositionservice.domain.dto.enumeration.FlightClass;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class TicketResponseDto {
    private FlightClass flightClass;
    private String countryFrom;
    private String cityFrom;
    private String countryTo;
    private String cityTo;
    private LocalDate flightDate;
    private Long price;
}
