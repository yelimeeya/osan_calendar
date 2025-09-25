package com.osan.calendar.main.controller;

import com.osan.calendar.main.dto.CalendarDataResponse;
import com.osan.calendar.main.service.CalendarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;

import static com.osan.calendar.util.DateParserUtil.parseJsDateString;

@Controller
@RequestMapping("/main")
public class CalendarController {
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    // 달력(강의실 현황)
    @RequestMapping(value = "/calendar", method=RequestMethod.GET)
    public String calendar(HttpServletRequest request, Model model) {
        return "main/calendar"; // templates/calendar.html
    }

    // Ajax로 이벤트 데이터만 반환
    @RequestMapping(value = "/calendar/events", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CalendarDataResponse getCalendarEvents(HttpServletRequest request){
        LocalDate dateRangeStart = parseJsDateString(request.getParameter("dateRangeStart"));
        LocalDate dateRangeEnd = parseJsDateString(request.getParameter("dateRangeEnd"));

        return calendarService.getCalendarInfoByMonth(dateRangeStart, dateRangeEnd);
    }
}