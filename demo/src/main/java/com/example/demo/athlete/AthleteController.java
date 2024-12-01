package com.example.demo.athlete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // makes this class to serve rest endpoints
@RequestMapping(path = "api/athletes")
public class AthleteController {

    private final AthleteService athleteService;

    @Autowired
    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public List<Athlete> getAthletes() {
        return this.athleteService.getAthletes();
    }

    @PostMapping
    public void addNewAthlete(@RequestBody Athlete athlete) {
        this.athleteService.addAthlete(athlete);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAthlete(@PathVariable("id") Long athleteId) {
        athleteService.deleteAthlete(athleteId);
    }

    @PutMapping(path = "{id}")
    public void updateAthlete(@PathVariable("id") Long athleteId, @RequestBody Athlete athlete) {
        athleteService.updateAthlete(athleteId, athlete);
    }

}
