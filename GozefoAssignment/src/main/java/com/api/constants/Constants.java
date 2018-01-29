package com.api.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chetan on 29/1/18.
 */
public class Constants {
    public static final Map<String, Integer> CATEGORY_MAP = new HashMap<String,Integer>();
    public static final Map<String, Integer> SUB_CATEGORY_MAP  = new HashMap<String,Integer>();
    public static final String SOFAS = "sofas";
    public static final String BEDS = "beds";
    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;
    static {
        CATEGORY_MAP.put("furniture",1);
        SUB_CATEGORY_MAP.put(SOFAS,1);
    }
}
