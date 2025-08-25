package com.yourcompany.gymmanagement.dto.request;




import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

import com.yourcompany.gymmanagement.enums.ClassScheduleStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateClassScheduleRequest {
    @Size(max = 100, message = "Class name cannot exceed 100 characters")
    private String className;
    
    private String description;
    
    @Size(max = 100, message = "Trainer name cannot exceed 100 characters")
    private String trainerName;
    
    @Future(message = "Start time must be in the future")
    private LocalDateTime startTime;
    
    @Future(message = "End time must be in the future")
    private LocalDateTime endTime;
    
    @Size(max = 100, message = "Location cannot exceed 100 characters")
    private String location;
    
    @Positive(message = "Max capacity must be positive")
    private Integer maxCapacity;
    
    private ClassScheduleStatus status;
}
