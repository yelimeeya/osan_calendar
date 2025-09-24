package com.osan.calendar.main.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "oc_lecture") // ← 이 부분 추가!
public class Lecture {

    @Id
    @Column(nullable = false, name = "lecture_seq")
    private int lectureSeq;

    @Column(nullable = false, name = "start_date")
    private LocalDate startDate;

    @Column(nullable = false, name = "end_date")
    private LocalDate endDate;

    @Column(nullable = false, name = "lecture_name")
    private String lectureName;

    @Column(nullable = false, name = "attendee_count")
    private int attendeeCount;

    @Column(nullable = false, name = "reserved_cell")
    private String reservedCell;
}