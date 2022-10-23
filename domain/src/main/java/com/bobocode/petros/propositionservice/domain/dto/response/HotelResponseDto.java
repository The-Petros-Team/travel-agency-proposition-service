package com.bobocode.petros.propositionservice.domain.dto.response;

import com.bobocode.petros.propositionservice.domain.dto.enumeration.Currency;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HotelResponseDto {
    private String hotel;
    private LocalDate startDate;
    private LocalDate endDate;
    private Price price;

    @Data
    public static class Price {
        private Integer value;
        private Currency currency;
    }
}
