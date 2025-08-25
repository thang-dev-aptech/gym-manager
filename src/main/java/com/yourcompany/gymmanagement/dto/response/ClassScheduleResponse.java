package com.yourcompany.gymmanagement.dto.response;

import lombok.*;

import java.time.LocalDateTime;

import com.yourcompany.gymmanagement.enums.ClassScheduleStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassScheduleResponse {
    private Long id;
    private String className;
    private String description;
    private String trainerName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private Integer maxCapacity;
    private Integer currentCapacity;
    private ClassScheduleStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}