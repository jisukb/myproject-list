package com.baek.proj;

public class StoreHandler {
  static final int SLENGTH = 100;
  static int[] sno = new int[SLENGTH];
  static String[] sname = new String[SLENGTH];
  static String[] address = new String[SLENGTH];
  static String[] tel = new String[SLENGTH];
  static String[] time = new String[SLENGTH];
  static String[] manager = new String[SLENGTH];
  static int sindex = 0;

  static void add() {
    System.out.println("[지점 등록]");
    sno[sindex] = Prompt.inputInt("번호> ");
    sname[sindex] = Prompt.inputString("지점명> ");
    address[sindex] = Prompt.inputString("주소> ");
    tel[sindex] = Prompt.inputString("전화번호> ");
    time[sindex] = Prompt.inputString("영업시간> ");
    manager[sindex] = Prompt.inputString("담당자> ");
    sindex++;
  }

  static void list() {
    System.out.println("[지점 정보]");
    for (int i = 0; i < sindex; i++) {
      System.out.printf("%d> %s (%s)\n", sno[i], sname[i], tel[i]);
      System.out.printf("%s, %s\n", address[i], time[i]);
      System.out.println("----------------------------------");
    } 
  }
}
