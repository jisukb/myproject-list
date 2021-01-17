package com.baek.proj;

import java.sql.Date;
import java.util.Scanner;

public class App4 {
  public static void main(String[] args) {
    System.out.println("[지점]");

    Scanner keyScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] location = new String[LENGTH];
    String[] number = new String[LENGTH];
    String[] manager = new String[LENGTH];
    Date[] openDate = new Date[LENGTH];

    int index = 0;

    for (int i = 0; i < LENGTH; i++) {
      System.out.print("번호> ");
      no[i] = Integer.parseInt(keyScan.nextLine());

      System.out.print("지점명> ");
      name[i] = keyScan.nextLine();

      System.out.print("위치> ");
      location[i] = keyScan.nextLine();

      System.out.print("전화번호> ");
      number[i] = keyScan.nextLine();

      System.out.print("담당자> ");
      manager[i] = keyScan.nextLine();

      System.out.print("오픈일> ");
      openDate[i] = Date.valueOf(keyScan.nextLine());

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
      System.out.printf("%d> %s (%s)\n", no[i], name[i], number[i]);
      System.out.printf("%s, %s 오픈\n", location[i], openDate[i]);
    }
  }
}
