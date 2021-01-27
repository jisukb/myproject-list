package com.baek.proj.handler;

import com.baek.proj.domain.Store;
import com.baek.util.Prompt;

public class StoreHandler {

  static final int LENGTH = 100;

  EmployeeHandler employeeList;

  Store[] stores = new Store[LENGTH];
  int index = 0;

  public StoreHandler(EmployeeHandler employeeHandler) {
    this.employeeList = employeeHandler;
  }

  public void add() {
    System.out.println("[지점 등록]");

    Store s = new Store();
    s.no = Prompt.inputInt("번호> ");
    s.name = Prompt.inputString("지점명> ");
    s.address = Prompt.inputString("주소> ");
    s.tel = Prompt.inputString("전화번호> ");
    s.time = Prompt.inputString("영업시간> ");
    while (true) {
      String name = Prompt.inputString("담당자> ");
      if (name.length() == 0) {
        System.out.println("지점 등록을 취소합니다.");
        return;
      }
      if (employeeList.exist(name)) {
        s.manager = name;
        break;
      }
      System.out.println("등록된 사원이 아닙니다.");
    }
    this.stores[this.index++] = s;
  }

  public void list() {
    System.out.println("[지점 정보]");
    for (int i = 0; i < this.index; i++) {
      Store s = this.stores[i];
      System.out.printf("%d> %s점 TEL.%s\n", s.no, s.name, format(s.tel));
      System.out.printf("%s, %s\n", s.address, s.time);
      System.out.println("--------------------------------------");
    } 
  }

  public String format(String tel) {
    if(tel.length() == 10) {  
      return tel.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
    } else if ( tel.length() == 11) { 
      return tel.replaceFirst("(^[0-9]{3})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
    } else {
      return tel.replaceFirst("(^02)([0-9]{3,4})([0-9]{4})$", "$1-$2-$3"); 
    }
  }
}
