package com.dgc.DiscGolfLeagues.controller;

import com.dgc.DiscGolfLeagues.model.Division;
import com.dgc.DiscGolfLeagues.model.EventType;
import com.dgc.DiscGolfLeagues.repository.DivisionRepository;
import com.dgc.DiscGolfLeagues.repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/lookup")
public class LookupController {
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private EventTypeRepository eventTypeRepository;

    @GetMapping("/divisions")
    public ResponseEntity<List<Division>> getAllDivisions() {
        try {
            List<Division> divisions = new ArrayList<>(divisionRepository.findAll());

            if (divisions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(divisions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/event_types")
    public ResponseEntity<List<EventType>> getAllEventTypes() {
        try {
            List<EventType> eventTypes = new ArrayList<>(eventTypeRepository.findAll());

            if (eventTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(eventTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
