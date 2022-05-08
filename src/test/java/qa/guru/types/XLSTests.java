package qa.guru.types;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static qa.guru.StreamMethod.getStream;

public class XLSTests {

    @Test
    public void xlsExecutorTest() throws Exception {
        InputStream xlsStr = getStream("types/sample.xlsx");
        XLS xls = new XLS(xlsStr);
        String executor = xls.excel.getSheetAt(0).getRow(11).getCell(1).getStringCellValue();
        assertEquals("Шибаев Олег Дмитриевич", executor);
        xlsStr.close();
    }
}