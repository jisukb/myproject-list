package com.baek.proj.handler;

import java.sql.Date;
import com.baek.util.Prompt;

public class EmployeeHandler {

  static class Employee {
    int no;
    String name;
    String position;
    String email;
    String phone;
    Date joinDate;
  }

  static final int LENGTH = 100;
  static Employee[] employees = new Employee[LENGTH];
  static int index = 0;

  public static void add() {
    System.out.println("[사원 등록]");

    Employee e = new Employee();
    e.name = Prompt.inputString("이름> ");
    e.position = Prompt.inputString("부서> ");
    e.email = Prompt.inputString("메일> ");
    e.phone = Prompt.inputString("전화번호> ");
    e.joinDate = Prompt.inputDate("입사일> ");
    employees[index++] = e;
  }

  public static void list() {
    System.out.println("[사원 목록]");
    for (int i = 0; i < index; i++) {
      Employee e = employees[i];
      System.out.printf("%d> %s (%s부)\n%s, %s\n입사일 %s\n", 
          i+1, e.name, e.position, e.email, e.phone, e.joinDate);
      System.out.println("----------------------------------");
    }
  }
}
