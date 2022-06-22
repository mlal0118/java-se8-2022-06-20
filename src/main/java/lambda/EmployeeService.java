package lambda;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
public class EmployeeService {
    private List<Employee> employees;

    public Employee findEmployeeByName(String name) {
        for (var employee: employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        throw new IllegalArgumentException("Not found with name: " + name);
    }

    public Employee findEmployeeByName2(Predicate<Employee> criteria) {
        for (var employee : employees) {
            if (criteria.test(employee)) {
                return employee;
            }
        }
        throw new IllegalArgumentException("Not found with name: " + criteria);
    }

}
