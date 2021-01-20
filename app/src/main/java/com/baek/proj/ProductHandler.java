package com.baek.proj;

public class ProductHandler {
  static final int PLENGTH = 100;
  static int[] pno = new int[PLENGTH];
  static String[] category = new String[PLENGTH];
  static String[] pname = new String[PLENGTH];
  static int[] price = new int[PLENGTH];
  static int[] stock = new int[PLENGTH];
  static int pindex = 0;

  static void add() {
    System.out.println("[제품 등록]");
    pno[pindex] = Prompt.inputInt("번호> ");
    category[pindex] = Prompt.inputString("카테고리> ");
    pname[pindex] = Prompt.inputString("제품명> ");
    price[pindex] = Prompt.inputInt("가격> ");
    stock[pindex] = Prompt.inputInt("재고상태\n0: 예약\n1: 판매중\n2: 품절\n> ");
    pindex++;
  }

  static void list() {
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
          pno[i], category[i], pname[i], price[i], state);
    }
  }
}
