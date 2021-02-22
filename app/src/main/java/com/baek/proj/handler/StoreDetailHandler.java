package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Store;
import com.baek.util.Prompt;

public class StoreDetailHandler extends AbstractStoreHandler {

  public StoreDetailHandler(List<Store> storeList) {
    super(storeList);
  }

  @Override
  public void service() {
    System.out.println("[지점 상세]");

    int no = Prompt.inputInt("번호> ");
    Store store = findByNo(no);
    if (store == null) {
      System.out.println("해당 번호의 지점이 없습니다.");
      return;
    }
    System.out.printf("지점명: %s\n", store.getName());
    System.out.printf("주소: %s\n", store.getAddress());
    System.out.printf("전화번호: %s\n", telFormat(store.getTel()));
    System.out.printf("영업시간: %s\n", store.getTime());
    System.out.printf("매니저: %s\n", store.getManager());
  }
} 
