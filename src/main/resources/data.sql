insert into tax_payment_order(id,loan_number,customer_name,agency,amount_to_be_paid,total_amount_paid,due_date,submitted_date,decision)
values(10001,1245,'ABC Bank','Local County',1000.00,1000.00,parsedatetime('19-07-2020', 'dd-MM-yyyy'),parsedatetime('01-07-2020', 'dd-MM-yyyy'),1);
insert into tax_payment_order(id,loan_number,customer_name,agency,amount_to_be_paid,total_amount_paid,due_date,submitted_date,decision)
values(10002,1246,'XYZ Bank','Local County',1000.00,null,parsedatetime('19-07-2020', 'dd-MM-yyyy'),null,0);
