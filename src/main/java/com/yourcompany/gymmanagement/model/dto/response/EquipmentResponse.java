package com.yourcompany.gymmanagement.model.dto.response;
import com.yourcompany.gymmanagement.model.enums.EquipmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
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