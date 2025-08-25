package com.yourcompany.gymmanagement.dto.response;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yourcompany.gymmanagement.enums.EquipmentStatus;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentResponse {

    private Long id;

    private String name;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDate purchaseDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDate lastMaintenanceDate;

    private EquipmentStatus status;

    private String location;

    private String notes;
}