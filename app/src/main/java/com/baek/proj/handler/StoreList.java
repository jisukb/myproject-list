package com.baek.proj.handler;

import com.baek.proj.domain.Store;

public class StoreList {

  Node first;
  Node last;
  int size = 0;

  void add(Store s) {
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

  Store[] toArray() {
    Store[] arr = new Store[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.store;
      cursor = cursor.next;
    }
    return arr;
  }

  Store get(int storeNo) {
    Node cursor = first;
    while (cursor != null) {
      Store s = cursor.store;
      if (s.no == storeNo) {
        return s;
      }
      cursor = cursor.next;
    }
    return null;
  }

  void delete(int storeNo) {
    Store store = get(storeNo);

    if (store == null) {
      return;
    }

    Node cursor = first;
    while (cursor != null) {
      if (cursor.store == store) {
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
