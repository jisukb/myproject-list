package com.baek.proj.handler;

import com.baek.proj.domain.Employee;
import com.baek.util.Prompt;

public class EmployeeHandler {

  static final int LENGTH = 100;
  Employee[] employees = new Employee[LENGTH];
  int index = 0;

  public void add() {
    System.out.println("[사원 등록]");

    Employee e = new Employee();
    e.name = Prompt.inputString("이름> ");
    e.position = Prompt.inputString("부서> ");
    e.email = Prompt.inputString("메일> ");
    e.phone = Prompt.inputString("전화번호> ");
    e.joinDate = Prompt.inputDate("입사일> ");
    this.employees[this.index++] = e;
  }

  public void list() {
    System.out.println("[사원 목록]");
    for (int i = 0; i < this.index; i++) {
      Employee e = this.employees[i];
      System.out.printf("%d> %s (%s부) %s, %s, %s 입사\n", 
          i+1, e.name, e.position, e.email, e.phone, e.joinDate);
    }
  }

  public boolean exist(String name) {
    for (int i = 0; i < this.index; i++) {
      if (name.equals(this.employees[i].name)) {
        return true;
      }
    }
    return false;
  }
}
