package com.example.demo.athlete;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    @Autowired
    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public List<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    public void addAthlete(Athlete athlete) {
        Optional<Athlete> athleteOptional = athleteRepository.findById(athlete.getId());

        if (athleteOptional.isPresent()) {
            throw new IllegalStateException("Athlete with id " + athlete.getId() + " already exists");
        }

        athleteRepository.save(athlete);
    }

    public void deleteAthlete(Long athleteId) {
        boolean exists = athleteRepository.existsById(athleteId);
        if (!exists) {
            throw new IllegalStateException("Athlete with id " + athleteId + " does not exist");
        }
        athleteRepository.deleteById(athleteId);
    }

    @Transactional
    public void updateAthlete(Long athleteId, Athlete athlete) {
        Optional<Athlete> athleteToUpdate = athleteRepository.findById(athleteId);

        if (athleteToUpdate.isEmpty()) {
            throw new IllegalStateException("Athlete with id " + athleteId + " does not exist");
        }
        athleteToUpdate.get().setName(athlete.getName());
        athleteToUpdate.get().setGender(athlete.getGender());
        athleteToUpdate.get().setAge(athlete.getAge());
        athleteToUpdate.get().setBirthday(athlete.getBirthday());
        athleteToUpdate.get().setHeight(athlete.getHeight());
        athleteToUpdate.get().setWeight(athlete.getWeight());
        athleteRepository.save(athleteToUpdate.get());
    }
}
