package com.bobocode.petros.propositionservice.domain.dto.response;

import com.bobocode.petros.propositionservice.domain.dto.enumeration.Currency;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class HotelResponseDto {
    private String hotel;
    private LocalDate startDate;
    private LocalDate endDate;
    private Price price;

    @Data
    public static class Price {
        private Long value;
        private Currency currency;
    }
}
