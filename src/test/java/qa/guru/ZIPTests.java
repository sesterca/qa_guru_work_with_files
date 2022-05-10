package qa.guru;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZIPTests {

    @Test
    public void pdfExtractedFromZipTest() throws Exception{
        try (ZipFile zipFile = new ZipFile(new File("src/test/resources/sample.zip"));) {
            ZipEntry entry = zipFile.getEntry("sample.pdf");
            InputStream pdfStr = zipFile.getInputStream(entry);
            PDF pdf = new PDF(pdfStr);
            assertThat(pdf).containsTextCaseInsensitive("13 июн 2019 12:00");
            Assertions.assertEquals(4, pdf.numberOfPages,"Number of tickets not equals purchase");
        }
    }

    @Test
    public void xlsExtractedFromZipTest() throws Exception{
        try (ZipFile zipFile = new ZipFile(new File("src/test/resources/sample.zip"));){
            ZipEntry entry = zipFile.getEntry("sample.xlsx");
            InputStream xlsStr = zipFile.getInputStream(entry);
            XLS xls = new XLS(xlsStr);
            String executor = xls.excel.getSheetAt(0).getRow(11).getCell(1).getStringCellValue();
            assertEquals("Шибаев Олег Дмитриевич", executor);
        }
    }
    @Test
    public void csvExtractedFromZipTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(new File("src/test/resources/sample.zip"));) {
            ZipEntry entry = zipFile.getEntry("sample.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(zipFile.getInputStream(entry), StandardCharsets.UTF_8));
            List<String[]> csvContent = reader.readAll();
            org.assertj.core.api.Assertions.assertThat(csvContent).hasSize(88);
        }
    }
}
