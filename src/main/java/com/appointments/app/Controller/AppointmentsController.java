package com.appointments.app.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appointments.app.Model.Appointments;
import com.appointments.app.Service.AppointmentService;


@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentsController {
	@Autowired
	private AppointmentService appointmentService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public Appointments saveAppointments(@RequestBody Appointments appointmentHistory){
		
		return appointmentService.saveAppointments(appointmentHistory);
	}
	
	
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public List<Appointments> findAllAppointments(){
		return  appointmentService.findAllAppointments();
	}
	
	@RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
	public Optional<Appointments> findAppointmentsById(@PathVariable("appointmentId") Long Id){
		return appointmentService.findAppointmentsById(Id);
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/{appointmentId}", method = RequestMethod.DELETE)
	public void deleteAppointmentsById(@PathVariable("appointmentId") Long Id){
		 appointmentService.deleteById(Id);
	}
	
	@RequestMapping(method =RequestMethod.GET)
	public List<Appointments>findByDateRangeOrderedByPrice(@DateTimeFormat(iso=ISO.DATE)@RequestParam("startDate")LocalDate startDate,
			@DateTimeFormat(iso=ISO.DATE)@RequestParam("endDate")LocalDate endDate){
		return appointmentService.findByDateRangeOrderedByPrice(startDate, endDate);
	}
	
	
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Appointments updateAppointment(@PathVariable("appointmentId") Long Id, @RequestBody Appointments appointment) {
    	Optional<Appointments> updateApppintments=appointmentService.findAppointmentsById(Id);
    	if(updateApppintments.isPresent()) {
    		updateApppintments.get().setAppointmentDate(appointment.getAppointmentDate());
        	updateApppintments.get().setAppointmentEndTime(appointment.getAppointmentEndTime());
        	updateApppintments.get().setAppointmentStartTime(appointment.getAppointmentStartTime());
        	updateApppintments.get().setNameOfDoctor(appointment.getNameOfDoctor());
        	updateApppintments.get().setPrice(appointment.getPrice());
        	updateApppintments.get().setStatus(appointment.getStatus());
        	return appointmentService.updateAppointment(updateApppintments.get());
    	}
    	else {
    		appointment.setAppointmentId(Id);
    		
    		return appointmentService.updateAppointment(appointment);
    	}
    	
        
    }

    
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    public Appointments updateAppointmentStatus(@PathVariable("appointmentId") Long Id, @RequestBody Appointments appointment) {
    	Optional<Appointments> updateApppintments=appointmentService.findAppointmentsById(Id);
    	if(updateApppintments.isPresent()) {
    		updateApppintments.get().setStatus(appointment.getStatus());
    		return appointmentService.updateStatus(updateApppintments.get());
    	}
    	return null;
        
    }
	
	
}
