package com.yourcompany.gymmanagement.dto.request;
import lombok.*;
import java.time.LocalDate;

import com.yourcompany.gymmanagement.enums.EquipmentStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateEquipmentRequest {

    // id will be taken from path param

    private String name;
    private String description;
    private LocalDate purchaseDate;
    private LocalDate lastMaintenanceDate;
    private EquipmentStatus status;
    private String location;
    private String notes;
}