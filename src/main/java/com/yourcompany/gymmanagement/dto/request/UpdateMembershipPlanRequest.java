package com.yourcompany.gymmanagement.dto.request;



import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class UpdateMembershipPlanRequest {

    @NotBlank(message = "Plan name cannot be blank")
    @Size(max = 50, message = "Plan name must be less than 50 characters")
    private String planName;

    @Lob
    private String description;

    @NotNull(message = "Duration month cannot be null")
    @Min(value = 1, message = "Duration must be at least 1 month")
    private Integer durationMonth;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price must have 10 digits total and 2 decimal places")
    private BigDecimal price;

    @Builder.Default
    private Boolean isActive = true;
}
