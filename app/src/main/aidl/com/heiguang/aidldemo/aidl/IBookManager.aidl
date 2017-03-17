// IBookManager.aidl
package com.heiguang.aidldemo.aidl;

import com.heiguang.aidldemo.aidl.Book;
import com.heiguang.aidldemo.aidl.IOnNewBookArrivedListener;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);

    void registerListener(IOnNewBookArrivedListener listener);
    void unregisterListener(IOnNewBookArrivedListener listener);
}
