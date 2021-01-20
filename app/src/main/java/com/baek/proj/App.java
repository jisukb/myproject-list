package com.baek.proj;

import com.baek.proj.handler.EmployeeHandler;
import com.baek.proj.handler.ProductHandler;
import com.baek.proj.handler.StoreHandler;
import com.baek.util.Prompt;

public class App {
  public static void main(String[] args) {

    System.out.println("1. 사원 등록");
    System.out.println("2. 사원 목록");
    System.out.println("---------------");
    System.out.println("3. 제품 등록");
    System.out.println("4. 제품 목록");
    System.out.println("---------------");
    System.out.println("5. 지점 등록");
    System.out.println("6. 지점 정보");
    System.out.println("---------------");
    System.out.println("7. 종료");
    System.out.println();

    loop: 
      while (true) {
        String choice = Prompt.inputString("명령> ");

        switch (choice) {
          case "1":
            EmployeeHandler.add();
            break;
          case "2":
            EmployeeHandler.list();
            break;
          case "3":
            ProductHandler.add();
            break;
          case "4":
            ProductHandler.list();
            break;
          case "5":
            StoreHandler.add();
            break;
          case "6": 
            StoreHandler.list();
            break;
          case "7":
            System.out.println("-END-");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }

        System.out.println();
      }

    Prompt.close();
  }
}
