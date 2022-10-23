package com.bobocode.petros.propositionservice.domain.usecase;

import com.bobocode.petros.propositionservice.domain.dto.response.HotelResponseDto;
import com.bobocode.petros.propositionservice.domain.dto.request.HotelRequestDto;

import java.util.List;

public interface GetHotelsUseCase {
    List<HotelResponseDto> getHotels(HotelRequestDto request);
}
