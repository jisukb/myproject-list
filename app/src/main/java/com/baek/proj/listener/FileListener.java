package com.baek.proj.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baek.context.ApplicationContextListener;
import com.baek.proj.domain.Employee;
import com.baek.proj.domain.Product;
import com.baek.proj.domain.Review;
import com.baek.proj.domain.Store;
import com.baek.util.CsvObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FileListener implements ApplicationContextListener {

  //데이터 파일 정보
  File employeeFile = new File("employee.json");
  File storeFile = new File("store.json");
  File productFile = new File("product.json");
  File reviewFile = new File("review.json");

  //Value Object 저장 컬렉션 객체
  List<Employee> employeeList;
  List<Store> storeList;
  List<Product> productList;
  List<Review> reviewList;

  @Override
  public void contextInitialized(Map<String,Object> context) {
    // 파일에서 데이터 로딩
    employeeList = loadObjects(employeeFile, Employee.class);
    storeList = loadObjects(storeFile, Store.class);
    productList = loadObjects(productFile, Product.class);
    reviewList = loadObjects(reviewFile, Review.class);

    // App 클래스에서 사용할 수 있도록 컬렉션 객체를 맵 객체에 담는다
    context.put("employeeList", employeeList);
    context.put("storeList", storeList);
    context.put("productList", productList);
    context.put("reviewList", reviewList);
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
    // 데이터 파일로 출력
    saveObjects(employeeFile, employeeList);
    saveObjects(storeFile, storeList);
    saveObjects(productFile, productList);
    saveObjects(reviewFile, reviewList);
  }

  private <T> List<T> loadObjects(File file, Class<T> elementType) {
    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      // 파일의 모든 데이터를 읽어서 보관
      StringBuilder strBuilder = new StringBuilder();
      String str = null;
      while ((str = in.readLine()) != null) {
        strBuilder.append(str);
      }

      Type listType = TypeToken.getParameterized(ArrayList.class, elementType).getType();
      List<T> list = new Gson().fromJson(strBuilder.toString(), listType);
      System.out.printf("파일 %s 데이터 로딩\n", file.getName());
      return list;

    } catch (Exception e) {
      System.out.printf("파일 %s 데이터 로딩 중 오류 발생\n", file.getName());
      return new ArrayList<T>();
    }
  }

  private <T extends CsvObject> void saveObjects(File file, List<T> list) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write(new Gson().toJson(list));
      System.out.printf("파일 %s 데이터 저장\n", file.getName());

    } catch (Exception e) {
      System.out.printf("파일 %s 데이터 저장 중 오류 발생\n", file.getName());
    }
  }

}
