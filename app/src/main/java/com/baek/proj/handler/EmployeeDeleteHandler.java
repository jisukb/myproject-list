package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Employee;
import com.baek.util.Prompt;

public class EmployeeDeleteHandler extends AbstractEmployeeHandler {

  public EmployeeDeleteHandler(List<Employee> employeeList) {
    super(employeeList);
  }

  @Override
  public void service() {
    System.out.println("[사원 삭제]");

    int no = Prompt.inputInt("번호> ");
    Employee employee = findByNo(no);
    if (employee == null) {
      System.out.println("해당 번호의 사원이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      employeeList.remove(employee);
      System.out.println("사원 정보를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }
}
