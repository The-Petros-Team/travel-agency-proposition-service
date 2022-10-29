package com.bobocode.petros.propositionservice.application.usecase.impl;

import com.bobocode.petros.propositionservice.domain.dto.request.TicketRequestDto;
import com.bobocode.petros.propositionservice.domain.dto.response.TicketResponseDto;
import com.bobocode.petros.propositionservice.domain.usecase.GetTicketsUseCase;
import com.bobocode.petros.ticketservice.proto.TicketRequest;
import com.bobocode.petros.ticketservice.proto.TicketServiceGrpc;
import com.google.protobuf.Timestamp;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class GetTicketsUseCaseImpl implements GetTicketsUseCase {

    @GrpcClient("ticket-service")
    private TicketServiceGrpc.TicketServiceBlockingStub ticketServiceBlockingStub;

    @Override
    public List<TicketResponseDto> getTickets(final TicketRequestDto request) {
        return ticketServiceBlockingStub.getTickets(TicketRequest.newBuilder()
                                                            .setCountryFrom(request.getCountryFrom())
                                                            .setCityFrom(request.getCityFrom())
                                                            .setCountryTo(request.getCountryTo())
                                                            .setCityTo(request.getCountryTo())
                                                            .setStartDate(Timestamp.newBuilder()
                                                                                  .setSeconds(request.getStartDate().toEpochDay())
                                                                                  .build())
                                                            .setEndDate(Timestamp.newBuilder()
                                                                                .setSeconds(request.getEndDate().toEpochDay())
                                                                                .build())
                                                            .build())
                .getTicketsList()
                .stream()
                .map(ticket -> new TicketResponseDto()
                        .setCountryFrom(ticket.getCountryFrom())
                        .setCityFrom(ticket.getCityFrom())
                        .setCountryTo(ticket.getCountryTo())
                        .setCityTo(ticket.getCityTo())
                        .setFlightDate(Instant.ofEpochSecond(ticket.getFlightDate().getSeconds(),ticket.getFlightDate().getNanos())
                                               .atZone(ZoneOffset.UTC)
                                               .toLocalDate())
                        .setPrice(ticket.getPrice()))
                .toList();
    }
}
