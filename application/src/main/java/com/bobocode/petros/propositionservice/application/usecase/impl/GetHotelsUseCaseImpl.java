package com.bobocode.petros.propositionservice.application.usecase.impl;

import com.bobocode.petros.hotelservice.proto.HotelRequest;
import com.bobocode.petros.hotelservice.proto.HotelServiceGrpc;
import com.bobocode.petros.propositionservice.domain.dto.enumeration.Currency;
import com.bobocode.petros.propositionservice.domain.dto.request.HotelRequestDto;
import com.bobocode.petros.propositionservice.domain.dto.response.HotelResponseDto;
import com.bobocode.petros.propositionservice.domain.usecase.GetHotelsUseCase;
import com.google.protobuf.Timestamp;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class GetHotelsUseCaseImpl implements GetHotelsUseCase {

    @GrpcClient("hotel-service")
    private HotelServiceGrpc.HotelServiceBlockingStub hotelServiceBlockingStub;

    @Override
    public List<HotelResponseDto> getHotels(final HotelRequestDto request) {
        var hotels = hotelServiceBlockingStub.getHotels(HotelRequest.newBuilder()
                                                          .setCountry(request.getCountry())
                                                          .setCity(request.getCity())
                                                          .setStartDate(Timestamp.newBuilder()
                                                                                .setSeconds(request.getStartDate().toEpochDay())
                                                                                .build())
                                                          .setEndDate(Timestamp.newBuilder()
                                                                              .setSeconds(request.getEndDate().toEpochDay())
                                                                              .build())
                                                          .build()).getHotelsList();
        return hotels.stream().map(h -> new HotelResponseDto()
                .setHotel(h.getHotel())
                .setStartDate(Instant.ofEpochSecond(h.getStartDate().getSeconds(), h.getStartDate().getNanos())
                                      .atZone(ZoneOffset.UTC)
                                      .toLocalDate())
                .setEndDate(Instant.ofEpochSecond(h.getEndDate().getSeconds(), h.getEndDate().getNanos())
                                    .atZone(ZoneOffset.UTC)
                                    .toLocalDate())
                .setPrice(new HotelResponseDto.Price().setCurrency(Currency.valueOf(h.getPrice().getCurrency())).setValue(h.getPrice().getPrice())))
                .toList();
    }
}
