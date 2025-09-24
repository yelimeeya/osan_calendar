package com.osan.calendar.main.dto;

import com.osan.calendar.main.constants.CellMap;

import java.time.LocalDate;

public class LectureDto {
    private int id;
    private String title;
    private LocalDate start;
    private LocalDate end;
    private int attendees;
    private String reservedCell;
    private final String calendarId = "cal";
    private final Boolean isAllday = true;
    private final String category = "allday";
    private String backgroundColor;


    public LectureDto(int id, String title, LocalDate start, LocalDate end, int attendees, String reservedCell) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.attendees = attendees;
        this.reservedCell = reservedCell;

        // CellMap에서 색상 정보 가져오기
        CellMap.CellInfo cellInfo = CellMap.getCellInfo(reservedCell);
        if (cellInfo != null) {
            this.backgroundColor = cellInfo.backgroundColor;
        } else {
            this.backgroundColor = "#FFFFFF"; // 기본값
        }
    }

    // getter, setter (필요시)
    public int getId() { return id; }
    public String getTitle() { return title; }
    public LocalDate getStart() { return start; }
    public LocalDate getEnd() { return end; }
    public int getAttendees() { return attendees; }
    public String getReservedCell() { return reservedCell; }
    public String getCategory() { return category; }
    public Boolean getIsAllday() { return isAllday; }
    public String getCalendarId() { return calendarId; }
    public String getBackgroundColor() { return backgroundColor; }
}