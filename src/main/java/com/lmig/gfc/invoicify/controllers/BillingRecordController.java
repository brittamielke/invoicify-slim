package com.lmig.gfc.invoicify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/billing-records")
public class BillingRecordController {

	private BillingRecordRepository billingRecordRepo;
	private CompanyRepository companyRepo;

	public BillingRecordController(BillingRecordRepository billingRecordRepo, CompanyRepository companyRepo) {
		this.billingRecordRepo = billingRecordRepo;
		this.companyRepo = companyRepo;
	}

	@GetMapping("")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("billing-records/list");

		// Get all the billing records and add them to the model and view with the key
		// "records"
		mv.addObject("records", billingRecordRepo.findAll());
		// Get all the companies and add them to the model and view with the key
		// "companies"
		mv.addObject("companies", companyRepo.findAll());
		return mv;
	}

}
