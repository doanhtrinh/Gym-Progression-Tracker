package com.example.demo.gym;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/gymprogress")
@CrossOrigin(origins = "http://localhost:3000")
public class GymProgressController {

    private final GymProgressService gymProgressService;

    @Autowired
    public GymProgressController(GymProgressService gymProgressService) {
        this.gymProgressService = gymProgressService;
    }

    @GetMapping()
    public List<GymProgress> getGymProgressRecords() {    
        return gymProgressService.getGymProgressRecords();
    }

    @PostMapping
    public List<GymProgress> registerNewGymProgress(@RequestBody GymProgress gymProgress) {
        gymProgressService.addNewGymProgress(gymProgress);
        return gymProgressService.getGymProgressRecords();  // Return the updated list after adding the record
    }

    @DeleteMapping(path = "{progressId}")
    public void deleteGymProgress(@PathVariable("progressId") Long progressId) {
        gymProgressService.deleteGymProgress(progressId);
    }

    @PutMapping(path = "{progressId}")
    public void updateGymProgress(@PathVariable("progressId") Long progressId, 
                                  @RequestBody GymProgress gymProgress) {
        gymProgressService.updateGymProgress(progressId, gymProgress.getExerciseName(), gymProgress.getWeight(), gymProgress.getReps(), gymProgress.getDate());
    }
}
