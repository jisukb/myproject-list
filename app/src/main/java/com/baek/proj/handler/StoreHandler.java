package com.baek.proj.handler;

import java.util.Iterator;
import java.util.LinkedList;
import com.baek.proj.domain.Store;
import com.baek.util.Prompt;

public class StoreHandler {

  private LinkedList<Store> storeList = new LinkedList<>();

  private EmployeeHandler employeeHandler;

  public StoreHandler(EmployeeHandler employeeHandler) {
    this.employeeHandler = employeeHandler;
  }

  public void service() throws CloneNotSupportedException {
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
    s.setNo(Prompt.inputInt("번호> "));
    s.setName(Prompt.inputString("지점명> "));
    s.setAddress(Prompt.inputString("주소> "));
    s.setTel(Prompt.inputString("전화번호> "));
    s.setTime(Prompt.inputString("영업시간> "));
    s.setManager(employeeHandler.inputEmployee("매니저> "));
    if (s.getManager() == null) {
      System.out.println("지점 등록을 취소하였습니다.");
      return;
    }

    storeList.add(s);
    System.out.println("지점을 등록하였습니다.");
  }

  public void list() throws CloneNotSupportedException {
    System.out.println("[지점 목록]");

    Iterator<Store> iterator = storeList.iterator();
    while (iterator.hasNext()) {
      Store s = iterator.next();
      // 번호, 지점명, 주소, 전화번호
      System.out.printf("%d> %s점 %s TEL.%s\n", 
          s.getNo(), s.getName(), s.getAddress(), telFormat(s.getTel()));
    } 
  }

  public void detail() {
    System.out.println("[지점 상세]");

    int no = Prompt.inputInt("번호> ");
    Store store = findByNo(no);
    if (store == null) {
      System.out.println("해당 번호의 지점이 없습니다.");
      return;
    }
    System.out.printf("지점명: %s\n", store.getName());
    System.out.printf("주소: %s\n", store.getAddress());
    System.out.printf("전화번호: %s\n", telFormat(store.getTel()));
    System.out.printf("영업시간: %s\n", store.getTime());
    System.out.printf("매니저: %s\n", store.getManager());
  }

  public void update() {
    System.out.println("[지점 수정]");

    int no = Prompt.inputInt("번호> ");
    Store store = findByNo(no);
    if (store == null) {
      System.out.println("해당 번호의 지점이 없습니다.");
      return;
    }
    String name = Prompt.inputString(String.format("지점명(%s)> ", store.getName()));
    String address = Prompt.inputString(String.format("주소(%s)> ", store.getAddress()));
    String tel = Prompt.inputString(String.format("전화번호(%s)> ", store.getTel()));
    String time = Prompt.inputString(String.format("영업시간(%s)> ", store.getTime()));
    String manager = Prompt.inputString(String.format("매니저(%s)> ", store.getManager()));
    if (manager == null) {
      System.out.println("지점 수정을 취소하였습니다.");
      return;
    }

    String input = Prompt.inputString("변경하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      store.setName(name);
      store.setAddress(address);
      store.setTel(tel);
      store.setTime(time);
      store.setManager(manager);
      System.out.println("지점 정보를 변경하였습니다.");
    } else {
      System.out.println("수정을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[지점 삭제]");

    int no = Prompt.inputInt("번호> ");
    Store store = findByNo(no);
    if (store == null) {
      System.out.println("해당 번호의 지점이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      storeList.remove(store);
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

  private Store findByNo(int storeNo) {
    Store[] list = storeList.toArray(new Store[storeList.size()]);
    for (Store s : list) {
      if (s.getNo() == storeNo) {
        return s;
      }
    }
    return null;
  }
}
