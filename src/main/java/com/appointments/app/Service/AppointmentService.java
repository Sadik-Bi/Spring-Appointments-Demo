package com.appointments.app.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointments.app.Model.Appointments;
import com.appointments.app.Repository.AppointmentsRepository;

@Service
public class AppointmentService {
	@Autowired
	AppointmentsRepository appointmentsRepository;

	public List<Appointments> findAllAppointments() {
		// TODO Auto-generated method stub
		return (List<Appointments>) appointmentsRepository.findAll();
	}

	public Optional<Appointments> findAppointmentsById(Long appointmentId) {

		return appointmentsRepository.findById(appointmentId);
	}

	public void deleteById(Long appointmentId) {
		appointmentsRepository.deleteById(appointmentId);
	}

	public List<Appointments> findByDateRangeOrderedByPrice(LocalDate startDate, LocalDate endDate) {

		return appointmentsRepository.findAllByAppointmentDateBetweenOrderByPriceAsc(startDate, endDate);

	}

	public Appointments saveAppointments(Appointments appointmentHistory) {
		return appointmentsRepository.save(appointmentHistory);
	}

	public Appointments updateAppointment( Appointments appointment) {
		// TODO Auto-generated method stub
		return appointmentsRepository.save(appointment);
	}

	public Appointments updateStatus(Appointments appointment) {
		// TODO Auto-generated method stub
		return appointmentsRepository.save(appointment);
	}

}
