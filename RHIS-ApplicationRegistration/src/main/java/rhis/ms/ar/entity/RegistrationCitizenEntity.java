package rhis.ms.ar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CITIZEN_REGISTRATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationCitizenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Application_Id")
	private Long appId;
	@Column(name = "Full_Name")
	private String fullName;
	@Column(name = "Email")
	private String email;
	@Column(name = " Phone_Number")
	private String phoneNumber;
	@Column(name = "Gender")
	private String gender;
	@Column(name = "Date_Of_Birth")
	private Date dob;
	@Column(name = "Social_Security_Number")
	private Long ssn;

	@CreationTimestamp
	private Date createdOn;
	@UpdateTimestamp
	private Date updateOn;

	private String createdBy;
	private String updateBy;

}
