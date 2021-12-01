package com.dll.hibernate.controller;

import com.dll.hibernate.model.Worker;
import com.dll.hibernate.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(value = "/worker")
public class WorkerController {

    WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getWorker() {

        List<Worker> all = workerService.getAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
