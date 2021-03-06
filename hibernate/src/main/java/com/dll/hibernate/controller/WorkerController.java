package com.dll.hibernate.controller;

import com.dll.hibernate.model.Worker;
import com.dll.hibernate.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Worker> postWorker(@RequestBody Worker worker) {

        Worker postedWorker = workerService.postWorker(worker);

        return new ResponseEntity<>(postedWorker, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateWorker(@RequestBody Worker worker, @PathVariable Long id) {

        Worker updatedWorker = workerService.update(worker, id);

        return new ResponseEntity<>(updatedWorker, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteWorker(@PathVariable Long id) {

        String message = workerService.delete(id);

        return new ResponseEntity<>(message, HttpStatus.OK);

    }
}
