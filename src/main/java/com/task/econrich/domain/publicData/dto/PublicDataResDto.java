package com.task.econrich.domain.publicData.dto;

import java.util.List;

public record PublicDataResDto(
        PublicDataResponse response
) {
    public record PublicDataResponse(
        PublicDataResponseHeader header,
        PublicDataResponseBody body
    ){
        public record PublicDataResponseHeader(
                String resultCode,
                String resultMsg
        ){}

        public record PublicDataResponseBody(
                List<Item> items,
                int totalCount
        ){
            public record Item(
                    String stationName,
                    String dataTime,
                    String pm10Value,
                    String pm25Value,
                    String khaiValue
            ){}
        }
    }
}
