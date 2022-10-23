package com.bobocode.petros.propositionservice.application.usecase.impl;

import com.bobocode.petros.propositionservice.domain.dto.request.TicketRequestDto;
import com.bobocode.petros.propositionservice.domain.dto.response.TicketResponseDto;
import com.bobocode.petros.propositionservice.domain.usecase.GetTicketsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTicketsUseCaseImpl implements GetTicketsUseCase {

    @Override
    public List<TicketResponseDto> getTickets(final TicketRequestDto request) {
        return List.of();
    }
}
