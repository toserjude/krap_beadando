package uni.eszterhazy.krap.dao.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import uni.eszterhazy.krap.model.Auto;

import java.io.IOException;

public class AutoAdapter {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public static Auto dbObjectToAuto(DBObject auto){
        try {
            Auto obj = mapper.readValue(auto.toString(), Auto.class);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DBObject autoToDBObject(Auto auto){
        String autoString= "";
        try {
            autoString = mapper.writeValueAsString(auto);
            BasicDBObject obj = mapper.readValue(autoString, BasicDBObject.class);
            return obj;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BasicDBObject();
    }
}
