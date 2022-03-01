package com.hospital.controller;
import java.util.List;
//import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Invoice;
import com.hospital.service.InvoiceService;
import com.hospital.exception.ResourceNotFoundException;
@RequestMapping("/api/v1")
@RestController
public class InvoiceController {
	@Autowired
	InvoiceService invoiceService;

	//http://localhost:9080/api/v1/invoice
		@GetMapping("/invoice")
		public List<Invoice> getInvoices() {
			List<Invoice> invoiceList = invoiceService.fetchInvoices();

			return invoiceList;
		}
	@GetMapping("/invoice/{invoiceId}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable("invoiceId") int invoiceId)
			throws ResourceNotFoundException {
		Invoice invoice = invoiceService.getInvoice(invoiceId);
		return ResponseEntity.ok().body(invoice);
	}

	// http://localhost:8088/api/v1/invoice
	@PostMapping("/invoice")
	public Invoice addInvoice(@RequestBody Invoice invoice) {

		Invoice invoice1 = invoiceService.saveInvoice(invoice);

		// return new ResponseEntity<>("Employee added successsfully", HttpStatus.OK);
		return invoice1;
	}
	// http://localhost:9080/api/v1/updateinvice/2
		@PutMapping("/invoice/{id}")
		public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") int invoiceId,
				@RequestBody Invoice invoiceDetails) throws ResourceNotFoundException {
		        Invoice invoice = invoiceService.getInvoice(invoiceId);
			invoice.setPId(invoiceDetails.getPId());
			invoice.setMedicineCost(invoiceDetails.getMedicineCost());
			invoice.setRoomCharges(invoiceDetails.getRoomCharges());
			invoice.setDoctorCharges(invoiceDetails.getDoctorCharges());
			invoice.setTotalAmount(invoiceDetails.getTotalAmount());

			final Invoice updatedInvoice = invoiceService.saveInvoice(invoice);
			return ResponseEntity.ok(updatedInvoice);
		}

		//http://localhost:9080/api/v1/deleteinvoice/1
			@DeleteMapping(value = "/invoice/{invoiceId}")
			public ResponseEntity<Object> deleteInvoice(@PathVariable("invoiceId") int invoiceId) {

				invoiceService.deleteInvoice(invoiceId);
				return new ResponseEntity<>("invoice details deleted successsfully", HttpStatus.OK);
			}

}
