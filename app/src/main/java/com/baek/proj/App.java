package com.baek.proj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.baek.proj.domain.Employee;
import com.baek.proj.domain.Product;
import com.baek.proj.domain.Review;
import com.baek.proj.domain.Store;
import com.baek.proj.handler.Command;
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
import com.baek.util.CsvObject;
import com.baek.util.ObjectFactory;
import com.baek.util.Prompt;

public class App {

  // 입력한 명령 저장
  static ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();

  // Value Object 저장 컬렉션 객체
  static ArrayList<Employee> employeeList = new ArrayList<>();
  static ArrayList<Store> storeList = new ArrayList<>();
  static ArrayList<Product> productList = new ArrayList<>();
  static ArrayList<Review> reviewList = new ArrayList<>();

  // 데이터 파일 정보
  static File employeeFile = new File("employee.csv");
  static File storeFile = new File("store.csv");
  static File productFile = new File("product.csv");
  static File reviewFile = new File("review.csv");

  public static void main(String[] args) {

    // 파일에서 데이터 로딩
    loadObjects(employeeFile, employeeList, Employee::new);
    loadObjects(storeFile, storeList, Store::new);
    loadObjects(productFile, productList, Product::new);
    loadObjects(reviewFile, reviewList, Review::new);

    // 명령 처리 객체 맵에 보관
    HashMap<String,Command> commandMap = new HashMap<>();

    commandMap.put("employeeadd", new EmployeeAddHandler(employeeList));
    commandMap.put("employeelist", new EmployeeListHandler(employeeList));
    commandMap.put("employeedetail", new EmployeeDetailHandler(employeeList));
    commandMap.put("employeeupdate", new EmployeeUpdateHandler(employeeList));
    commandMap.put("employeedelete", new EmployeeDeleteHandler(employeeList));
    EmployeeValidatorHandler employeeValidatorHandler = new EmployeeValidatorHandler(employeeList);

    commandMap.put("storeadd", new StoreAddHandler(storeList, employeeValidatorHandler));
    commandMap.put("storelist", new StoreListHandler(storeList));
    commandMap.put("storedetail", new StoreDetailHandler(storeList));
    commandMap.put("storeupdate", new StoreUpdateHandler(storeList, employeeValidatorHandler));
    commandMap.put("storedelete", new StoreDeleteHandler(storeList));

    commandMap.put("productadd", new ProductAddHandler(productList));
    commandMap.put("productlist", new ProductListHandler(productList));
    commandMap.put("productdetail", new ProductDetailHandler(productList));
    commandMap.put("productupdate", new ProductUpdateHandler(productList));
    commandMap.put("productdelete", new ProductDeleteHandler(productList));
    commandMap.put("productsearch", new ProductSearchHandler(productList));
    ProductValidatorHandler productValidatorHandler = new ProductValidatorHandler(productList);

    commandMap.put("reviewadd", new ReviewAddHandler(reviewList, productValidatorHandler));
    commandMap.put("reviewlist", new ReviewListHandler(reviewList));
    commandMap.put("reviewdetail", new ReviewDetailHandler(reviewList));
    commandMap.put("reviewupdate", new ReviewUpdateHandler(reviewList, productValidatorHandler));
    commandMap.put("reviewdelete", new ReviewDeleteHandler(reviewList));
    commandMap.put("reviewsearch", new ReviewSearchHandler(reviewList));

    commandMap.put("hello", new HelloHandler());

    System.out.println("===============메인===============");
    System.out.println("1. 사원 2. 지점 3. 상품 4. 리뷰");
    System.out.println("종료 quit/exit");
    System.out.println("==================================");

    loop: 
      while (true) {

        String command = com.baek.util.Prompt.inputString("메인> ");
        System.out.println();

        if (command.length() == 0) // 빈 문자열 입력 시 재입력
          continue;

        // 명령 보관
        commandStack.push(command);
        commandQueue.offer(command);

        try {
          switch (command) {
            case "1":
              System.out.println("----------사원----------");
              System.out.println("등록 employeeadd");
              System.out.println("목록 employeelist");
              System.out.println("상세 employeedetail");
              System.out.println("수정 employeeupdate");
              System.out.println("삭제 employeedelete");
              System.out.println("------------------------");
              break;
            case "2":
              System.out.println("----------지점----------");
              System.out.println("등록 storeadd");
              System.out.println("목록 storelist");
              System.out.println("상세 storedetail");
              System.out.println("수정 storeupdate");
              System.out.println("삭제 storedelete");
              System.out.println("------------------------");
              break;
            case "3":
              System.out.println("----------상품----------");
              System.out.println("등록 productadd");
              System.out.println("목록 productlist");
              System.out.println("상세 productdetail");
              System.out.println("수정 productupdate");
              System.out.println("삭제 productdelete");
              System.out.println("검색 productsearch");
              System.out.println("------------------------");
              break;
            case "4":
              System.out.println("----------리뷰----------");
              System.out.println("등록 reviewadd");
              System.out.println("목록 reviewlist");
              System.out.println("상세 reviewdetail");
              System.out.println("수정 reviewupdate");
              System.out.println("삭제 reviewdelete");
              System.out.println("검색 reviewsearch");
              System.out.println("------------------------");
              break;
            case "history":
              printCommandHistory(commandStack.iterator());
              break;
            case "history2":
              printCommandHistory(commandQueue.iterator());
              break;
            case "exit":
            case "quit":
              System.out.println("프로그램을 종료합니다.");
              break loop;
            default:
              Command commandHandler = commandMap.get(command);

              if (commandHandler == null) {
                System.out.println("실행할 수 없는 명령입니다.");
              } else {
                commandHandler.service();
              }
          }
        } catch (Exception e) {
          System.out.println("----------------------------------------------------");
          System.out.printf("오류 발생: %s - %s\n", e.getClass().getName(), e.getMessage());
          System.out.println("----------------------------------------------------");
        }
        System.out.println();
      }

    // 데이터 파일로 출력
    saveObjects(employeeFile, employeeList);
    saveObjects(storeFile, storeList);
    saveObjects(productFile, productList);
    saveObjects(reviewFile, reviewList);

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

  static <T> void loadObjects(File file, List<T> list, ObjectFactory<T> objFactory) {
    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      String csvStr = null;
      while ((csvStr = in.readLine()) != null) {
        list.add(objFactory.create(csvStr));
      }
      System.out.printf("파일 %s 데이터 로딩\n", file.getName());
    } catch (Exception e) {
      System.out.printf("파일 %s 데이터 로딩 중 오류 발생\n", file.getName());
    }
  }

  static <T extends CsvObject> void saveObjects(File file, List<T> list) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      for (CsvObject csvObj : list) {
        out.write(csvObj.toCsvString() + "\n");
      }
      System.out.printf("파일 %s 데이터 저장\n", file.getName());
    } catch (Exception e) {
      System.out.printf("파일 %s 데이터 저장 중 오류 발생\n", file.getName());
    }
  }

}
