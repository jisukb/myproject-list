package com.baek.proj;

import com.baek.proj.handler.EmployeeHandler;
import com.baek.proj.handler.ProductHandler;
import com.baek.proj.handler.ReviewHandler;
import com.baek.proj.handler.StoreHandler;
import com.baek.util.Iterator;
import com.baek.util.Prompt;
import com.baek.util.Queue;
import com.baek.util.Stack;

public class App {

  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

  public static void main(String[] args) throws CloneNotSupportedException {

    EmployeeHandler employeeHandler = new EmployeeHandler();
    ProductHandler productHandler = new ProductHandler();
    StoreHandler storeHandler = new StoreHandler(employeeHandler);
    ReviewHandler reviewHandler = new ReviewHandler(productHandler);

    loop: 
      while (true) {

        System.out.println("-----메인-----");
        System.out.println("1. 사원");
        System.out.println("2. 지점");
        System.out.println("3. 상품");
        System.out.println("4. 리뷰");
        System.out.println("0. 종료");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("메인> ");
        if (command.length() == 0)
          continue;

        commandStack.push(command);
        commandQueue.offer(command);

        System.out.println();

        switch (command) {
          case "1":
            employeeHandler.service();
            break;
          case "2":
            storeHandler.service();
            break;
          case "3":
            productHandler.service();
            break;
          case "4":
            reviewHandler.service();
            break;
          case "history":
            printCommandHistory(commandStack.iterator());
            break;
          case "history2":
            printCommandHistory(commandQueue.iterator());
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

  static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if ((++count % 5) == 0) {
        String input = Prompt.inputString(": ");
        if (input.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}
