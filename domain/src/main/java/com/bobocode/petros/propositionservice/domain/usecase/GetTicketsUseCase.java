package com.bobocode.petros.propositionservice.domain.usecase;

import com.bobocode.petros.propositionservice.domain.dto.request.TicketRequestDto;
import com.bobocode.petros.propositionservice.domain.dto.response.TicketResponseDto;

import java.util.List;

public interface GetTicketsUseCase {

    List<TicketResponseDto> getTickets(TicketRequestDto request);
}
