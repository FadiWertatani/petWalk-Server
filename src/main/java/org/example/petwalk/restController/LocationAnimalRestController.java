package org.example.petwalk.restController;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.LocationAnimal;
import org.example.petwalk.repository.ILocationAnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/location")
public class LocationAnimalRestController {
    @Autowired
    private ILocationAnimalRepo locationAnimalRepo;
    // Save location data sent by the phone


    @PostMapping("/send")
    public ResponseEntity<?> saveLocation(@RequestBody LocationAnimal location) {
        location.setTimestamp(LocalDateTime.now());
        locationAnimalRepo.save(location);
        return ResponseEntity.ok("Location saved successfully");
    }

    // Retrieve latest location for a user
    @GetMapping("/{email}")
    public ResponseEntity<LocationAnimal> getLatestLocation(@PathVariable String email) {
        List<LocationAnimal> locations = locationAnimalRepo.findLocationAnimalsByEmailOrderByTimestampDesc(email);
        return locations.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(locations.get(0));
    }
}