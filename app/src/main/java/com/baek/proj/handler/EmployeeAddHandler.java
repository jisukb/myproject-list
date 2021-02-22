package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Employee;
import com.baek.util.Prompt;

public class EmployeeAddHandler extends AbstractEmployeeHandler {

  public EmployeeAddHandler(List<Employee> employeeList) {
    super(employeeList);
  }

  @Override
  public void service() {
    System.out.println("[사원 등록]");

    Employee e = new Employee();

    e.setNo(Prompt.inputInt("번호> "));
    e.setName(Prompt.inputString("이름> "));
    e.setDept(Prompt.inputString("부서> "));
    e.setEmail(Prompt.inputString("메일> "));
    e.setPhone(Prompt.inputString("전화번호> "));
    e.setJoinDate(Prompt.inputDate("입사일> "));

    employeeList.add(e);
    System.out.println("사원을 등록하였습니다.");
  }
}
