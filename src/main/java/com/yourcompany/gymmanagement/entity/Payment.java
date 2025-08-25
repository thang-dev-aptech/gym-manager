package com.yourcompany.gymmanagement.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.yourcompany.gymmanagement.enums.PaymentMethod;
import com.yourcompany.gymmanagement.enums.PaymentStatus;

import jakarta.persistence.*;


@Entity
@Table(name ="payments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name ="member_id",nullable = false, foreignKey = @ForeignKey(name = "fk_payment_member"))
    private Member member;

    @ManyToOne
    @JoinColumn(name = "membership_plan_id", foreignKey = @ForeignKey(name = "fk_payment_plan"))
    private MembershipPlan membershipPlan;

    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "payment_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime payDateTime;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private PaymentStatus status = PaymentStatus.PENDING;


    @Column(length = 100)
    private String transactionReference;

    @Lob
    private String notes;
}
