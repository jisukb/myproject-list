package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Store;
import com.baek.util.Prompt;

public class StoreDeleteHandler extends AbstractStoreHandler {

  public StoreDeleteHandler(List<Store> storeList) {
    super(storeList);
  }

  @Override
  public void service() {
    System.out.println("[지점 삭제]");

    int no = Prompt.inputInt("번호> ");
    Store store = findByNo(no);
    if (store == null) {
      System.out.println("해당 번호의 지점이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      storeList.remove(store);
      System.out.println("지점 정보를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  } 
}
