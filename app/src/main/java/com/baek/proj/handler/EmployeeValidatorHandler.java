package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Employee;
import com.baek.util.Prompt;

public class EmployeeValidatorHandler extends AbstractEmployeeHandler {

  public EmployeeValidatorHandler(List<Employee> employeeList) {
    super(employeeList);
  }

  @Override
  public void service() {

  }

  public String inputEmployee(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } else if (findByName(name) != null) {
        return name;
      } else {
        System.out.println("등록된 사원이 아닙니다.");
      }
    }
  }
}
