package rhis.ms.dc.fiegnclientcommunication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "AR-API")
@Component
public interface ARClient {
	
	@GetMapping("/citizen/{appId}")
	public Long invokeSearchAppId(Long appId);
	

}
