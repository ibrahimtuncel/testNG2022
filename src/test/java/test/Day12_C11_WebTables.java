package test;

import com.pages.DefaultPage;
import com.pages.HotelRoomPage;
import com.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class Day12_C11_WebTables {
    //    When kullanici application'da HotelRoom sayfasina gider
    // Log in https://www.carettahotel.com/
    // Hotel Management'e Click yapar
    // Hotel Rooms'a Click yapar
//    test method: entireTable() ve tum header'lari yazdir
//    test method: printRows() ve tum row'lari ile 4 row'daki elementi yazdir
//    test method: printCells() ve table body'dek' cells'lerin toplam sayilarini yazdir ve tum cell'leri yazdir
//    test method: printColumns() ve columns'larin toplam sayisini yazdir ve 5. column yazdir
//    test method: printData(int row, int column); Bu method veriline cell'i yazdirmali
//    ornek : printData(2,3); 2. row ve 3 column yazdirmali
    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    HotelRoomPage hotelRoomPage = new HotelRoomPage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
        Thread.sleep(2000);
        //hotel management tıkla
        defaultPage.hotelManagement.click();
        //hotel rooms a tıkla
        defaultPage.hotelRoomsTab.click();
        //add hotelroom a tıkla
        Thread.sleep(1000);
    }

    @Test
    public void entireTable() throws InterruptedException {
        //setUp();
        System.out.println("Tum Tablo");
        System.out.println("Tablo Body");
        //tabloyu cekme
        WebElement tableBody = Driver.getDriver().findElement(By.xpath("//table//tbody"));
        System.out.println(tableBody.getText());
        //tum headerlerı bul
        List<WebElement> tumHeader = Driver.getDriver().findElements(By.xpath("//th"));
        for (WebElement w : tumHeader) {
            System.out.print(w.getText() + " ");
        }
    }

    @Test (groups ="test-group-1")
    public void printRows() {
        List<WebElement> tumRows = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        int satirNumarasi = 1;
        for (WebElement w2 : tumRows) {
            // System.out.println("Satirsayisi:"+satirNumarasi+" "+w2.getText());
            satirNumarasi++;
        }
        //4.row bul
        WebElement row4 = Driver.getDriver().findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("Row 4:" + row4.getText());

        Driver.closeDriver();
    }

    @Test
    public void printCells() {
        List<WebElement> tumCells = Driver.getDriver().findElements(By.xpath("//tbody//td"));
        System.out.println(tumCells.size());
        //tum hucreleri yasdir
        int cellnumarasi = 1;
        for (WebElement w3 : tumCells) {
            System.out.println(cellnumarasi + ".cell: " + w3.getText());
            cellnumarasi++;
        }
        Driver.closeDriver();
    }

    @Test (groups ="test-group-1")
    public void printColumns() {
        List<WebElement> tumHeader = Driver.getDriver().findElements(By.xpath("//th"));
        //Driver.getDriver().findElements(By.xpath("//table//tbody//tr[1]//td"));
        int columnSayisi = tumHeader.size();
        System.out.println(columnSayisi + " tane column header vardır.");
        //5.column yasdir.
        List<WebElement> column5 = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[5]"));
        System.out.println("sütun sayisi: " + column5.size());
        for (WebElement w4 : column5) {
            System.out.println("5.column= " + w4.getText());

        }
        Driver.closeDriver();
    }
    //    test method: printData(int row, int column); Bu method veriline cell'i yazdirmali
    //ornek : printData(2,3); 2. row ve 3 column yazdirmali

    @Test
    //public void pd(){
    public void printData(int raw, int column) {
       // int raw;
       // int column;
        String sonuc;
        printData(2, 3);

        sonuc=Driver.getDriver().findElement(By.xpath("//table//tbody//tr[" + raw+ "]//td[" + column + "]")).getText();
    }
/*
//Bütün tablonun her satırındaki değerleri sırasıyla getirme
        List<WebElement> satirlar = Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));
        int satirsayisi = satirlar.size();
        System.out.println("Kaç satır var: "+ satirsayisi);

        for (int i=1; i<=satirsayisi; i++) {
            List<WebElement> sutunlar = Driver.getDriver().findElements(By.xpath("//table//tbody//tr[" + i + "]/td"));
            int sutunsayisi = sutunlar.size();
            System.out.println("Kaç sütun var: " + sutunsayisi);
            for (int y = 1; y <= sutunsayisi; y++){
                //System.out.println(Driver.getDriver().findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + y + "]")).getText());
        }

            System.out.println(Driver.getDriver().findElement(By.xpath("//table//tbody//tr[" + raw + "]//td[" + column + "]")).getText());
        }

        //if (i == raw && y == column) {
            //System.out.println(Driver.getDriver().findElement(By.xpath("//table//tbody//tr[" + raw + "]//td[" + column + "]")).getText());
        //}


    }
    }

 */
    /*
        public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



        public List<Map<String, String>> getDataList() {
        // tum columns'lari getirir
        List<String> columns = getColumnsNames();
        // method will return this
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 1; i < rowCount(); i++) {
            // her bir row getirir
            Row row = workSheet.getRow(i);
            // column ve value kullanarak Row'dan Map olusturur
            // key=column, value=cell
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }
    */

    /*
        //    Ulke ve baskent key-value ciftlerini map object olarak yazdir
        Map<String,String>dunyaBaskentleri=new HashMap<>();
        int ulkeColumn=0;
        int baskentColumn=1;

        row numarasi 1 den baslar cunku header 0  indekstedir.
        en sondaki row indeksi LastRowNum veya sheet.getLastRowNum()+1;
        ABD:sheet.getRow(1).getCell(0);
        Fransa:sheet.getRow(2).getCell(0);

        for(int rowNumarasi=1;rowNumarasi<rowSayisi;rowNumarasi++){
        String ulke= sheet.getRow(rowNumarasi).getCell(ulkeColumn).toString();
        String baskent=sheet.getRow(rowNumarasi).getCell(baskentColumn).toString();
        //System.out.println(ulke);
        //System.out.println(baskent);

        dunyaBaskentleri.put(ulke,baskent);//map e ulke ve baskentler eklendi
        }
        System.out.println(dunyaBaskentleri);
*/
        }

