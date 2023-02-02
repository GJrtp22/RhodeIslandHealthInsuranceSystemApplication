package rhis.ms.dc.fiegnclientcommunication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "AR-API")
public interface ARClient {
	
	@GetMapping("/citizen/{appId}")
	public Long invokeSearchAppId(Long appId);
	

}
