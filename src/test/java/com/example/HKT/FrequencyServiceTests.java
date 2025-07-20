package com.example.HKT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FrequencyServiceTests {
    @Autowired
    private EssayService essayService;

    @Test
    void testFindMaxMinFrequency(){
        int[] arr = {3, 2, 3, 2, 4, 3};
        Map<String, Object> result = essayService.findMaxMinFrequency(arr);
        assertNotNull(result);
        assertEquals(3, result.get("maxFrequencyElement"));
        assertEquals(3, result.get("maxFrequency"));
        assertEquals(4, result.get("minFrequencyElement"));
        assertEquals(1, result.get("minFrequency"));
    }
}
