package com.baek.util;

public interface ObjectFactory<T> {
  T create(String csvStr);
}
