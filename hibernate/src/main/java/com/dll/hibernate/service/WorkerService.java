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

    public WorkerService(WorkerRepository workerRepository, CompanyRepository companyRepository) {
        this.workerRepository = workerRepository;
        this.companyRepository = companyRepository;
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

    public Worker update(Worker worker, Long id) {
        Worker workerToUpdate = null;

        try {
            workerToUpdate = workerRepository.findById(id).orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setWorker(worker, workerToUpdate);

        Worker updatedWorker = workerRepository.save(workerToUpdate);

        return updatedWorker;
    }

    private void setWorker(Worker worker, Worker workerToUpdate) {
        workerToUpdate.setName(worker.getName());
        workerToUpdate.setSurname(worker.getSurname());
        workerToUpdate.setWorkerType(worker.getWorkerType());
        workerToUpdate.setCompany(worker.getCompany());
    }

    public String delete(Long id) {
        Worker worker = null;
        try {
            worker = workerRepository.findById(id).orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
            return "Deleted error";
        }
        workerRepository.deleteById(id);

        return "Worker with id " + id + " has been deleted";
    }
}
