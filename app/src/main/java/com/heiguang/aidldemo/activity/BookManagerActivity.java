package com.heiguang.aidldemo.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.heiguang.aidldemo.R;
import com.heiguang.aidldemo.aidl.Book;
import com.heiguang.aidldemo.aidl.BookManagerService;
import com.heiguang.aidldemo.aidl.IBookManager;

import java.util.List;

public class BookManagerActivity extends AppCompatActivity {

    private static final String TAG = "BookManagerActivity";

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager bookManager = IBookManager.Stub.asInterface(service);

            try {
                List<Book> list = bookManager.getBookList();
                Log.i(TAG, "书籍列表类型" + list.getClass().getCanonicalName());
                Log.i(TAG, "书籍类表" + list.toString());

                Book newBook = new Book(3, "PHP");
                bookManager.addBook(newBook);
                List<Book> newList = bookManager.getBookList();
                Log.i(TAG, "书籍类表" + newList.toString());

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmanager);

        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }
}
