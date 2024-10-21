package ie.atu.vechiclemanagement;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VechileRepo vechileRepo;
    @Autowired
    public VehicleController(VechileRepo vechileRepo) {
        this.vechileRepo = vechileRepo;

    }
    @PostMapping("/add")
    public ResponseEntity<VechileRepo> add(@Valid @RequestBody VehicleDetails vehicleDetails){
        return vechileRepo.save(vehicleDetails);
    }
    @PutMapping("/updateById/{registrationNumber}")
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
    @GetMapping("/getById/{registrationNumber}")
    public String getByRegNumber(@Valid @PathVariable String registrationNumber){
        String vehicleById = vechileRepo.getById(registrationNumber);
        return vehicleById;
    }

}
