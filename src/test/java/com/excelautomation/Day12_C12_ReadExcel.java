package com.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExcelUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day12_C12_ReadExcel {
        /*
    Import the apache poi dependency in your pom file
    resources package olustur > java altinda acilmali (java'ya sag tikla ve dosyayi olustur)
    Add the excel file on the resources folder
    Yeni package olustur: excelautomation
    Yeni class olustur : ReadExcel
    test method olustur: readExcel()
    Dosyanin adresini String olarak bir konteynira koy
    dosyayi ac
    fileinputstream kullanarak workbook'u ac
    ilk worksheet'i ac
    ilk row'a git
    ilk row'daki ilk cell'e git ve yazdir
    ilk row'daki ikinci cell'e git ve yazdir
    2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
    3rd row'daki 2nd cell-chain the row and cell
    row sayisini bul
    Kullanilan row sayisini bul
    Ulke ve baskent key-value ciftlerini map object olarak yazdir
    */

    @Test
    public void readExcel() throws IOException {
    //Dosyanin adresini String olarak bir konteynira koy
        String path = "../testNG2022/src/test/java/resources/Baskent.xlsx";
    //dosyayi ac
        FileInputStream fileInputStream = new FileInputStream(path);
        //fileinputstream kullanarak workbook'u ac;
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //ilk worksheet'i ac
        Sheet sheet =  workbook.getSheetAt(0); //sheet sayfalari '0.' index'ten baslar
        //ilk row'a git
        Row ilkRow =sheet.getRow(0);// row'lar index o'dan baslar

        //ilk row'daki ilk cell'e git ve yazdir
        Cell ilkCell =  ilkRow.getCell(0);// cell indexi 'o'dan baslar
        System.out.println(ilkCell);
        // ilk row'daki ikinci cell'e git ve yazdir
        Cell ikinciCell=ilkRow.getCell(1);
        System.out.println(ikinciCell);
        //2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
        //Row ikinciRow=sheet.getRow(1);
        //Cell ikibirCell=ikinciRow.getCell(0);
        Cell ikibirCell=sheet.getRow(1).getCell(0);
        System.out.println(ikibirCell);
        Assert.assertTrue(ikibirCell.toString().equals("ABD"));
        boolean esitMi=ikibirCell.toString().equals("ABD");
        Assert.assertTrue(esitMi);

        //2.row 2.cell
        Cell ikiikiCell=sheet.getRow(1).getCell(1);
        System.out.println(ikiikiCell);
        //3rd row'daki 2nd cell-chain the row and cell
        Cell ucikiCell=sheet.getRow(2).getCell(1);
        System.out.println(ucikiCell);
        //row sayisini bul
        int rowSayisi=sheet.getLastRowNum()+1;
        System.out.println(rowSayisi);//11
        //Kullanilan row sayisini bul
        int kullanılanRowSayisi=sheet.getPhysicalNumberOfRows();
        System.out.println(kullanılanRowSayisi);//11

        //    Ulke ve baskent key-value ciftlerini map object olarak yazdir
        Map<String,String>dunyaBaskentleri=new HashMap<>();
        int ulkeColumn=0;
        int baskentColumn=1;
        /*
        row numarasi 1 den baslar cunku header 0  indekstedir.
        en sondaki row indeksi LastRowNum veya sheet.getLastRowNum()+1;
        ABD:sheet.getRow(1).getCell(0);
        Fransa:sheet.getRow(2).getCell(0);
         */
        for(int rowNumarasi=1;rowNumarasi<rowSayisi;rowNumarasi++){
           String ulke= sheet.getRow(rowNumarasi).getCell(ulkeColumn).toString();
           String baskent=sheet.getRow(rowNumarasi).getCell(baskentColumn).toString();
            //System.out.println(ulke);
            //System.out.println(baskent);

            dunyaBaskentleri.put(ulke,baskent);//map e ulke ve baskentler eklendi
        }
        System.out.println(dunyaBaskentleri);

    }
    @Test
    public void excelUtilDemo(){
        String path = "../testNG2022/src/test/java/resources/Baskent.xlsx";
        String sheetName="Sayfa1";

        ExcelUtil excelUtil=new ExcelUtil(path,sheetName);
        //ExcelUtil de metotları cagirabiliris

        System.out.println(excelUtil.getDataList());
        //map olarak list döner

        System.out.println(excelUtil.columnCount());
        //sütun sayisi

        System.out.println(excelUtil.rowCount());
        //satir sayisi

        System.out.println(excelUtil.getCellData(5,1));
        //hücre cagirma

        System.out.println(excelUtil.getColumnsNames());
    }
}