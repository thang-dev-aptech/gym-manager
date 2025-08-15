package com.yourcompany.gymmanagement.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import com.yourcompany.gymmanagement.model.enums.AttendanceStatus;
import java.time.LocalDateTime;

@Entity
@Table(name = "registrations",
       uniqueConstraints = @UniqueConstraint(columnNames = {"member_id", "class_schedule_id"}))
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_reg_member"))
    private Member member;

    @ManyToOne(optional = false)
    @JoinColumn(name = "class_schedule_id", foreignKey = @ForeignKey(name = "fk_reg_class"))
    private ClassSchedule classSchedule;

    @CreationTimestamp
    @Column(name = "registered_at", updatable = false)
    private LocalDateTime registeredAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "attendance_status", length = 10)
    @Builder.Default
    private AttendanceStatus attendanceStatus = AttendanceStatus.PENDING;

    @Lob
    private String notes;

}
