package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {
    	//Return Json with Doc info
    	if(number == 13) {
    		return new Doctor(number, "Jodie Whittaker");
    	//Return statut 303 : See other
    	} else if (number >=1 && number <=12) {
        	throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        //Return statut 404 : not found
    	} else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);
    	}

    }
}
