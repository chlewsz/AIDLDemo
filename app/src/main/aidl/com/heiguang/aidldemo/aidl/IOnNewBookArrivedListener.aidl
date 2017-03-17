// IOnNewBookArrivedListener.aidl
package com.heiguang.aidldemo.aidl;

import com.heiguang.aidldemo.aidl.Book;

// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {

    void onNewBookArrived(in Book newBook);
}
