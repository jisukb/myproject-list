package com.baek.proj;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    System.out.println("[사원]"); 

    Scanner keyScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] position = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] phone = new String[LENGTH];
    Date[] joinDate = new Date[LENGTH];

    int index = 0;

    for (int i = 0; i < LENGTH; i++) {
      System.out.print("번호> ");
      no[i] = Integer.parseInt(keyScan.nextLine());

      System.out.print("이름> ");
      name[i] = keyScan.nextLine();

      System.out.print("직급> ");
      position[i] = keyScan.nextLine();

      System.out.print("메일> ");
      email[i] = keyScan.nextLine();

      System.out.print("전화번호> ");
      phone[i] = keyScan.nextLine();

      System.out.print("입사일> ");
      joinDate[i] = Date.valueOf(keyScan.nextLine());

      index++;
      System.out.println();
      System.out.println("계속 입력하시겠습니까? Y/N ");
      String str = keyScan.nextLine();
      if (str.equalsIgnoreCase("n")) {
        break;
      }
    }

    keyScan.close();

    System.out.println("--------------------------------------");
    for (int i = 0; i < index; i++) {
      System.out.printf("%d> %s, %s, %s, %s, %s\n", 
          no[i], name[i], position[i], email[i], phone[i], joinDate[i]);
    }
  }
}
