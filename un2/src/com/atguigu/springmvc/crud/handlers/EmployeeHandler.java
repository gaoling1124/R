package com.atguigu.springmvc.crud.handlers;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by gl on 2017/4/3.
 */
@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;//显示所有的员工信息


    @Autowired
    private DepartmentDao departmentDao;//显示部门消息

//    @RequestMapping(value="/emp/{id}",method =RequestMethod.GET)
//    public String input(@PathVariable("id") Integer id,Map<String,Object>map){
//        map.put("employee",employeeDao.get(id));
//        map.put("departments",departmentDao.getDepartments());
//        return "input";
//    }

    @RequestMapping(value="/emp/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value="/emp",method = RequestMethod.POST)
    public String save(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value="/emp/{id}",method = RequestMethod.GET)
    public  String input(Map<String,Object>map){
        map.put("department",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String,Object>map){

        map.put("employees",employeeDao.getAll());
        return "list";
    }

}
