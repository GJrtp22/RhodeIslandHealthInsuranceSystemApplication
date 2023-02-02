package rhis.ms.ar.bindings;

import java.util.Date;

import lombok.Data;

@Data
public class Citizen {
	
	private String fullName;
	private String email;
	private String phoneNumber;
	private String gender;
	private Date dob;
	private Long ssn;
	private String createdBy;

}
