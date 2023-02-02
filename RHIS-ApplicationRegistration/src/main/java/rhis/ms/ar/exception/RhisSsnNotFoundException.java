package rhis.ms.ar.exception;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RhisSsnNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1388243932685279841L;

	public RhisSsnNotFoundException(String msg)
	{
		super(msg);
	}
	
}
