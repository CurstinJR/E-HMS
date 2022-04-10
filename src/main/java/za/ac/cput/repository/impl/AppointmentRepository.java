package za.ac.cput.repository.impl;

import za.ac.cput.entity.Appointment;
import za.ac.cput.entity.Bill;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class AppointmentRepository implements IAppointment{
    private static AppointmentRepository appointmentRepository = null;

    private Collection<Appointment> appointmentDB = null;

    private AppointmentRepository()
    {
        appointmentDB = new ArrayList<>();
    }

    public static AppointmentRepository getAppointmentRepository()
    {
        return appointmentRepository == null ?
                appointmentRepository = new AppointmentRepository() :
                appointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment)
    {
        appointmentDB.add(appointment);
        return appointment;
    }

    @Override
    public Optional<Appointment> findById(Long appointmenId)
    {
        Appointment appointment = appointmentDB.stream()
                .filter(a -> a.getAppointmentId().equals(appointmenId))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(appointment);
    }

    @Override
    public Collection<Appointment> findAll()

    {
        return appointmentDB;
    }

    @Override
    public Appointment update(Appointment appointment)
    {
        Long appointmentId = appointment.getAppointmentId();
        Appointment oldAppointment = findById(appointmentId).orElseThrow();
        appointmentDB.remove(oldAppointment);

        appointmentDB.add(appointment);

        return appointment;
    }

    @Override
    public boolean deleteById(Long appointmentId)
    {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointmentDB.remove(appointment);
        return true;
    }

    @Override
    public boolean existsById(Long appointmentId)
    {
        appointmentDB.stream()
                .anyMatch(appointment ->appointment.getAppointmentId ().equals(appointmentId));
        return true;
    }
}
