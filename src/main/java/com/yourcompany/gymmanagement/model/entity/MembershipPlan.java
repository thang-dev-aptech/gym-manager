package com.yourcompany.gymmanagement.model.entity;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "membership_plans")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // hibernate yêu cầu contructor không tham số 
@AllArgsConstructor(access =  AccessLevel.PRIVATE) // chỉ dùng trong builder
@Builder(toBuilder = true) // hỗ trợ update inmutable object
public class MembershipPlan {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "plan_name", nullable = false, length = 50)
    private String planName;

    @Lob
    private String description;

    @Column(name = "duration_month", nullable= false)
    private Integer durationMonth;

    @Column (nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "is_active" , nullable = false)
    @Builder.Default
    private Boolean isActive = true;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "membershipPlan", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Member> members = new ArrayList<>();

}
