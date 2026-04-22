package com.re.session13_btth.repository;

import com.re.session13_btth.model.Appointment;

import java.util.List;

public interface AppointmentRepository {
    List<Appointment> findAllWaiting();
    void save(Appointment a);
    Appointment findById(Long id);
    void update(Appointment a);
}