package rhis.ms.ar.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import rhis.ms.ar.utils.ApiError;

@Component
@ControllerAdvice
public class RHISGlobalExceptionHandler {
	
	@ExceptionHandler(value=RhisSsnNotFoundException.class)
	public ResponseEntity<ApiError> handleNotSsnFound()
	{
		ApiError error=new ApiError(404, "SSN not Found", new Date());
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
		
	}

}
