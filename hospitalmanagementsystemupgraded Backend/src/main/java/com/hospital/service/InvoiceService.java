package com.hospital.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.dao.InvoiceRepository;
import com.hospital.model.Invoice;
@Service
public class InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;
	@Transactional
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	@Transactional 
	  public Invoice getInvoice(int id) { 
	  Optional<Invoice> optional= invoiceRepository.findById(id);
	  Invoice invoice=optional.get();
	  return invoice;
	}
	@Transactional
	public void updateInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	@Transactional
	public void deleteInvoice(int invoiceId) {
		System.out.println("service method called");
		invoiceRepository.deleteById(invoiceId);
	}
	@Transactional
	public List<Invoice> fetchInvoices() {
		List<Invoice> invoiceList=invoiceRepository.findAll();
		return invoiceList;

	}
}
