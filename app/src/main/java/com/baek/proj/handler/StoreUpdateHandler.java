package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Store;
import com.baek.util.Prompt;

public class StoreUpdateHandler extends AbstractStoreHandler {

  private EmployeeValidatorHandler employeeValidatorHandler;

  public StoreUpdateHandler(List<Store> storeList, EmployeeValidatorHandler employeeValidatorHandler) {
    super(storeList);
    this.employeeValidatorHandler = employeeValidatorHandler;
  }

  @Override
  public void service() {
    System.out.println("[지점 수정]");

    int no = Prompt.inputInt("번호> ");
    Store store = findByNo(no);
    if (store == null) {
      System.out.println("해당 번호의 지점이 없습니다.");
      return; 
    }
    String name = Prompt.inputString(String.format("지점명(%s)> ", store.getName()));
    String address = Prompt.inputString(String.format("주소(%s)> ", store.getAddress()));
    String tel = Prompt.inputString(String.format("전화번호(%s)> ", store.getTel()));
    String time = Prompt.inputString(String.format("영업시간(%s)> ", store.getTime()));
    String manager = employeeValidatorHandler.inputEmployee
        (String.format("매니저(%s)> ", store.getManager()));
    if (manager == null) {
      System.out.println("지점 수정을 취소하였습니다.");
      return;
    }

    String input = Prompt.inputString("변경하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      store.setName(name);
      store.setAddress(address);
      store.setTel(tel);
      store.setTime(time);
      store.setManager(manager);
      System.out.println("지점 정보를 변경하였습니다.");
    } else {
      System.out.println("수정을 취소하였습니다.");
    }
  }
}
