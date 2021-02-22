package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Employee;
import com.baek.util.Prompt;

public class EmployeeUpdateHandler extends AbstractEmployeeHandler {

  public EmployeeUpdateHandler(List<Employee> employeeList) {
    super(employeeList);
  }

  @Override
  public void service() {
    System.out.println("[사원 수정]");

    int no = Prompt.inputInt("번호> ");
    Employee employee = findByNo(no);
    if (employee == null) {
      System.out.println("해당 번호의 사원이 없습니다.");
      return;
    }
    String name = Prompt.inputString(String.format("이름(%s)> ", employee.getName()));
    String dept = Prompt.inputString(String.format("부서(%s)> ", employee.getDept()));
    String email = Prompt.inputString(String.format("메일(%s)> ", employee.getEmail()));
    String phone = Prompt.inputString(String.format("전화번호(%s)> ", employee.getPhone()));

    String input = Prompt.inputString("변경하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      employee.setName(name);
      employee.setDept(dept);
      employee.setEmail(email);
      employee.setPhone(phone);
      System.out.println("사원 정보를 변경하였습니다.");
    } else {
      System.out.println("수정을 취소하였습니다.");
    }
  }
}
