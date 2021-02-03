package com.baek.proj.handler;

import com.baek.proj.domain.Employee;

public class EmployeeList {

  private Node first;
  private Node last;
  private int size = 0;

  public void add(Employee e) {
    Node node = new Node(e);

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

  public Employee[] toArray() {
    Employee[] arr = new Employee[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.employee;
      cursor = cursor.next;
    }
    return arr;
  }

  public Employee get(int employeeNo) {
    Node cursor = first;
    while (cursor != null) {
      Employee e = cursor.employee;
      if (e.getNo() == employeeNo) {
        return e;
      }
      cursor = cursor.next;
    }
    return null;
  }

  public void delete(int employeeNo) {
    Node cursor = first;
    while (cursor != null) {
      if (cursor.employee.getNo() == employeeNo) {
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
      Employee e = cursor.employee;
      if (e.getName().equals(name)) {
        return true;
      }
      cursor = cursor.next;
    }
    return false;
  }

  static class Node {
    Employee employee;
    Node next;
    Node prev;

    Node(Employee e) {
      this.employee = e;
    }
  }
}
