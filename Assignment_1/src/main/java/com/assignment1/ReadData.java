package com.assignment1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

public class ReadData {

    public static List<Table> getData() {
        try {
            String URL = "https://ms.wikipedia.org/wiki/Malaysia";
            Document doc = Jsoup.connect(URL).get();

            System.out.println("\nRead data from " + URL);
            System.out.println();

            List<Table> result = new ArrayList();

            Elements tittle = doc.select("span.mw-headline#Trivia");

            for (Element TList : doc.select("tr[align]")){

                String Info1 = TList.select("th").text();
                String Info2 = TList.select("td").text();
                    //Elements elements = TList.select("th");
                    //Elements element = TList.select("td");

                    //Integer Num = Integer.valueOf(num.text());
                    //String Info1 = elements.text();
                    //String Info2 = element.text();


                    System.out.printf("%-40s",Info1);
                    System.out.print(" "+ Info2);
                    System.out.println();
                    result.add(new Table(Info1,Info2));


                }return result;
            } catch (IOException e1) {
            e1.printStackTrace();
        }
            return null;
        }
    }
