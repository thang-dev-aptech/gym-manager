package com.yourcompany.gymmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yourcompany.gymmanagement.enums.Gender;
import com.yourcompany.gymmanagement.enums.MemberStatus;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDate birthDate;

    private Gender gender;

    private String notes;

    // Ngày tham gia
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate joinDate;

    // Ngày hết hạn
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate expiredDate;

    private MemberStatus status;

    // Thời gian tạo
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdAt;

    // Thời gian cập nhật
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updatedAt;

    private MembershipPlanResponse membershipPlan;
}