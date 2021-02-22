package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Employee;
import com.baek.util.Prompt;

public class EmployeeDetailHandler extends AbstractEmployeeHandler {

  public EmployeeDetailHandler(List<Employee> employeeList) {
    super(employeeList);
  }

  @Override
  public void service() {
    System.out.println("[사원 상세]");

    int no = Prompt.inputInt("번호> ");
    Employee employee = findByNo(no);
    if (employee == null) {
      System.out.println("해당 번호의 사원이 없습니다.");
      return;
    }
    System.out.printf("이름: %s\n", employee.getName());
    System.out.printf("부서: %s\n", employee.getDept());
    System.out.printf("메일: %s\n", employee.getEmail());
    System.out.printf("전화번호: %s\n", 
        employee.getPhone().replaceFirst("(\\d{3})(\\d{4})(\\d+)", "$1-$2-$3"));
    System.out.printf("입사일: %s\n", employee.getJoinDate());
  }
}
