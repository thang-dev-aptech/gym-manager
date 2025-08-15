package com.yourcompany.gymmanagement.model.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yourcompany.gymmanagement.model.enums.AttendanceStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationResponse {
    private long id; 
    private Long memberId;
    private String memberName;

    private Long classScheduleId;
    private String className;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime registeredAt;

    private AttendanceStatus attendanceStatus;

    private String notes;
}
