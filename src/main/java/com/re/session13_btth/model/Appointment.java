package com.re.session13_btth.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, message = "Tên phải >= 5 ký tự")
    private String patientName;


    @NotBlank(message = "SĐT không được để trống")
    private String phoneNumber;


    @NotNull(message = "Phải chọn giờ khám")

    private LocalTime appointmentTime;


    @NotBlank(message = "Không được để trống lý do")
    private String reason;

    private int status = 0;
}