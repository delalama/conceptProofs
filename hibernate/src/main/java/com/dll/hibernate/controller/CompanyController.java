package com.dll.hibernate.controller;

import com.dll.hibernate.model.Company;
import com.dll.hibernate.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(value = "/company")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {

        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {

        return new ResponseEntity<>(companyService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> postCompany(@RequestBody Company company) {

        return new ResponseEntity<>(companyService.postCompany(company), HttpStatus.OK);
    }
}
