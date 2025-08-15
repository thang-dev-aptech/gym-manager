package com.yourcompany.gymmanagement.model.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEquipmentRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    private String description;

    @NotNull(message = "Purchase date is required")
    private LocalDate purchaseDate;

    private LocalDate lastMaintenanceDate;

    private String location;

    private String notes;
}