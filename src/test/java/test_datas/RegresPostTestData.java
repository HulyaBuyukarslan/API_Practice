package test_datas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegresPostTestData {

    public static Map<String,String> requestBodyMethod(String name, String job){
        Map<String,String> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("job",job);

        return requestBody;
    }

    public static Map<String, String > expectedDataMethod(String name,String job, String id, String createdAt) {


        Map<String,String > expectedBody = new HashMap<>();
        expectedBody.put("name",name);
        expectedBody.put("job",job);
        expectedBody.put("id",id);
        expectedBody.put("createdAt",createdAt);


     return expectedBody;

    }

//---------- JSONObject Kullanımı-------------

    public static JSONObject requestBodyMethodJO(String name, String job){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("job",job);

        return requestBody;
    }


    public static JSONObject expectedDataMethodJO(String name,String job, String id, String createdAt) {


       JSONObject expectedBody = new JSONObject();
        expectedBody.put("name",name);
        expectedBody.put("job",job);
        expectedBody.put("id",id);
        expectedBody.put("createdAt",createdAt);


        return expectedBody;

    }









}
