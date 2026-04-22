package com.re.session13_btth.repository;

import com.re.session13_btth.model.Appointment;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.SessionScope;

import java.util.List;

@Repository
@Transactional
public class AppointmentRepositoryImpl implements AppointmentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Appointment> findAllWaiting() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Appointment WHERE status = 0 ORDER BY appointmentTime ASC", Appointment.class)
                .getResultList();
    }

    @Override
    public void save(Appointment a) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.persist(a);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Appointment findById(Long id) {
        return sessionFactory.getCurrentSession().get(Appointment.class, id);
    }

    @Override
    public void update(Appointment a) {
        sessionFactory.getCurrentSession().merge(a);
    }
}
