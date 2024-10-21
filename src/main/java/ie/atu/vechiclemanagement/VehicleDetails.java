package ie.atu.vechiclemanagement;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDetails {
    @NotEmpty(message = "Cannot be empty")
    private String vehicleName;
    @NotEmpty
    @Pattern(regexp = "/w[Car,Truck,Motorcycle,Bus]$")
    private String vehicleType;
    @Pattern(regexp = "^[A-Za-z{0,2}][0-9]$}", message = "must be two letters and 4 numbers")
    private String registrationNumber;
    @PositiveOrZero(message = "cant be negative")
    private Float price;
    @Past(message = "between 1886 and now")
    @Pattern("(/d{1,2}V\d{1,2}\/\d{4}")
    private int yearOfManufacture;
    @Positive(message = "must be positive")
    private int mileage;
}
