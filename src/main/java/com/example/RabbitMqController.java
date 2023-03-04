/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:3/4/2023
 * Time:10:14 AM
 * Project Name:rabbitMq-example
 */
package com.example;

import com.example.Employee;
import com.example.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitMq")
public class RabbitMqController {

    @Autowired
    RabbitMqService rabbitMqService;

    @GetMapping(value = "/producer")
    public String producer(
            @RequestParam("empName") String empName,
            @RequestParam("empId") String empId) {

        Employee emp=new Employee();
        emp.setEmployeeId(empId);
        emp.setEmployeeName(empName);
        rabbitMqService.send(emp);

        return "Message successfully send RabbitMq";
    }
}
