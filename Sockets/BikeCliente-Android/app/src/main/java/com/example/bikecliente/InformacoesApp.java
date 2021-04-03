package com.example.bikecliente;

import android.app.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class InformacoesApp extends Application {
    public Socket socket;
    public ObjectInputStream in;
    public ObjectOutputStream out;

}
