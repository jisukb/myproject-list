package com.baek.proj.handler;

import com.baek.proj.domain.Product;

public class ProductList {

  Node first;
  Node last;
  int size = 0;

  void add(Product p) {
    Node node = new Node(p);

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

  Product[] toArray() {
    Product[] arr = new Product[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.product;
      cursor = cursor.next;
    }
    return arr;
  }

  Product get(int productNo) {
    Node cursor = first;
    while (cursor != null) {
      Product p = cursor.product;
      if (p.no == productNo) {
        return p;
      }
      cursor = cursor.next;
    }
    return null;
  }

  void delete(int productNo) {
    Product product = get(productNo);
    if (product == null) {
      return;
    }

    Node cursor = first;
    while (cursor != null) {
      if (cursor.product == product) {
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

  public boolean exist(String name) {
    Node cursor = first;
    while (cursor != null) {
      Product p = cursor.product;
      if (p.name.equals(name)) {
        return true;
      }
      cursor = cursor.next;
    }
    return false;
  }

  static class Node {
    Product product;
    Node next;
    Node prev;

    Node(Product p) {
      this.product = p;
    }
  }
}
