package com.osan.calendar.main.dto;

import java.time.LocalDate;

public class AttendeeCountDto {
    private LocalDate date;
    private int attendeeCount;

    public AttendeeCountDto(LocalDate date, int attendeeCount) {
        this.date = date;
        this.attendeeCount = attendeeCount;
    }

    public LocalDate getDate() { return date; }
    public int getAttendeeCount() { return attendeeCount; }
}