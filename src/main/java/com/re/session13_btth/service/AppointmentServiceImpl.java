package com.re.session13_btth.service;

import com.re.session13_btth.model.Appointment;
import com.re.session13_btth.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    @Override
    public List<Appointment> getWaitingList() {
        return repo.findAllWaiting();
    }

    @Override
    public void save(Appointment a) {
        repo.save(a);
    }

    @Override
    public void callPatient(Long id) {
        Appointment a = repo.findById(id);
        a.setStatus(1);
        repo.update(a);
    }
}