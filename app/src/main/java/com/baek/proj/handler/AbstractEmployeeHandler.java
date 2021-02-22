package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Employee;

public abstract class AbstractEmployeeHandler implements Command {

  protected List<Employee> employeeList;

  public AbstractEmployeeHandler(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  protected String phoneFormat(String phone) {
    if(phone.length() == 11) {  
      return phone.replaceFirst("(^010)([0-9]{4})([0-9]{4})$", "$1-$2-$3");
    }
    return phone; 
  }

  protected Employee findByNo(int employeeNo) {
    Employee[] list = employeeList.toArray(new Employee[employeeList.size()]);
    for (Employee e : list) {
      if (e.getNo() == employeeNo) {
        return e;
      }
    }
    return null;
  }

  protected Employee findByName(String name) {
    Employee[] list = employeeList.toArray(new Employee[employeeList.size()]);
    for (Employee e : list) {
      if (e.getName().equals(name)) {
        return e;
      }
    }
    return null;
  }
}
