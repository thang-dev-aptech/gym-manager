package com.yourcompany.gymmanagement.dto.request;

import com.yourcompany.gymmanagement.enums.PaymentStatus;

import jakarta.validation.constraints.NotNull;

public class UpdatePaymentRequest {

    @NotNull(message = "status is required")
    private PaymentStatus paymentStatus;
}
