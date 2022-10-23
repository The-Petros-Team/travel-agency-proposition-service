package com.bobocode.petros.propositionservice.rest.controller;

import com.bobocode.petros.openapi.model.HotelDto;
import com.bobocode.petros.openapi.model.PriceDto;
import com.bobocode.petros.openapi.model.PropositionDto;
import com.bobocode.petros.openapi.model.PropositionRequestDto;
import com.bobocode.petros.openapi.model.TicketDto;
import com.bobocode.petros.propositionservice.domain.dto.response.HotelResponseDto;
import com.bobocode.petros.propositionservice.domain.dto.request.HotelRequestDto;
import com.bobocode.petros.propositionservice.domain.dto.request.TicketRequestDto;
import com.bobocode.petros.propositionservice.domain.dto.response.TicketResponseDto;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public class DtoUtils {
    public PropositionDto getPropositionDto(
            PropositionRequestDto propositionRequestDto,
            List<HotelResponseDto> hotels,
            List<TicketResponseDto> tickets) {
        var propositionDto = new PropositionDto();
        propositionDto.setCountry(propositionRequestDto.getCountryTo());
        propositionDto.setCity(propositionRequestDto.getCityTo());
        propositionDto.setStartDate(propositionRequestDto.getStartDate());
        propositionDto.setEndDate(propositionRequestDto.getEndDate());
        propositionDto.setHotels(hotels.stream().map(h -> mapToHotelDto(h, tickets)).toList());
        return propositionDto;
    }

    private HotelDto mapToHotelDto(HotelResponseDto hotelResponseDto, List<TicketResponseDto> tickets) {
        var hotelDto = new HotelDto();
        hotelDto.setAvailable(true);
        hotelDto.setName(hotelResponseDto.getHotel());
        hotelDto.setDescription(hotelResponseDto.getHotel());
        hotelDto.setPrice(mapToPriceDto(hotelResponseDto.getPrice()));
        hotelDto.setStars(ThreadLocalRandom.current().nextInt(5));
        hotelDto.setTickets(tickets.stream().map(DtoUtils::mapToTicketDto).toList());
        return hotelDto;
    }

    private PriceDto mapToPriceDto(HotelResponseDto.Price price) {
        var priceDto = new PriceDto();
        priceDto.setValue(price.getValue());
        priceDto.setCurrency(PriceDto.CurrencyEnum.fromValue(price.getCurrency().name()));
        return priceDto;
    }

    private TicketDto mapToTicketDto(TicketResponseDto ticketResponseDto) {
        var ticketDto = new TicketDto();
        ticketDto.setCityFrom(ticketResponseDto.getCityFrom());
        ticketDto.setCityFrom(ticketResponseDto.getCityFrom());
        ticketDto.setCountryTo(ticketResponseDto.getCountryTo());
        ticketDto.setCityTo(ticketResponseDto.getCityTo());
        ticketDto.setPrice(ticketResponseDto.getPrice());
        ticketDto.setFlightDate(ticketResponseDto.getFlightDate());
        ticketDto.setPropertyClass(TicketDto.PropertyClassEnum.valueOf(ticketResponseDto.getFlightClass().name()));
        return ticketDto;
    }

    public HotelRequestDto getHotelRequestDto(PropositionRequestDto propositionRequestDto) {
        return new HotelRequestDto()
                .setCountry(propositionRequestDto.getCountryTo())
                .setCity(propositionRequestDto.getCityTo())
                .setStartDate(propositionRequestDto.getStartDate())
                .setEndDate(propositionRequestDto.getEndDate());
    }

    public TicketRequestDto getTicketRequestDto(PropositionRequestDto propositionRequestDto) {
        return new TicketRequestDto()
                .setCountryFrom(propositionRequestDto.getCountryFrom())
                .setCityFrom(propositionRequestDto.getCityFrom())
                .setCountryTo(propositionRequestDto.getCountryTo())
                .setCityTo(propositionRequestDto.getCityTo())
                .setStartDate(propositionRequestDto.getStartDate())
                .setEndDate(propositionRequestDto.getEndDate());
    }
}
