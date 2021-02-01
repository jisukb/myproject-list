package com.baek.proj.handler;

import com.baek.proj.domain.Store;
import com.baek.util.Prompt;

public class StoreHandler {

  StoreList storeList = new StoreList();

  EmployeeList employeeList;

  public StoreHandler(EmployeeList employeeList) {
    this.employeeList = employeeList;
  }

  public void service() {
    loop: 
      while (true) {

        System.out.println("-----지점-----");
        System.out.println("1. 등록");
        System.out.println("2. 목록");
        System.out.println("3. 상세");
        System.out.println("4. 수정");
        System.out.println("5. 삭제");
        System.out.println("0. 메인");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("지점> ");
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
    System.out.println("[지점 등록]");

    Store s = new Store();
    s.no = Prompt.inputInt("번호> ");
    s.name = Prompt.inputString("지점명> ");
    s.address = Prompt.inputString("주소> ");
    s.tel = Prompt.inputString("전화번호> ");
    s.time = Prompt.inputString("영업시간> ");
    s.manager = inputEmployee("매니저> ");
    if (s.manager == null) {
      System.out.println("지점 등록을 취소하였습니다.");
      return;
    }
    storeList.add(s);
    System.out.println("지점을 등록하였습니다.");
  }

  public void list() {
    System.out.println("[지점 목록]");
    Store[] stores = storeList.toArray();
    for (Store s : stores) {
      System.out.printf("%d> %s점 %s TEL.%s\n", 
          s.no, s.name, s.address,telFormat(s.tel));
    } 
  }

  public void detail() {
    System.out.println("[지점 상세]");

    int no = Prompt.inputInt("번호> ");
    Store store = storeList.get(no);
    if (store == null) {
      System.out.println("해당 번호의 지점이 없습니다.");
      return;
    }
    System.out.printf("지점명: %s\n", store.name);
    System.out.printf("주소: %s\n", store.address);
    System.out.printf("전화번호: %s\n", 
        telFormat(store.tel));
    System.out.printf("영업시간: %s\n", store.time);
    System.out.printf("매니저: %s\n", store.manager);
  }

  public void update() {
    System.out.println("[지점 수정]");

    int no = Prompt.inputInt("번호> ");
    Store store = storeList.get(no);
    if (store == null) {
      System.out.println("해당 번호의 지점이 없습니다.");
      return;
    }
    String name = Prompt.inputString(String.format("지점명(%s)> ", store.name));
    String address = Prompt.inputString(String.format("주소(%s)> ", store.address));
    String tel = Prompt.inputString(String.format("전화번호(%s)> ", store.tel));
    String time = Prompt.inputString(String.format("영업시간(%s)> ", store.time));
    String manager = Prompt.inputString(String.format("매니저(%s)> ", store.manager));
    if (manager == null) {
      System.out.println("지점 수정을 취소하였습니다.");
      return;
    }

    String input = Prompt.inputString("변경하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      store.name = name;
      store.address = address;
      store.tel = tel;
      store.time = time;
      store.manager = manager;
      System.out.println("지점 정보를 변경하였습니다.");
    } else {
      System.out.println("수정을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[지점 삭제]");

    int no = Prompt.inputInt("번호> ");
    Store store = storeList.get(no);
    if (store == null) {
      System.out.println("해당 번호의 지점이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      storeList.delete(no);
      System.out.println("지점 정보를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }

  public String telFormat(String tel) {
    if(tel.length() == 10) {  
      return tel.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
    } else if (tel.length() == 11) { 
      return tel.replaceFirst("(^[0-9]{3})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
    } else {
      return tel.replaceFirst("(^02)([0-9]{3})([0-9]{4})$", "$1-$2-$3"); 
    }
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
