package com.ptps.microservices.paymentSettlementService.resource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxPaymentOrderRepository extends JpaRepository<TaxPaymentOrder, Long> {
	//TaxPaymentOrder findByFromAndTo(String from, String to);
	List<TaxPaymentOrder> findByDecision(boolean decision);
}
