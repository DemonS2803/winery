package ru.spmi.winery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.Employee;
import ru.spmi.winery.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean loginEmployee(String login, String password) {
        return employeeRepository.isEmployeeExists(login, password);
    }

    public Employee getEmployee(String login) {
        return employeeRepository.findByEmail(login);
    }
}
