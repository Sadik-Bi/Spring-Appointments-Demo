package com.appointments.app.Model;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Appointments {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long AppointmentId;
	 	private LocalDate appointmentDate;
		private Time appointmentStartTime;
		private Time appointmentEndTime;
		private String status;
		private BigDecimal price;
		private String nameOfDoctor;
		public Appointments(LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime,
				String status, BigDecimal price, String nameOfDoctor) {
			super();
			this.appointmentDate = appointmentDate;
			this.appointmentStartTime = appointmentStartTime;
			this.appointmentEndTime = appointmentEndTime;
			this.status = status;
			this.price = price;
			this.nameOfDoctor = nameOfDoctor;
		}
		public Appointments() {
			
		}
		public Long getAppointmentId() {
			return AppointmentId;
		}
		public void setAppointmentId(Long appointmentId) {
			AppointmentId = appointmentId;
		}
		public LocalDate getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public Time getAppointmentStartTime() {
			return appointmentStartTime;
		}
		public void setAppointmentStartTime(Time appointmentStartTime) {
			this.appointmentStartTime = appointmentStartTime;
		}
		public Time getAppointmentEndTime() {
			return appointmentEndTime;
		}
		public void setAppointmentEndTime(Time appointmentEndTime) {
			this.appointmentEndTime = appointmentEndTime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public String getNameOfDoctor() {
			return nameOfDoctor;
		}
		public void setNameOfDoctor(String nameOfDoctor) {
			this.nameOfDoctor = nameOfDoctor;
		}
		
		
}
