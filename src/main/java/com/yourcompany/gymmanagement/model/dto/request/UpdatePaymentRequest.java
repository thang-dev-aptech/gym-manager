package com.yourcompany.gymmanagement.model.dto.request;

import com.yourcompany.gymmanagement.model.enums.PaymentStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UpdatePaymentRequest {
    @Positive(message = "id is required")
    private long id;

    @NotNull(message = "status is required")
    private PaymentStatus paymentStatus;
}
