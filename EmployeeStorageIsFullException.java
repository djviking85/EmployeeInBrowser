package pro.sky.employe25.employeers.exceprion;

public class EmployeeStorageIsFullException extends RuntimeException {

    public EmployeeStorageIsFullException(String message) {
        super(message);

    }
}