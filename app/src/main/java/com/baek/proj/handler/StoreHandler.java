package com.baek.proj.handler;

import com.baek.util.Prompt;

public class StoreHandler {

  static class Store {
    int no;
    String name;
    String address;
    String tel;
    String time;
    String manager;
  }

  static final int LENGTH = 100;
  static Store[] stores = new Store[LENGTH];
  static int index = 0;

  public static void add() {
    System.out.println("[지점 등록]");

    Store s = new Store();
    s.no = Prompt.inputInt("번호> ");
    s.name = Prompt.inputString("지점명> ");
    s.address = Prompt.inputString("주소> ");
    s.tel = Prompt.inputString("전화번호> ");
    s.time = Prompt.inputString("영업시간> ");
    s.manager = Prompt.inputString("담당자> ");
    stores[index++] = s;
  }

  public static void list() {
    System.out.println("[지점 정보]");
    for (int i = 0; i < index; i++) {
      Store s = stores[i];
      System.out.printf("%d> %s (%s)\n", s.no, s.name, s.tel);
      System.out.printf("%s, %s\n", s.address, s.time);
      System.out.println("----------------------------------");
    } 
  }
}
