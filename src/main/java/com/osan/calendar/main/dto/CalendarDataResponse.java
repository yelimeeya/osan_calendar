package com.osan.calendar.main.dto;

import java.util.List;

public class CalendarDataResponse {
    private List<LectureDto> lectures;
    private List<AttendeeCountDto> attendeeCounts;

    public CalendarDataResponse(List<LectureDto> lectures, List<AttendeeCountDto> attendeeCounts) {
        this.lectures = lectures;
        this.attendeeCounts = attendeeCounts;
    }

    public List<LectureDto> getLectures() { return lectures; }
    public List<AttendeeCountDto> getAttendeeCounts() { return attendeeCounts; }
}