package com.appointments.app.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.appointments.app.Model.Appointments;


public interface AppointmentsRepository extends CrudRepository<Appointments,Long> {
	 List<Appointments>findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate startDate,LocalDate endDate);
	 
}
