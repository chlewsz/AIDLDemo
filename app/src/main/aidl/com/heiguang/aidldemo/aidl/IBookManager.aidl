// IBookManager.aidl
package com.heiguang.aidldemo.aidl;

import com.heiguang.aidldemo.aidl.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
