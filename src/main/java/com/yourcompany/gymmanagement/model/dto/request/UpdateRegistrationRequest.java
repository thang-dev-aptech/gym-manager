package com.yourcompany.gymmanagement.model.dto.request;

import com.yourcompany.gymmanagement.model.enums.AttendanceStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UpdateRegistrationRequest {
    @Positive(message = "Member ID must be greater than 0")
    private long id;
    @NotNull(message = "Status is required")
    private AttendanceStatus status;

    private String notes;

}
