package com.bobocode.petros.propositionservice.domain.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class TicketRequestDto {
    private String countryFrom;
    private String cityFrom;
    private String countryTo;
    private String cityTo;
    private LocalDate startDate;
    private LocalDate endDate;
}
