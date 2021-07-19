package com.pms.processPension.restClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pms.processPension.model.ProcessPensionInput;

/**
 * To access Pension disbursement microservice
 * 
 */
@FeignClient(name = "pension-disbursement-service", url = "http://localhost:9091") //9091
public interface PensionDisbursementClient {

	@PostMapping("/DisbursePension")
	public int processPension(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput);

	@PostMapping("/getServiceCharge")
	public double getBankServiceCharge(@RequestHeader("Authorization") String token, @RequestBody String bankName);

}
