import model.Department;
import model.Employee;
import repository.FileRepoFactory;
import repository.FileRepository;

import java.time.LocalDate;
import java.util.*;

public class Main {
    void m1(int i){}
    void m1(int i,int o) {}
    public static void main(String[] args) {
        Employee employee = Employee.builder()
                .id(UUID.randomUUID())
                .department(Department.IOC)
                .name("MAX")
                .dateOfBirth(LocalDate.of(1995, 4,14)).build();
        Employee employee1 = Employee.builder()
                .id(UUID.randomUUID())
                .department(Department.IOC)
                .name("AXXXX")
                .dateOfBirth(LocalDate.of(2000, 4,14)).build();
        Comparator<Employee> comparator = Comparator.comparing(Employee::getDateOfBirth);
        Set<Employee> set = new TreeSet<>(comparator);
        Set<Employee> set1 = new HashSet<>();
        FileRepository<Employee, UUID> fileRepository =FileRepoFactory.of(Employee.class);
        fileRepository.saveToFile(employee);
        fileRepository.saveToFile(employee1);

        set.add(employee);
        set.add(employee1);
        set1.add(employee);
        set1.add(employee1);
        System.out.println(set);
        System.out.println(System.lineSeparator());
        System.out.println(set1);
    }
}
