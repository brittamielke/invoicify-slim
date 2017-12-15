package com.lmig.gfc.invoicify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;
import com.lmig.gfc.invoicify.services.UserRepository;

@Configuration
public class SeedData {

	public SeedData(UserRepository userRepository, PasswordEncoder encoder, CompanyRepository companyRepo,
			BillingRecordRepository billingRecordRepo) {
		String encodedPassword = encoder.encode("password");
		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setPassword(encodedPassword);
		adminUser.addRole("ADMIN");
		userRepository.save(adminUser);

		encodedPassword = encoder.encode("password");
		User clerkUser = new User();
		clerkUser.setUsername("clerk");
		clerkUser.setPassword(encodedPassword);
		clerkUser.addRole("CLERK");
		userRepository.save(clerkUser);

		encodedPassword = encoder.encode("password");
		User accountantUser = new User();
		accountantUser.setUsername("accountant");
		accountantUser.setPassword(encodedPassword);
		accountantUser.addRole("ACCOUNTANT");
		userRepository.save(accountantUser);

		Company companyOne = companyRepo.save(new Company("ABC Company"));
		Company companyTwo = companyRepo.save(new Company("XYZ Company"));
		// FlatFeeBillingRecord recordOne = billingRecordRepo
		// .save(new FlatFeeBillingRecord(adminUser, "Supplies", companyOne, 54.14));
		// FlatFeeBillingRecord recordTwo = billingRecordRepo
		// .save(new FlatFeeBillingRecord(accountantUser, "Charity Donation",
		// companyOne, 125.00));
		// FlatFeeBillingRecord recordThree = billingRecordRepo
		// .save(new FlatFeeBillingRecord(adminUser, "Airfare", companyTwo, 538.86));
		// RateBasedBillingRecord recordFour = billingRecordRepo
		// .save(new RateBasedBillingRecord(accountantUser, "Miles Driven", companyOne,
		// 2.65, 247L));
		// RateBasedBillingRecord recordFive = billingRecordRepo
		// .save(new RateBasedBillingRecord(adminUser, "Hotel", companyOne, 265.12,
		// 4L));
		// RateBasedBillingRecord recordSix = billingRecordRepo
		// .save(new RateBasedBillingRecord(accountantUser, "Hotel", companyTwo, 195.65,
		// 2L));

	}

}
