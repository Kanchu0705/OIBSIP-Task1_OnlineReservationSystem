package com.oibsip.kanchu;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Reservations")
public class UserReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnr_sequence")
	@SequenceGenerator(name = "pnr_sequence", sequenceName = "pnr_sequence", initialValue = 10000, allocationSize = 1)
	@Column(name = "pnr", length = 10)
	public Integer pnr;
	@Column(name = "User-ID", length = 50)
	public String userID;
	@Column(name = "Password", length = 15)
	public String userPassword;
	@Column(name = "User-Name", length = 50)
	public String name;
	@Temporal(TemporalType.DATE)
	public Date DOB;
	@Column(name = "Ph-Number", length = 10)
	public Long phoneNumber;
	@Column(name = "Email", length = 50)
	public String email;
	@Column(name = "Address", length = 50)
	public String address;
	@Column(name = "Train-Name", length = 30)
	public String trainName;
	@Column(name = "Train-NO", length = 10)
	public String trainNumber;
	@Column(name = "Class-Type", length = 30)
	public String classType;
	@Temporal(TemporalType.DATE)
	public Date dateOfJourney;
	@Column(name = "From-Destination", length = 30)
	public String fromDestination;
	@Column(name = "To-Destination", length = 30)
	public String toDestination;
	
	public void userReservation() {
		
	}

}
