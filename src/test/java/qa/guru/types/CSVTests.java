package qa.guru.types;

import com.opencsv.CSVReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CSVTests {

    @Test
    public void csvTest() throws Exception{
        try (InputStream csvStr = getClass().getClassLoader().getResourceAsStream("types/sample.csv");
             CSVReader reader = new CSVReader(new InputStreamReader(csvStr, StandardCharsets.UTF_8))) {
            List<String[]> csvContent = reader.readAll();
            Assertions.assertThat(csvContent).hasSize(88);
        }
    }
}
