package com.yourcompany.gymmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yourcompany.gymmanagement.enums.PaymentMethod;
import com.yourcompany.gymmanagement.enums.PaymentStatus;

import java.time.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponse {
    private long id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;
    private String transactionReference;
    private String notes;

    
}
