package com.baek.proj.handler;

import com.baek.proj.domain.Employee;
import com.baek.util.Prompt;

public class EmployeeHandler {

  static final int LENGTH = 100;
  Employee[] employees = new Employee[LENGTH];
  int index = 0;

  public void service() {
    loop: 
      while (true) {

        System.out.println("-----사원-----");
        System.out.println("1. 등록");
        System.out.println("2. 목록");
        System.out.println("3. 상세");
        System.out.println("4. 수정");
        System.out.println("5. 삭제");
        System.out.println("0. 메인");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("사원> ");
        System.out.println();
        switch (command) {
          case "1":
            this.add();
            break;
          case "2":
            this.list();
            break;
          case "3":
            this.detail();
            break;
          case "4":
            this.update();
            break;
          case "5":
            this.delete();
            break;
          case "0":
            break loop;
          default:
            System.out.println("해당 번호가 없습니다.");
        }

        System.out.println();
      }
  }

  public void add() {
    System.out.println("[사원 등록]");

    Employee e = new Employee();
    e.no = Prompt.inputInt("번호> ");
    e.name = Prompt.inputString("이름> ");
    e.dept = Prompt.inputString("부서> ");
    e.email = Prompt.inputString("메일> ");
    e.phone = Prompt.inputString("전화번호> ");
    e.joinDate = Prompt.inputDate("입사일> ");
    this.employees[this.index++] = e;
  }

  public void list() {
    System.out.println("[사원 목록]");

    for (int i = 0; i < this.index; i++) {
      Employee e = this.employees[i];
      if (e == null)
        continue;
      System.out.printf("%d> %s (%s부) %s, %s, %s 입사\n", 
          e.no, e.name, e.dept, e.email, phoneFormat(e.phone), e.joinDate);
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

  public String phoneFormat(String phone) {
    if(phone.length() == 11) {  
      return phone.replaceFirst("(^010)([0-9]{4})([0-9]{4})$", "$1-$2-$3");
    }
    return phone; 
  }

  public void detail() {
    System.out.println("[사원 상세]");

    int no = Prompt.inputInt("번호> ");
    Employee employee = findByNo(no);
    if (employee == null) {
      System.out.println("해당 번호의 사원이 없습니다.");
      return;
    }
    System.out.printf("이름: %s\n", employee.name);
    System.out.printf("부서: %s\n", employee.dept);
    System.out.printf("메일: %s\n", employee.email);
    System.out.printf("전화번호: %s\n", 
        employee.phone.replaceFirst("(\\d{3})(\\d{4})(\\d+)", "$1-$2-$3"));
    System.out.printf("입사일: %s\n", employee.joinDate);
  }

  public void update() {
    System.out.println("[사원 수정]");

    int no = Prompt.inputInt("번호> ");
    Employee employee = findByNo(no);
    if (employee == null) {
      System.out.println("해당 번호의 사원이 없습니다.");
      return;
    }
    String name = Prompt.inputString(String.format("이름(%s)> ", employee.name));
    String dept = Prompt.inputString(String.format("부서(%s)> ", employee.dept));
    String email = Prompt.inputString(String.format("메일(%s)> ", employee.email));
    String phone = Prompt.inputString(String.format("전화번호(%s)> ", employee.phone));

    String input = Prompt.inputString("변경하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      employee.name = name;
      employee.dept = dept;
      employee.email = email;
      employee.phone = phone;
      System.out.println("사원 정보를 변경하였습니다.");
    } else {
      System.out.println("수정을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[사원 삭제]");

    int no = Prompt.inputInt("번호> ");
    int i = indexOf(no);
    if (i == -1) {
      System.out.println("해당 번호의 사원이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      for (int x = i+1; x < this.index; x++) {
        this.employees[x-1] = this.employees[x]; 
      }
      employees[--this.index] = null;
      System.out.println("사원 정보를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }

  int indexOf(int employeeNo) {
    for (int i = 0; i < this.index; i++) {
      Employee employee = this.employees[i];
      if (employee != null && employee.no == employeeNo) {
        return i;
      }
    }
    return -1;
  }

  Employee findByNo(int employeeNo) {
    int i = indexOf(employeeNo);
    if (i == -1)
      return null;
    else
      return employees[i];
  }
}
