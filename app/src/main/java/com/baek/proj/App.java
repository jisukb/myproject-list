package com.baek.proj;

import com.baek.proj.handler.EmployeeHandler;
import com.baek.proj.handler.ProductHandler;
import com.baek.proj.handler.StoreHandler;
import com.baek.util.Prompt;

public class App {
  public static void main(String[] args) {
    System.out.println("1. 사원 등록\t2. 사원 목록\t3. 제품등록\t4. 제품 목록\t"
        + "5. 지점 등록\t6. 지점 정보\t7. 종료(quit/exit)");
    System.out.println();

    EmployeeHandler employeeList = new EmployeeHandler();
    ProductHandler productList = new ProductHandler();
    StoreHandler storeList = new StoreHandler(employeeList);

    loop: 
      while (true) {
        String choice = Prompt.inputString("원하는 메뉴를 선택하세요.> ");

        switch (choice) {
          case "1":
            employeeList.add();
            break;
          case "2":
            employeeList.list();
            break;
          case "3":
            productList.add();
            break;
          case "4":
            productList.list();
            break;
          case "5":
            storeList.add();
            break;
          case "6": 
            storeList.list();
            break;
          case "7":
          case "quit":
          case "exit":
            System.out.println("프로그램을 종료합니다.");
            break loop;
          default:
            System.out.println("잘못 선택하셨습니다.");
        }

        System.out.println();
      }

    Prompt.close();
  }
}
