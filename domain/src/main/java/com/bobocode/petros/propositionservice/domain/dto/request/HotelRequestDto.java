package com.bobocode.petros.propositionservice.domain.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class HotelRequestDto {
    private String country;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
}
