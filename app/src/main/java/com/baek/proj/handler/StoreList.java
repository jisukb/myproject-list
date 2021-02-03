package com.baek.proj.handler;

import com.baek.proj.domain.Store;

public class StoreList {

  private Node first;
  private Node last;
  private int size = 0;

  public void add(Store s) {
    Node node = new Node(s);

    if (last == null) {
      last = node;
      first = node;
    } else {
      last.next = node;
      node.prev = last;
      last = node;
    }
    size++;
  }

  public Store[] toArray() {
    Store[] arr = new Store[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.store;
      cursor = cursor.next;
    }
    return arr;
  }

  public Store get(int storeNo) {
    Node cursor = first;
    while (cursor != null) {
      Store s = cursor.store;
      if (s.getNo() == storeNo) {
        return s;
      }
      cursor = cursor.next;
    }
    return null;
  }

  public void delete(int storeNo) {
    Node cursor = first;
    while (cursor != null) {
      if (cursor.store.getNo() == storeNo) {
        this.size--;
        if (first == last) {
          first = last = null;
          break;
        }
        if (cursor == first) {
          first = cursor.next;
          cursor.prev = null;
        } else {
          cursor.prev.next = cursor.next;
          if (cursor.next != null) {
            cursor.next.prev = cursor.prev;
          }
        }
        if (cursor == last) {
          last = cursor.prev;
        }
        break;
      }
      cursor = cursor.next;
    }
  }

  static class Node {
    Store store;
    Node next;
    Node prev;

    Node(Store s) {
      this.store = s;
    }
  }
}
