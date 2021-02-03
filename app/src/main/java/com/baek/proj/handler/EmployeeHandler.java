package com.baek.proj.handler;

import com.baek.proj.domain.Employee;
import com.baek.util.Prompt;

public class EmployeeHandler {

  private EmployeeList employeeList = new EmployeeList();

  public EmployeeList getEmployeeList() {
    return this.employeeList;
  }

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

    e.setNo(Prompt.inputInt("번호> "));
    e.setName(Prompt.inputString("이름> "));
    e.setDept(Prompt.inputString("부서> "));
    e.setEmail(Prompt.inputString("메일> "));
    e.setPhone(Prompt.inputString("전화번호> "));
    e.setJoinDate(Prompt.inputDate("입사일> "));

    employeeList.add(e);
    System.out.println("사원을 등록하였습니다.");
  }

  public void list() {
    System.out.println("[사원 목록]");

    Employee[] employees = employeeList.toArray();
    for (Employee e : employees) {
      System.out.printf("%d> %s (%s부) %s, %s, %s 입사\n", 
          e.getNo(), e.getName(), e.getDept(), e.getEmail(), 
          phoneFormat(e.getPhone()), e.getJoinDate());
    }
  }

  public void detail() {
    System.out.println("[사원 상세]");

    int no = Prompt.inputInt("번호> ");
    Employee employee = employeeList.get(no);
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

  public void update() {
    System.out.println("[사원 수정]");

    int no = Prompt.inputInt("번호> ");
    Employee employee = employeeList.get(no);
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

  public void delete() {
    System.out.println("[사원 삭제]");

    int no = Prompt.inputInt("번호> ");
    Employee employee = employeeList.get(no);
    if (employee == null) {
      System.out.println("해당 번호의 사원이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      employeeList.delete(no);
      System.out.println("사원 정보를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }

  public String phoneFormat(String phone) {
    if(phone.length() == 11) {  
      return phone.replaceFirst("(^010)([0-9]{4})([0-9]{4})$", "$1-$2-$3");
    }
    return phone; 
  }

  String inputEmployee(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } else if (this.employeeList.exist(name)) {
        return name;
      } else {
        System.out.println("등록된 사원이 아닙니다.");
      }
    }
  }
}
