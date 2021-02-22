package com.baek.proj;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import com.baek.proj.domain.Employee;
import com.baek.proj.domain.Product;
import com.baek.proj.domain.Review;
import com.baek.proj.domain.Store;
import com.baek.proj.handler.EmployeeAddHandler;
import com.baek.proj.handler.EmployeeDeleteHandler;
import com.baek.proj.handler.EmployeeDetailHandler;
import com.baek.proj.handler.EmployeeListHandler;
import com.baek.proj.handler.EmployeeUpdateHandler;
import com.baek.proj.handler.EmployeeValidatorHandler;
import com.baek.proj.handler.HelloHandler;
import com.baek.proj.handler.ProductAddHandler;
import com.baek.proj.handler.ProductDeleteHandler;
import com.baek.proj.handler.ProductDetailHandler;
import com.baek.proj.handler.ProductListHandler;
import com.baek.proj.handler.ProductSearchHandler;
import com.baek.proj.handler.ProductUpdateHandler;
import com.baek.proj.handler.ProductValidatorHandler;
import com.baek.proj.handler.ReviewAddHandler;
import com.baek.proj.handler.ReviewDeleteHandler;
import com.baek.proj.handler.ReviewDetailHandler;
import com.baek.proj.handler.ReviewListHandler;
import com.baek.proj.handler.ReviewSearchHandler;
import com.baek.proj.handler.ReviewUpdateHandler;
import com.baek.proj.handler.StoreAddHandler;
import com.baek.proj.handler.StoreDeleteHandler;
import com.baek.proj.handler.StoreDetailHandler;
import com.baek.proj.handler.StoreListHandler;
import com.baek.proj.handler.StoreUpdateHandler;
import com.baek.util.Prompt;

public class App {

  static ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();

  static LinkedList<Employee> employeeList = new LinkedList<>();
  static EmployeeAddHandler employeeAddHandler = new EmployeeAddHandler(employeeList);
  static EmployeeListHandler employeeListHandler = new EmployeeListHandler(employeeList);
  static EmployeeDetailHandler employeeDetailHandler = new EmployeeDetailHandler(employeeList);
  static EmployeeUpdateHandler employeeUpdateHandler = new EmployeeUpdateHandler(employeeList);
  static EmployeeDeleteHandler employeeDeleteHandler = new EmployeeDeleteHandler(employeeList);
  static EmployeeValidatorHandler employeeValidatorHandler = new EmployeeValidatorHandler(employeeList);

  static LinkedList<Store> storeList = new LinkedList<>();
  static StoreAddHandler storeAddHandler = new StoreAddHandler(storeList, employeeValidatorHandler);
  static StoreListHandler storeListHandler = new StoreListHandler(storeList);
  static StoreDetailHandler storeDetailHandler = new StoreDetailHandler(storeList);
  static StoreUpdateHandler storeUpdateHandler = new StoreUpdateHandler(storeList, employeeValidatorHandler);
  static StoreDeleteHandler storeDeleteHandler = new StoreDeleteHandler(storeList);

  static LinkedList<Product> productList = new LinkedList<>();
  static ProductAddHandler productAddHandler = new ProductAddHandler(productList);
  static ProductListHandler productListHandler = new ProductListHandler(productList);
  static ProductDetailHandler productDetailHandler = new ProductDetailHandler(productList);
  static ProductUpdateHandler productUpdateHandler = new ProductUpdateHandler(productList);
  static ProductDeleteHandler productDeleteHandler = new ProductDeleteHandler(productList);
  static ProductValidatorHandler productValidatorHandler = new ProductValidatorHandler(productList);
  static ProductSearchHandler productSearchHandler = new ProductSearchHandler(productList);

  static LinkedList<Review> reviewList = new LinkedList<>();
  static ReviewAddHandler reviewAddHandler = new ReviewAddHandler(reviewList, productValidatorHandler);
  static ReviewListHandler reviewListHandler = new ReviewListHandler(reviewList);
  static ReviewDetailHandler reviewDetailHandler = new ReviewDetailHandler(reviewList);
  static ReviewUpdateHandler reviewUpdateHandler = new ReviewUpdateHandler(reviewList, productValidatorHandler);
  static ReviewDeleteHandler reviewDeleteHandler = new ReviewDeleteHandler(reviewList);
  static ReviewSearchHandler reviewSearchHandler = new ReviewSearchHandler(reviewList);

  public static void main(String[] args) {

    HelloHandler helloHandler = new HelloHandler();

    loop: 
      while (true) {

        System.out.println("=====메인=====");
        System.out.println("1. 사원");
        System.out.println("2. 지점");
        System.out.println("3. 상품");
        System.out.println("4. 리뷰");
        System.out.println("0. 종료");
        System.out.println("==============");

        String command = com.baek.util.Prompt.inputString("메인> ");
        System.out.println();

        if (command.length() == 0)
          continue;

        commandStack.push(command);
        commandQueue.offer(command);

        try {
          switch (command) {
            case "1":
              serviceEmployee();
              break;
            case "2":
              serviceStore();
              break;
            case "3":
              serviceProduct();
              break;
            case "4":
              serviceReview();
              break;
            case "hello":
              helloHandler.service();
              break;
            case "history":
              printCommandHistory(commandStack.iterator());
              break;
            case "history2":
              printCommandHistory(commandQueue.iterator());
              break;
            case "exit":
            case "quit":
            case "0":
              System.out.println("프로그램을 종료합니다.");
              break loop;
            default:
              System.out.println("해당 번호가 없습니다.");
          }
        } catch (Exception e) {
          System.out.println();
          System.out.printf("오류 발생: %s - %s\n", e.getClass().getName(), e.getMessage());
          System.out.println();
        }
        System.out.println();
      }

    Prompt.close();
  }

  private static void serviceEmployee() {

    loop: 
      while (true) {

        System.out.println("-----사원-----");
        System.out.println("1. 등록");
        System.out.println("2. 목록");
        System.out.println("3. 상세");
        System.out.println("4. 수정");
        System.out.println("5. 삭제");
        System.out.println("0. 메인");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("사원> ");
        System.out.println();

        if (command.length() == 0)
          continue;

        switch (command) {
          case "1":
            employeeAddHandler.service();
            break;
          case "2":
            employeeListHandler.service();
            break;
          case "3":
            employeeDetailHandler.service();
            break;
          case "4":
            employeeUpdateHandler.service();
            break;
          case "5":
            employeeDeleteHandler.service();
            break;
          case "0":
            break loop;
          default:
            System.out.println("해당 번호가 없습니다.");
        }

        System.out.println();
      }
  }

  private static void serviceStore() {

    loop: 
      while (true) {

        System.out.println("-----지점-----");
        System.out.println("1. 등록");
        System.out.println("2. 목록");
        System.out.println("3. 상세");
        System.out.println("4. 수정");
        System.out.println("5. 삭제");
        System.out.println("0. 메인");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("지점> ");
        System.out.println();

        if (command.length() == 0)
          continue;

        switch (command) {
          case "1":
            storeAddHandler.service();
            break;
          case "2":
            storeListHandler.service();
            break;
          case "3":
            storeDetailHandler.service();
            break;
          case "4":
            storeUpdateHandler.service();
            break;
          case "5":
            storeDeleteHandler.service();
            break;
          case "0":
            break loop;
          default:
            System.out.println("해당 번호가 없습니다.");
        }

        System.out.println();
      }
  }

  private static void serviceProduct() {

    loop: 
      while (true) {

        System.out.println("-----상품-----");
        System.out.println("1. 등록");
        System.out.println("2. 목록");
        System.out.println("3. 상세");
        System.out.println("4. 수정");
        System.out.println("5. 삭제");
        System.out.println("0. 메인");
        System.out.println("search");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("상품> ");
        System.out.println();

        if (command.length() == 0)
          continue;

        switch (command) {
          case "1":
            productAddHandler.service();
            break;
          case "2":
            productListHandler.service();
            break;
          case "3":
            productDetailHandler.service();
            break;
          case "4":
            productUpdateHandler.service();
            break;
          case "5":
            productDeleteHandler.service();
            break;
          case "search":
            productSearchHandler.service();
            break;
          case "0":
            break loop;
          default:
            System.out.println("해당 번호가 없습니다.");
        }

        System.out.println();
      }
  }

  private static void serviceReview() {

    loop: 
      while (true) {

        System.out.println("-----리뷰-----");
        System.out.println("1. 등록");
        System.out.println("2. 목록");
        System.out.println("3. 상세");
        System.out.println("4. 수정");
        System.out.println("5. 삭제");
        System.out.println("0. 메인");
        System.out.println("search");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("리뷰> ");
        System.out.println();

        if (command.length() == 0)
          continue;

        switch (command) {
          case "1":
            reviewAddHandler.service();
            break;
          case "2":
            reviewListHandler.service();
            break;
          case "3":
            reviewDetailHandler.service();
            break;
          case "4":
            reviewUpdateHandler.service();
            break;
          case "5":
            reviewDeleteHandler.service();
            break;
          case "search":
            reviewSearchHandler.service();
            break;
          case "0":
            break loop;
          default:
            System.out.println("해당 번호가 없습니다.");
        }

        System.out.println();
      }
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
