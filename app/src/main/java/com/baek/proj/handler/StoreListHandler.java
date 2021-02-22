package com.baek.proj.handler;

import java.util.Iterator;
import java.util.List;
import com.baek.proj.domain.Store;

public class StoreListHandler extends AbstractStoreHandler {

  public StoreListHandler(List<Store> storeList) {
    super(storeList);
  }

  @Override
  public void service() {
    System.out.println("[지점 목록]");

    Iterator<Store> iterator = storeList.iterator();
    while (iterator.hasNext()) {
      Store s = iterator.next();
      // 번호, 지점명, 주소, 전화번호
      System.out.printf("%d> %s점 %s TEL.%s\n", 
          s.getNo(), s.getName(), s.getAddress(), telFormat(s.getTel()));
    } 
  } 
}
