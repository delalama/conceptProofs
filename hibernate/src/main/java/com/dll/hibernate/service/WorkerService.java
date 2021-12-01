package com.dll.hibernate.service;

import com.dll.hibernate.dao.WorkerRepository;
import com.dll.hibernate.model.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> getAll() {
        return workerRepository.findAll();
    }
}
