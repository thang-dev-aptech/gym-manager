package com.yourcompany.gymmanagement.model.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import com.yourcompany.gymmanagement.model.enums.Gender;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateMemberRequest {
    @NotBlank(message = "first name is required")
    @Size(max = 50, message = "First name must be less than 50 characters")
    private String firstName;


    @NotBlank(message = "first name is required")
    @Size(max = 50, message = "First name must be less than 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "email should be vaild")
    @Size(max = 100, message = "Email must be less than 100 characters")
    private String email;

    @Size(max = 20, message = "Phone number must be less than 20 characters")
    private String phone;

    private LocalDate birthDate;

    private Gender gender;

    private String notes;

    @NotNull(message = "joinDate is required")
    private LocalDate joinDate;

    @NotNull(message = "membershipPlanId is required")
    private Long membershipPlanId;
}
