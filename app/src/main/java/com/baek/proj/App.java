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

    final int PLENGTH = 100;

    int[] pno = new int[PLENGTH];
    String[] category = new String[PLENGTH];
    String[] pdname = new String[PLENGTH];
    int[] price = new int[PLENGTH];
    int[] stock = new int[PLENGTH];

    int pindex = 0;

    final int FLENGTH = 100;

    int[] fno = new int[FLENGTH];
    String[] fname = new String[FLENGTH];
    String[] location = new String[FLENGTH];
    String[] number = new String[FLENGTH];
    String[] manager = new String[FLENGTH];
    Date[] openDate = new Date[FLENGTH];

    int findex = 0;

    System.out.println("1. 사원 등록");
    System.out.println("2. 사원 목록");
    System.out.println("---------------");
    System.out.println("3. 제품 등록");
    System.out.println("4. 제품 목록");
    System.out.println("---------------");
    System.out.println("5. 지점 등록");
    System.out.println("6. 지점 목록");
    System.out.println("---------------");
    System.out.println("7. 종료");
    System.out.println();

    loop: 
      while (true) {
        System.out.print("명령> ");
        String choice = keyScan.nextLine();

        switch (choice) {
          case "1":
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
            break;
          case "2":
            System.out.println("[사원 목록]");
            for (int i = 0; i < index; i++) {
              System.out.printf("%d> %s, %s, %s, %s, %s\n", 
                  no[i], name[i], position[i], email[i], phone[i], joinDate[i]);
            } 
            break;
          case "3":
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
            break;
          case "4":
            System.out.println("[제품 목록]");
            for (int i = 0; i < pindex; i++) {
              String state = null;
              switch (stock[i]) {
                case 1:
                  state = "판매중";
                  break;
                case 2:
                  state = "품절";
                  break;
                default:
                  state = "예약";
              }
              System.out.printf("%d. %s> %s %d원, %s\n",
                  pno[i], category[i], pdname[i], price[i], state);
            } 
            break;
          case "5":
            System.out.println("[지점 등록]");
            System.out.print("번호> ");
            fno[findex] = Integer.parseInt(keyScan.nextLine());

            System.out.print("지점명> ");
            fname[findex] = keyScan.nextLine();

            System.out.print("위치> ");
            location[findex] = keyScan.nextLine();

            System.out.print("전화번호> ");
            number[findex] = keyScan.nextLine();

            System.out.print("담당자> ");
            manager[findex] = keyScan.nextLine();

            System.out.print("오픈일> ");
            openDate[findex] = Date.valueOf(keyScan.nextLine());

            findex++;
            break;
          case "6": 
            System.out.println("[지점 목록]");
            for (int i = 0; i < findex; i++) {
              System.out.printf("%d> %s (%s)\n", fno[i], fname[i], number[i]);
              System.out.printf("%s, %s 오픈\n", location[i], openDate[i]);
            } 
            break;
          case "7":
            System.out.println("END");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }

        System.out.println();
      }

    keyScan.close();
  }
}
