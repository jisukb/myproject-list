package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Store;
import com.baek.util.Prompt;

public class StoreAddHandler extends AbstractStoreHandler {

  private EmployeeValidatorHandler employeeValidatorHandler;

  public StoreAddHandler(List<Store> storeList, EmployeeValidatorHandler employeeValidatorHandler) {
    super(storeList);
    this.employeeValidatorHandler = employeeValidatorHandler;
  }

  @Override
  public void service() {
    System.out.println("[지점 등록]");

    Store s = new Store();
    s.setNo(Prompt.inputInt("번호> "));
    s.setName(Prompt.inputString("지점명> "));
    s.setAddress(Prompt.inputString("주소> "));
    s.setTel(Prompt.inputString("전화번호> "));
    s.setTime(Prompt.inputString("영업시간> "));
    s.setManager(employeeValidatorHandler.inputEmployee("매니저> "));
    if (s.getManager() == null) {
      System.out.println("지점 등록을 취소하였습니다.");
      return;
    }

    storeList.add(s);
    System.out.println("지점을 등록하였습니다.");
  }
} 
