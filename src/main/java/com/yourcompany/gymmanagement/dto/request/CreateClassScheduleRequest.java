package com.yourcompany.gymmanagement.dto.request;

import java.time.LocalDateTime;

import com.yourcompany.gymmanagement.enums.ClassScheduleStatus;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateClassScheduleRequest {
    @NotBlank(message = "classname is required")
    @Size(max = 100, message = "classname có độ dài 100 kí tự")
    private String className;

    private String description;

    @NotBlank(message = "trainerName is required")
    @Size(max = 100, message = "trainerName có độ dài 100 kí tự")
    private String trainerName;

    @NotNull(message = "Start time is required")
    @Future(message = "Start time must be in the future")
    private LocalDateTime startTime;
    
    @Future(message = "End time must be in the future")
    private LocalDateTime endTime;
    
    @Size(max = 100, message = "Location cannot exceed 100 characters")
    private String location;
    
    @NotNull(message = "Max capacity is required")
    @Positive(message = "Max capacity must be positive")
    private Integer maxCapacity;
    
    @Builder.Default
    private ClassScheduleStatus status = ClassScheduleStatus.ACTIVE;
}
