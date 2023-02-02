package rhis.ms.ar.utils;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
	
	private Integer errorCode;
	private String errorDescription;
	private Date date;
	public ApiError(Integer errorCode, String errorDescription, Date date) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.date = date;
	}
	
	
	
	

}
