package com.yourcompany.gymmanagement.model.entity;
import com.yourcompany.gymmanagement.model.enums.MemberStatus;
import com.yourcompany.gymmanagement.model.enums.Gender;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Lob
    private String notes;

    @Column(name = "join_date", nullable = false)
    private LocalDate joinDate;

    @Column(name = "expired_date")
    private LocalDate expiredDate;

    @ManyToOne
    @JoinColumn(
        name = "membership_plan_id",
        foreignKey = @ForeignKey(name = "fk_member_plan")
    )
    private MembershipPlan membershipPlan;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    @Builder.Default
    private MemberStatus status = MemberStatus.ACTIVE;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    
}
