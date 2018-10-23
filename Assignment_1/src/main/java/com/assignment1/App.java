package com.assignment1;

public class App {

    public static void main(String args[]){
        try{

            ReadData read = new ReadData();
            read.getData();

            ConvertData keep = new ConvertData();
            keep.keepData();

            ConvertData open = new ConvertData();
            open.openExcel();

            Thread.sleep(3000);

            System.out.println("\nFinished convert");
        }catch (Exception l){
            l.printStackTrace();
        }
    }
}
