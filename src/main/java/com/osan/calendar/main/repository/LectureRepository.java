package com.osan.calendar.main.repository;

import com.osan.calendar.main.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

    @Query("SELECT l FROM Lecture l WHERE l.endDate >= :dateRangeStart AND l.startDate <= :dateRangeEnd")
    List<Lecture> findByStartOrEndMonth(@Param("dateRangeStart") LocalDate dateRangeStart, @Param("dateRangeEnd") LocalDate dateRangeEnd);

}