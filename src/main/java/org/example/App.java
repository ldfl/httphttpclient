package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    int i = 10;
    public Bpp am(Bpp b) {
        b.j = 2;
        // 大可不必返回
        return b;
    }
    class nn{
        public nn(){}
        public App abc() {
            //System.out.println(App.this.nn.this.i);
            return App.this;
        }
    }
    public  App t() {
        return App.this;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        App.this.i = i;
    }

    public static void main(String[] args ) throws IOException {
        FileInputStream f = new FileInputStream("e:/t.txt");
        FileOutputStream file = new FileOutputStream("E:/fans.txt");
        byte[] b = new byte[3];
        int len;
        while ((len = f.read(b)) != -1) {
            file.write(b,0,len);
        }
        // 不刷新则没数据
        file.flush();
        file.close();
        f.close();
    }
}
class Bpp{
    int j = 6;
}
