package com.dll.hibernate.service;

import com.dll.hibernate.dao.CompanyRepository;
import com.dll.hibernate.dao.WorkerRepository;
import com.dll.hibernate.model.Company;
import com.dll.hibernate.model.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    WorkerRepository workerRepository;
    CompanyRepository companyRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> getAll() {
        return workerRepository.findAll();
    }

    public Worker postWorker(Worker worker) {
        try {
            Company company = companyRepository.findById(worker.getCompany().getId()).orElseThrow(Exception::new);
            worker.setCompany(company);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workerRepository.save(worker);
    }
}
