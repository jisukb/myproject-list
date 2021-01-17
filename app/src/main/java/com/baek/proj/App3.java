package com.baek.proj;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    System.out.println("[제품]");

    Scanner keyScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] category = new String[LENGTH];
    String[] pdname = new String[LENGTH];
    int[] price = new int[LENGTH];
    int[] stock = new int[LENGTH];

    int index = 0;

    for (int i = 0; i < LENGTH; i++) {
      System.out.print("번호> ");
      no[i] = Integer.parseInt(keyScan.nextLine());

      System.out.print("카테고리> ");
      category[i] = keyScan.nextLine();

      System.out.print("제품명> ");
      pdname[i] = keyScan.nextLine();

      System.out.print("가격> ");
      price[i] = Integer.parseInt(keyScan.nextLine());

      System.out.println("재고상태");
      System.out.println("0: 예약");
      System.out.println("1: 판매중");
      System.out.println("2: 품절");
      System.out.print("> ");
      stock[i] = Integer.parseInt(keyScan.nextLine());

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
      String state = null;
      switch (stock[i]) {
        case 1:
          state = "판매중";
          break;
        case 2:
          state = "품절";
        default:
          state = "예약";
      }
      System.out.printf("%d: %s> %s %d원, %s\n",
          no[i], category[i], pdname[i], price[i], state);
    }
  }
}
