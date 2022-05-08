package qa.guru.types;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static qa.guru.StreamMethod.getStream;


public class PDFFileTests {

    @Test
    public void numberOfTiketsTest() throws Exception{
        InputStream pdfStr = getStream("types/sample.pdf");
        PDF pdf = new PDF(pdfStr);
        Assertions.assertEquals(4, pdf.numberOfPages,"Number of tickets not equals purchase");
        pdfStr.close();
    }
    @Test
    public void parsingPdfFile() throws Exception{
        InputStream pdfStr = getStream("types/sample.pdf");
        PDF pdf = new PDF(pdfStr);
        assertThat(pdf).containsTextCaseInsensitive("13 июн 2019 12:00");
        pdfStr.close();
    }
}
