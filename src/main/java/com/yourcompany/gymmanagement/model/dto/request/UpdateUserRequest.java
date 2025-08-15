package com.yourcompany.gymmanagement.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.yourcompany.gymmanagement.model.enums.Role;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserRequest {
    @NotNull(message = "id is required")
    private long id;

    @NotBlank(message = "user cannot be blank")
    @Size(min = 4, max = 20, message = "user must be 4-20 characters")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{3,19}$", message = "Username can only contain letters, numbers and underscores")
    private String userName;


    @NotBlank(message = "email cannot be email")
    @Email(message = "email format is invaild")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    @Pattern(
        regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
        message = "Email phải có định dạng example@domain.com"
    )
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "Password must contain at least 1 uppercase, 1 lowercase, 1 number and 1 special character"
    )
    private String password;


    @NotNull(message = "Role is required")
    private Role role; // Enum: ADMIN, STAFF, TRAINER, MEMBER

    // Optional fields
    private Long memberId; // For linking to member profile

    @Builder.Default
    private Boolean isActive = true;

}
