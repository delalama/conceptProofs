package com.dll.hibernate.service;

import com.dll.hibernate.dao.CompanyRepository;
import com.dll.hibernate.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company postCompany(Company company) {
        Company company1 = companyRepository.save(company);
        return company1;
    }
}
