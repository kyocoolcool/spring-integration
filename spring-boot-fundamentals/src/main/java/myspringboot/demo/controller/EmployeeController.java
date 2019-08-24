package myspringboot.demo.controller;

import myspringboot.demo.dao.EmployeeDao;
import myspringboot.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author chris
 * @Date 2019-02-11 15:01
 * @Version 1.0
 **/

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
}