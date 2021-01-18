package com.baek.proj;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] position = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] phone = new String[LENGTH];
    Date[] joinDate = new Date[LENGTH];

    int index = 0;

    int[] pno = new int[LENGTH];
    String[] category = new String[LENGTH];
    String[] pdname = new String[LENGTH];
    int[] price = new int[LENGTH];
    int[] stock = new int[LENGTH];

    int pindex = 0;

    int[] fno = new int[LENGTH];
    String[] fname = new String[LENGTH];
    String[] location = new String[LENGTH];
    String[] number = new String[LENGTH];
    String[] manager = new String[LENGTH];
    Date[] openDate = new Date[LENGTH];

    int oindex = 0;

    while (true) {
      System.out.println("사원 등록> /employee/add");
      System.out.println("사원 목록> /employee/list");
      System.out.println("제품 등록> /product/add");
      System.out.println("제품 목록> /product/list");
      System.out.println("지점 등록> /office/add");
      System.out.println("지점 목록> /office/list");
      System.out.println("종료> exit or quit");
      System.out.println();
      System.out.print("명령> ");
      String input = keyScan.nextLine();

      if (input.equalsIgnoreCase("exit") ||
          input.equalsIgnoreCase("quit")) {
        break;
      } else if (input.equalsIgnoreCase("/employee/add")) {
        System.out.println("[사원 등록]");
        System.out.print("번호> ");
        no[index] = Integer.parseInt(keyScan.nextLine());

        System.out.print("이름> ");
        name[index] = keyScan.nextLine();

        System.out.print("직급> ");
        position[index] = keyScan.nextLine();

        System.out.print("메일> ");
        email[index] = keyScan.nextLine();

        System.out.print("전화번호> ");
        phone[index] = keyScan.nextLine();

        System.out.print("입사일> ");
        joinDate[index] = Date.valueOf(keyScan.nextLine());

        index++;
      } else if (input.equalsIgnoreCase("/employee/list")) {
        System.out.println("[사원 목록]");
        for (int i = 0; i < index; i++) {
          System.out.printf("%d> %s, %s, %s, %s, %s\n", 
              no[i], name[i], position[i], email[i], phone[i], joinDate[i]);
        }
      } else if (input.equalsIgnoreCase("/product/add")) {
        System.out.println("[제품 등록]");
        System.out.print("번호> ");
        pno[pindex] = Integer.parseInt(keyScan.nextLine());

        System.out.print("카테고리> ");
        category[pindex] = keyScan.nextLine();

        System.out.print("제품명> ");
        pdname[pindex] = keyScan.nextLine();

        System.out.print("가격> ");
        price[pindex] = Integer.parseInt(keyScan.nextLine());

        System.out.println("재고상태");
        System.out.println("0: 예약");
        System.out.println("1: 판매중");
        System.out.println("2: 품절");
        System.out.print("> ");
        stock[pindex] = Integer.parseInt(keyScan.nextLine());

        pindex++;
      } else if (input.equalsIgnoreCase("/product/list")) {
        System.out.println("[제품 목록]");
        for (int i = 0; i < pindex; i++) {
          String state = null;
          switch (stock[pindex]) {
            case 1:
              state = "판매중";
              break;
            case 2:
              state = "품절";
            default:
              state = "예약";
          }
          System.out.printf("%d: %s> %s %d원, %s\n",
              pno[i], category[i], pdname[i], price[i], state);
        }
      } else if (input.equalsIgnoreCase("/office/add")) {
        System.out.println("[지점 등록]");
        System.out.print("번호> ");
        fno[oindex] = Integer.parseInt(keyScan.nextLine());

        System.out.print("지점명> ");
        fname[oindex] = keyScan.nextLine();

        System.out.print("위치> ");
        location[oindex] = keyScan.nextLine();

        System.out.print("전화번호> ");
        number[oindex] = keyScan.nextLine();

        System.out.print("담당자> ");
        manager[oindex] = keyScan.nextLine();

        System.out.print("오픈일> ");
        openDate[oindex] = Date.valueOf(keyScan.nextLine());

        oindex++;
      } else if (input.equalsIgnoreCase("/office/list")) {
        System.out.println("[지점 목록]");
        for (int i = 0; i < oindex; i++) {
          System.out.printf("%d> %s (%s)\n", fno[i], fname[i], number[i]);
          System.out.printf("%s, %s 오픈\n", location[i], openDate[i]);
        }
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    keyScan.close();
    System.out.println("END");
  }
}
