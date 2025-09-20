package com.osan.calendar.main.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/main")
public class AccommodationController {

    // 숙소 현황
    @GetMapping("/accommodation")
    public String accommodation() {
        return "/main/accommodation";
    }

    @GetMapping("/api/accommodation/data")
    public ResponseEntity<String> getAccommodationData() throws Exception {
        ClassPathResource resource = new ClassPathResource("mock/accommodation_mock_data.json");
        String jsonData = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
System.out.println(jsonData);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(jsonData);
    }
}
