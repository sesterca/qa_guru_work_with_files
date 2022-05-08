package qa.guru.types;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class  DownloadFileTests {

    @Test
    public void downloadFileTest() throws Exception {
        Selenide.open("http://abit.mstu.edu.ru/apply/");
        File application = $(byText("Скачать")).download();
        InputStream appstr = new FileInputStream(application);
        byte[] applContent = appstr.readAllBytes();
    }
}
