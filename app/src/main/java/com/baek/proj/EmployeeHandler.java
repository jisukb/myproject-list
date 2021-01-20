package com.baek.proj;

import java.sql.Date;

public class EmployeeHandler {
  static final int LENGTH = 100;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] position = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] phone = new String[LENGTH];
  static Date[] joinDate = new Date[LENGTH];
  static int index = 0;

  static void add() {
    System.out.println("[사원 등록]");
    name[index] = Prompt.inputString("이름> ");
    position[index] = Prompt.inputString("부서> ");
    email[index] = Prompt.inputString("메일> ");
    phone[index] = Prompt.inputString("전화번호> ");
    joinDate[index] = Prompt.inputDate("입사일> ");
    index++;
  }

  static void list() {
    System.out.println("[사원 목록]");
    for (int i = 0; i < index; i++) {
      System.out.printf("%d> %s (%s부)\n%s, %s\n입사일 %s\n", 
          i+1, name[i], position[i], email[i], phone[i], joinDate[i]);
      System.out.println("----------------------------------");
    }
  }
}
