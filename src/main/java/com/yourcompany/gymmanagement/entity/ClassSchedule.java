package com.yourcompany.gymmanagement.entity;

import lombok.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.yourcompany.gymmanagement.enums.ClassScheduleStatus;

import jakarta.persistence.*;


@Entity
@Table(name = "class_schedules")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // hibernate yêu cầu contructor không tham số 
@AllArgsConstructor(access =  AccessLevel.PRIVATE) // chỉ dùng trong builder
@Builder(toBuilder = true) // hỗ trợ update inmutable object
public class ClassSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String className;

    @Lob
    private String description;

    @Column(nullable = false, length = 100)
    private String trainerName;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name="location", length = 100)
    private String location;

    @Column(name = " max_capacity", nullable = false)
    private Integer maxCapacity;
    
    @Column(name = " current_capacity", nullable = false)
    @Builder.Default
    private Integer currentCapacity = 0;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ClassScheduleStatus status = ClassScheduleStatus.ACTIVE;
    
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
 }
