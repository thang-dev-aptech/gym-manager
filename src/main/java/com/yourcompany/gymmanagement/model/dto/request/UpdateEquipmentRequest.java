package com.yourcompany.gymmanagement.model.dto.request;
import com.yourcompany.gymmanagement.model.enums.EquipmentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateEquipmentRequest {

    @NotNull(message = "ID is required")
    private Long id;

    private String name;
    private String description;
    private LocalDate purchaseDate;
    private LocalDate lastMaintenanceDate;
    private EquipmentStatus status;
    private String location;
    private String notes;
}