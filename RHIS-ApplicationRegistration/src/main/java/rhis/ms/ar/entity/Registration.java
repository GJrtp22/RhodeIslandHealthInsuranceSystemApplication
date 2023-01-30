package rhis.ms.ar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CITIZEN_REGISTRATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
	
	@Id
	@Column(name="Registration_Id")
	private Long regId;
	@Column(name="Full_Name")
	private String fullName;
	@Column(name="Email")
	private String email;
	@Column(name= " Phone_Number")
	private String phoneNumber;
	@Column(name= "Gender")
	private String gender;
	@Column(name="Date_Of_Birth")
	private Date dob;
	@Column(name="Social_Security_Number")
	private Long ssn;

}
