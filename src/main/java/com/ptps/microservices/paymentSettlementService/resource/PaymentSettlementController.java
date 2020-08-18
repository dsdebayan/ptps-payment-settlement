package com.ptps.microservices.paymentSettlementService.resource;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptps.microservices.taxamountDataloadService.util.environment.ResponseMessage;

import io.swagger.annotations.ApiOperation;

@RestController
public class PaymentSettlementController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentSettlementController.class);

	@Autowired
	private TaxPaymentOrderRepository repository;

	@GetMapping("/")
	@ApiOperation(value = "Health Check")
	public String imHealthy() {
		return "{healthy:true}";
	}

	/*
	 * @GetMapping("/payment-settlement/{id}")
	 * 
	 * @ApiOperation(value = "Retrieve Settlement info for a payment order") public
	 * TaxPaymentOrder retrievePaymentOrder(@PathVariable long id) {
	 * 
	 * Optional<TaxPaymentOrder> taxPaymentOrder = repository.findById(id);
	 * 
	 * LOGGER.info("{} {} {}", taxPaymentOrder.get()); return taxPaymentOrder.get();
	 * }
	 */

	@GetMapping("/payment-settlement/{id}")
	@ApiOperation(value = "Retrieve Settlement info for a payment order")
	public TaxPaymentOrder retrievePaymentOrderById(@PathVariable long id) {

		Predicate<TaxPaymentOrder> pred = tpo -> (tpo.getId() == id); //1. Predicate functional interface, 2. lambda expression
		
		List<TaxPaymentOrder> tpos = repository    
				.findAll()
				.stream()
				.filter(pred)  //3. stream api
				.collect(Collectors.toList()); //4. Collectors class	
		
		
		Optional<TaxPaymentOrder> tpo =	tpos
				.stream()
				.findFirst(); //5. optional class

		return tpo.orElseThrow(RuntimeException :: new); //6. Method reference
	}

	@GetMapping("/payment-settlement/dues")
	@ApiOperation(value = "Retrieve Settlement info for all due payment orders")
	public List<TaxPaymentOrder> fetchDuePayment() {

		List<TaxPaymentOrder> duePaymentOrders = repository.findByDecision(false);

		LOGGER.info("{}", duePaymentOrders);
		return duePaymentOrders;
	}

	@PutMapping("/payment-settlement/{id}")
	@ApiOperation(value = "Update Settlement info for a due payment order")
	public ResponseEntity<TaxPaymentOrder> updateTaxPaymentOrder(@PathVariable long id, @RequestBody TaxPaymentOrder order){

		String message;			
		TaxPaymentOrder taxPaymentOrder = repository.findById(id).get();

		taxPaymentOrder.setDecision(order.isDecision());
		if (order.isDecision()) {
			taxPaymentOrder.setSubmittedDate(new Date());
			if((taxPaymentOrder.getDueDate().getTime() - new Date().getTime()) < 0) {
				taxPaymentOrder.setTotalAmountPaid(taxPaymentOrder.getAmountToBePaid() + 50);
			}
		}

		repository.save(taxPaymentOrder);

		message = "Payment Settlement done successfully. Tax Payment Order : " + taxPaymentOrder.getId();
		return ResponseEntity.status(HttpStatus.OK).body(taxPaymentOrder);

	}


}
