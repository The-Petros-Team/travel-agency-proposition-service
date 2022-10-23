package com.bobocode.petros.propositionservice.application.usecase.impl;

import com.bobocode.petros.propositionservice.domain.dto.response.HotelResponseDto;
import com.bobocode.petros.propositionservice.domain.dto.request.HotelRequestDto;
import com.bobocode.petros.propositionservice.domain.usecase.GetHotelsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHotelsUseCaseImpl implements GetHotelsUseCase {
    @Override
    public List<HotelResponseDto> getHotels(final HotelRequestDto request) {
        return List.of();
    }
}
