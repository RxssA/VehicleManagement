package ie.atu.vechiclemanagement;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDetails {
    @NotEmpty(message = "Cannot be empty")
    private String vehicleName;

    private String vehicleType;
    private String registrationNumber;
    private Float price;
    private int yearOfManufacture;
    private int mileage;
}
