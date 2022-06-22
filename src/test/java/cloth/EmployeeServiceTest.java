package cloth;

import employees.EmployeeRepository;
import employees.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    void testSaveEmployee() {
        //var employeeRepository = Mockito.mock(EmployeeRepository.class);
        //System.out.println(employeeRepository.saveEmployee("John Doe"));
        //var employeeService = new EmployeeService(employeeRepository);

        Mockito.when(employeeRepository.saveEmployee(any())).thenReturn(60L);

        // When
        var id = employeeService.saveEmployee("   John Doe   ");
        //Then
        Mockito.verify(employeeRepository).saveEmployee(eq("JOHN DOE"));

        Assertions.assertEquals(60L, id);
    }
}
