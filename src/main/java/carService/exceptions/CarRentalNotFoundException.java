package carService.exceptions;

public class CarRentalNotFoundException extends RuntimeException{

        public CarRentalNotFoundException(String message) {
            super(message);
        }

}
