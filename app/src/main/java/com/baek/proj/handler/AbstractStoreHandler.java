package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Store;

public abstract class AbstractStoreHandler implements Command {

  protected List<Store> storeList;

  public AbstractStoreHandler(List<Store> storeList) {
    this.storeList = storeList;
  }

  protected String telFormat(String tel) {
    if(tel.length() == 10) {  
      return tel.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
    } else if (tel.length() == 11) { 
      return tel.replaceFirst("(^[0-9]{3})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
    } else {
      return tel.replaceFirst("(^02)([0-9]{3})([0-9]{4})$", "$1-$2-$3"); 
    }
  }

  protected Store findByNo(int storeNo) {
    Store[] list = storeList.toArray(new Store[storeList.size()]);
    for (Store s : list) {
      if (s.getNo() == storeNo) {
        return s;
      }
    }
    return null;
  }
}
