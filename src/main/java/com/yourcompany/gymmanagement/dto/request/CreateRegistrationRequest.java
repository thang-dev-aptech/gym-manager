package com.yourcompany.gymmanagement.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRegistrationRequest {
    @Positive(message = "Member ID must be greater than 0")
    private long memberId;

    @Positive(message = "class schedule id must be greater than 0")
    private long classScheduleId;

    String notes;

    

}
