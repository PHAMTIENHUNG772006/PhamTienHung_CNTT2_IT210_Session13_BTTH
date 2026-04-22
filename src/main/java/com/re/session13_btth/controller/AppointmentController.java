package com.re.session13_btth.controller;

import com.re.session13_btth.model.Appointment;
import com.re.session13_btth.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getWaitingList());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "form";
    }


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("appointment") Appointment a,
                       BindingResult result) {

        if (result.hasErrors()) {
            return "form";
        }

        service.save(a);
        return "redirect:/appointments";
    }

    @GetMapping("/call/{id}")
    public String call(@PathVariable Long id) {
        service.callPatient(id);
        return "redirect:/appointments";
    }
}
