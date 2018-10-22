package com.assignment1;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Desktop.getDesktop;

public class ConvertData {
    public void keepData()
    {
        try{

            String[] name = {"Title","Info"};
            //List<Table> data = new ArrayList<Table>();

            ReadData ReadData = new ReadData();

            HSSFWorkbook book = new HSSFWorkbook();
            HSSFSheet sheet = book.createSheet("Trivia");

                //create font
                Font font = book.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                font.setFontHeightInPoints((short)12);

                CellStyle style = book.createCellStyle();
                style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);

            Row row = sheet.createRow(0);

            for(int x=0;x<name.length;x++){
                Cell cell = row.createCell(x);
                cell.setCellValue(name[x]);
                cell.setCellStyle(style);
            }

            int w=1;
            for (Table tables : ReadData.getData()){

                Row rows = sheet.createRow(w++);
                rows.createCell(0).setCellValue(tables.Title);
                rows.createCell(1).setCellValue(tables.Info);
            }

            for(int a=0;a<=24;a++)
                sheet.autoSizeColumn(a);

            FileOutputStream save = new FileOutputStream(new File("Trivia.xls"));
            book.write(save);
            save.flush();
            save.close();
            book.close();

            System.out.println("\nSuccessfully");
        }catch (Exception e){
            System.out.print(e.getStackTrace());
        }
    }

    public static void openExcel() {
        System.out.print("\nOpen excel...");
        try {
            getDesktop().open(new File("Trivia.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
