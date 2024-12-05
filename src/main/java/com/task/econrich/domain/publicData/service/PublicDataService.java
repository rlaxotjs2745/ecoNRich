package com.task.econrich.domain.publicData.service;


import com.task.econrich.domain.publicData.dto.PublicDataResDto;
import com.task.econrich.util.CustomException;
import com.task.econrich.util.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class PublicDataService {
    @Value("${public-data.service-key}")
    private String publicDataServiceKey;

    @Autowired
    private RestTemplate restTemplate;

    public PublicDataResDto.PublicDataResponse.PublicDataResponseBody.Item getPublicGangnamAirPollutionData() {
        URI uri = UriComponentsBuilder.fromUriString("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty")
                .queryParam("serviceKey", publicDataServiceKey)
                .queryParam("returnType", "json")
                .queryParam("numOfRows", "1")
                .queryParam("pageNo", "1")
                .queryParam("stationName", URLEncoder.encode("강남구", StandardCharsets.UTF_8))
                .queryParam("dataTerm", "DAILY")
                .queryParam("ver", "1.0")
                .build(true)
                .toUri();
        try {
            ResponseEntity<PublicDataResDto> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    PublicDataResDto.class
            );

            return response.getBody()
                    .response()
                    .body()
                    .items()
                    .get(0);
        } catch (Exception e) {
            throw new CustomException(ExceptionCode.INTERNAL_SERVER_ERROR);
        }
    }
}
