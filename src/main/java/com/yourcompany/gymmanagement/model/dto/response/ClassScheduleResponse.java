package com.yourcompany.gymmanagement.model.dto.response;

import com.yourcompany.gymmanagement.model.enums.ClassScheduleStatus;
import lombok.*;

import java.time.LocalDateTime;

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