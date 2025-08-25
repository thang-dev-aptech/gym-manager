package com.yourcompany.gymmanagement.dto.request;

import com.yourcompany.gymmanagement.enums.AttendanceStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UpdateRegistrationRequest {
    @NotNull(message = "Status is required")
    private AttendanceStatus status;

    private String notes;

}
