package pro.sky.employe25.employeers.Employer.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {

    public EmployeeStorageIsFullException(String message) {
        super(message);

    }
}