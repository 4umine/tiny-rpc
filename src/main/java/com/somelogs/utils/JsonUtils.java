package com.somelogs.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.lang.reflect.Type;

/**
 * JSON util
 *
 * @author LBG - 2017/12/13 0013
 */
public class JsonUtils {

    private JsonUtils() {}

    private static ObjectMapper mapper = new ObjectMapper();


    /**********************Serialize**********************/

    public static String object2JSONString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Serialize Object to JSON failed" , e);
        }
    }


    /**********************Deserialize**********************/

    @Deprecated
    public static <T> T readValue(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Deserialize from JSON failed.", e);
        }
    }

    public static <T> T readValue(String json, TypeReference<T> typeReference) {
        try {
            return mapper.readValue(json, typeReference);
        } catch (Exception e) {
            throw new RuntimeException("Deserialize from JSON failed.", e);
        }
    }

    public static <T> T readValue(String json, Type genericType) {
        try {
            return mapper.readValue(json, TypeFactory.defaultInstance().constructType(genericType));
        } catch (Exception e) {
            throw new RuntimeException("Deserialize from JSON failed.", e);
        }
    }
}
