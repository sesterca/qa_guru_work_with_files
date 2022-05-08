package qa.guru;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import qa.guru.json.Item;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static qa.guru.StreamMethod.getStream;

public class JSONTests {

    @Test
    public void jsonCommonTest() throws Exception{
        Gson gson = new Gson();
        try(InputStream jsonStr = getStream("sample.json");){
            String json = new String(jsonStr.readAllBytes(), StandardCharsets.UTF_8);
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            System.out.println(jsonObject.get("info").toString());
            assertThat(jsonObject.get("info").toString().contains("Diploma"));
         }
    }
    @Test
    public void jsonTypeTest() throws Exception{
        Gson gson = new Gson();
        try(InputStream jsonStr = getStream("sample.json");){
            String json = new String(jsonStr.readAllBytes(), StandardCharsets.UTF_8);
            Item item = gson.fromJson(json, Item.class);
            if(item.name == "Отмена заказа"){
                Assertions.assertEquals("PUT", item.request.method);}
        }
    }
}
