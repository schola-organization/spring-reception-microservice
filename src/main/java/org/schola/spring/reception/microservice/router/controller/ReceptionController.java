package org.schola.spring.reception.microservice.router.controller;

import org.schola.spring.reception.microservice.data.model.Reception;
import org.schola.spring.reception.microservice.data.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/receptions")
public class ReceptionController {

    @Autowired
    private ReceptionService service;

    @PostMapping("/newReception")
    public void newReception(Reception reception) {
        service.save(reception);
    }

    @GetMapping("/getReceptions")
    public List<Reception> getReceptions() {
        Pageable pageable = Pageable.ofSize(25);
        return service.getAll(pageable);
    }
}
