package com.bobocode.petros.propositionservice.rest.controller;


import com.bobocode.petros.openapi.controller.PropositionApi;
import com.bobocode.petros.openapi.model.PropositionDto;
import com.bobocode.petros.openapi.model.PropositionRequestDto;
import com.bobocode.petros.propositionservice.domain.usecase.GetHotelsUseCase;
import com.bobocode.petros.propositionservice.domain.usecase.GetTicketsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PropositionController implements PropositionApi {
    private final GetTicketsUseCase getTicketsUseCase;
    private final GetHotelsUseCase getHotelsUseCase;

    @Override
    public ResponseEntity<PropositionDto> getAvailableProposition(PropositionRequestDto propositionRequestDto) {
        return ResponseEntity.ok(DtoUtils.getPropositionDto(propositionRequestDto,
                                                   getHotelsUseCase.getHotels(DtoUtils.getHotelRequestDto(propositionRequestDto)),
                                                   getTicketsUseCase.getTickets(DtoUtils.getTicketRequestDto(propositionRequestDto))));
    }


}
