package ie.atu.vechiclemanagement;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VechileRepo vechileRepo;
    private final VehicleDetails vehicle;

    public VehicleController(VechileRepo vechileRepo, VehicleDetails vehicle) {
        this.vechileRepo = vechileRepo;
        this.vehicle = vehicle;
    }

    @PostMapping("/add")
    public ResponseEntity<VehicleDetails> add(@RequestBody){
        return vechileRepo.save(vehicle);
    }

    public VehicleDetails updateById(String registrationNumber){
        vehicle updateById = vechileRepo.findById(registrationNumber);
        updateById.
    }

    public ResponseEntity<vehicle> getById(String registrationNumber){
        Optional<vehicle> vehicleById = vechileRepo.getById(registrationNumber);
        if(vehicleById.isPresent()){
            return ResponseEntity.ok(vehicleById.get());
        }
    }

}
