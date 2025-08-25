package com.yourcompany.gymmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import com.yourcompany.gymmanagement.enums.EquipmentStatus;

@Entity
@Table(name = "equipment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Lob
    private String description;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "last_maintenance_date")
    private LocalDate lastMaintenanceDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    @Builder.Default
    private EquipmentStatus status = EquipmentStatus.AVAILABLE;

    @Column(length = 100)
    private String location;

    @Lob
    private String notes;


}
