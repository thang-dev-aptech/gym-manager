package com.yourcompany.gymmanagement.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.*;

import com.yourcompany.gymmanagement.enums.PaymentMethod;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePaymentRequest {
    @NotNull(message = "member id is required")
    private long memberId;

    @Positive(message = "amount must be Positive")
    @Digits(integer = 10, fraction = 2, message = "invaild amount fotmat")
    private BigDecimal amount;

    @NotNull(message = "payment method is required")
    private PaymentMethod paymentMethod;

    @Size(max = 100, message = "Transaction reference too long")
    private String transactionReference;

    @Size(max = 500, message = "notes too long")
    private String notes;
}
