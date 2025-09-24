package com.osan.calendar.main.service;

import com.osan.calendar.main.domain.Lecture;
import com.osan.calendar.main.dto.CalendarDataResponse;
import com.osan.calendar.main.dto.AttendeeCountDto;
import com.osan.calendar.main.dto.LectureDto;
import com.osan.calendar.main.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalendarService {
    private final LectureRepository lectureRepository;

    public CalendarService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public CalendarDataResponse getCalendarInfoByMonth(LocalDate dateRangeStart, LocalDate dateRangeEnd) {
        List<Lecture> lectures = lectureRepository.findByStartOrEndMonth(dateRangeStart, dateRangeEnd);

        List<LectureDto> lecturesDtoList = getLecturesInfo(lectures);
        List<AttendeeCountDto> attendeeCountList = getAttendeeCount(lectures);

        return new CalendarDataResponse(lecturesDtoList, attendeeCountList);
    }

    public List<LectureDto> getLecturesInfo(List<Lecture> lectures) {
        // 엔티티 리스트를 DTO 리스트로 변환
        return lectures.stream()
                .map(lecture -> new LectureDto(
                        lecture.getLectureSeq(),
                        lecture.getLectureName(),
                        lecture.getStartDate(), // LocalDate → String 변환
                        lecture.getEndDate(),
                        lecture.getAttendeeCount(),
                        lecture.getReservedCell()
                ))
                .collect(Collectors.toList());
    }

    public List<AttendeeCountDto> getAttendeeCount(List<Lecture> lectures) {

        // 날짜별 attendeeCount 합계 저장용 Map
        Map<LocalDate, Integer> attendeeCounts = new LinkedHashMap<>();

        // 각 강의별로, 해당 강의가 걸치는 날짜마다 attendeeCount를 누적
        for (Lecture lecture : lectures) {
            LocalDate startDate = lecture.getStartDate();
            LocalDate endDate = lecture.getEndDate();
            int attendeeCount = lecture.getAttendeeCount();

            // start ~ end 날짜까지 반복
            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                attendeeCounts.put(date, attendeeCounts.getOrDefault(date, 0) + attendeeCount);
            }
        }

        // Map을 DTO 리스트로 변환
        return attendeeCounts.entrySet().stream()
                .map(entry -> new AttendeeCountDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}