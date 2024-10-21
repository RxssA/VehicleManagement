package ie.atu.vechiclemanagement;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VechileRepo vechileRepo;
    private VehicleDetails vehicle;
    @Autowired
    public VehicleController(VechileRepo vechileRepo, VehicleDetails vehicle) {
        this.vechileRepo = vechileRepo;
        this.vehicle = vehicle;
    }

    @PostMapping("/add")
    public ResponseEntity<VechileRepo> add(@Valid @RequestBody VehicleDetails vehicle){
        return (ResponseEntity<VechileRepo>) vechileRepo.save(vehicle);
    }
    @PutMapping("/updateById")
    public VehicleDetails updateById(@Valid @PathVariable String registrationNumber,@Valid @PathVariable VehicleDetails updateVehicle){
        VehicleDetails vehicleDetails = updateById(registrationNumber, updateVehicle);
        vehicleDetails.setVehicleName(updateVehicle.getVehicleName());
        vehicleDetails.setVehicleType(updateVehicle.getVehicleType());
        vehicleDetails.setRegistrationNumber(updateVehicle.getRegistrationNumber());
        vehicleDetails.setPrice(updateVehicle.getPrice());
        vehicleDetails.setMileage(updateVehicle.getMileage());
        vehicleDetails.setYearOfManufacture(updateVehicle.getYearOfManufacture());
        return vehicleDetails;
    }
    @GetMapping("/getById")
    public ResponseEntity<VechileRepo> getById(@Valid @PathVariable String registrationNumber){
        Optional<VechileRepo> vehicleById = (Optional<VechileRepo>) vechileRepo.getById(registrationNumber);
        if(vehicleById.isPresent()){
            return ResponseEntity.ok(vehicleById.get());
        }
        return ResponseEntity.ok(vehicleById.get());
    }

}
