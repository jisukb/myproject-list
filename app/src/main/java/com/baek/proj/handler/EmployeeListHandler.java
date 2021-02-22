package com.baek.proj.handler;

import java.util.Iterator;
import java.util.List;
import com.baek.proj.domain.Employee;

public class EmployeeListHandler extends AbstractEmployeeHandler {

  public EmployeeListHandler(List<Employee> employeeList) {
    super(employeeList);
  }

  @Override
  public void service() {
    System.out.println("[사원 목록]");

    Iterator<Employee> iterator = employeeList.iterator();
    while (iterator.hasNext()) {
      Employee e = iterator.next();
      // 번호, 이름, 부서, 이메일, 전화번호, 입사일
      System.out.printf("%d> %s (%s부) %s, %s, %s 입사\n", 
          e.getNo(), e.getName(), e.getDept(), e.getEmail(), 
          phoneFormat(e.getPhone()), e.getJoinDate());
    }
  }
}
