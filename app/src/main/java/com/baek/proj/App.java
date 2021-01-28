package com.baek.proj;

import com.baek.proj.handler.EmployeeHandler;
import com.baek.proj.handler.ProductHandler;
import com.baek.proj.handler.StoreHandler;
import com.baek.util.Prompt;

public class App {
  public static void main(String[] args) {

    EmployeeHandler employeeHandler = new EmployeeHandler();
    ProductHandler productHandler = new ProductHandler();
    StoreHandler storeHandler = new StoreHandler(employeeHandler);

    loop: 
      while (true) {

        System.out.println("-----메인-----");
        System.out.println("1. 사원");
        System.out.println("2. 상품");
        System.out.println("3. 지점");
        System.out.println("0. 종료");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("메인> ");
        System.out.println();
        switch (command) {
          case "1":
            employeeHandler.service();
            break;
          case "2":
            productHandler.service();
            break;
          case "3":
            storeHandler.service();
            break;
          case "0":
            System.out.println("프로그램을 종료합니다.");
            break loop;
          default:
            System.out.println("해당 번호가 없습니다.");
        }

        System.out.println();
      }

    Prompt.close();
  }
}
