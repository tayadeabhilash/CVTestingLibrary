package com.abhilash.visiontesting;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class JsonLoader {
    public static HashMap<String, String> loadTestCases(String jsonFilePath) {
        HashMap<String, String> expectedOutputMap = new HashMap<>();
        JSONParser parser = new JSONParser();

        try {
            InputStream inputStream = JsonLoader.class.getClassLoader().getResourceAsStream(jsonFilePath);
            InputStreamReader reader = new InputStreamReader(inputStream);
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            Set<String> keys = jsonObject.keySet();
            for (String key : keys) {
                expectedOutputMap.put(key, jsonObject.get(key).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return expectedOutputMap;
    }
}