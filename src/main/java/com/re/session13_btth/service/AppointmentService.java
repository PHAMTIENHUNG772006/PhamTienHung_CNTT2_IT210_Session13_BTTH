package com.re.session13_btth.service;

import com.re.session13_btth.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getWaitingList();
    void save(Appointment a);
    void callPatient(Long id);
}