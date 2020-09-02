package aforo255.ms.test.pay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import aforo255.ms.test.pay.entity.Operation;
import aforo255.ms.test.pay.producer.PayEventProducer;
import aforo255.ms.test.pay.service.OperationService;

@RestController
public class PayEventController {

	private Logger log=LoggerFactory.getLogger(PayEventController.class);
	
	@Autowired
	PayEventProducer payProducer;
	@Autowired
	private OperationService operationService;

	@PostMapping("/v1/payevent")
	public ResponseEntity<Operation> postDeposit(@RequestBody Operation operationEvent) throws JsonProcessingException{
		log.info("antes de guardar operacion sql");
		Operation operation = operationService.save(operationEvent);
		log.info("despues de guardar operacion sql");
		log.info("antes  de sendPayEvent");
		payProducer.sendPayEvent(operation);
		log.info("despues  de sendPayEvent");
		return  ResponseEntity.status(HttpStatus.CREATED).body(operation);			
	}
	
	
}
