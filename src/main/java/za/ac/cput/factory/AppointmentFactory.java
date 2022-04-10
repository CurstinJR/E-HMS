package za.ac.cput.factory;

import za.ac.cput.entity.Appointment;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/*
Appointment.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

public class AppointmentFactory {

    public static Appointment createApppointment (String appointmentTime, LocalDate appointmentDate){

        Long appointmentId = Helper.generateId();

        return new Appointment.Builder().appointmentId(appointmentId)
                .appointmentTime(appointmentTime)
                .appointmentDate(appointmentDate)
                .build();
    }
}
