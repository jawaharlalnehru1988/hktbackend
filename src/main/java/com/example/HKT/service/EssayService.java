package com.example.HKT.service;

import com.example.HKT.entity.Essay;
import com.example.HKT.repository.EssayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EssayService {
    @Autowired
    private EssayRepository essayRepository;

    public List<Essay> getAllEssays(){
        return essayRepository.findAll();
    }

    public Essay getEssayById(int id){
        return essayRepository.findById(id).orElse(null);
    }

    public Essay createEssay(Essay essay){
        return essayRepository.save(essay);
    }

    public Essay updateEssay(int id, Essay essayDetails){
        Essay essay = essayRepository.findById(id).orElse(null);
        if(essay != null) {
            essay.setTitle(essayDetails.getTitle());
            essay.setAuthorName(essayDetails.getAuthorName());
            essay.setEssayContent(essayDetails.getEssayContent());
            return essayRepository.save(essay);
        }
        return null;
    }

    public void deleteEssay(int id){
        essayRepository.deleteById(id);
    }

    public Map<String, Object> findMaxMinFrequency(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Calculate the frequency of each element in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = Integer.MIN_VALUE;
        int minFrequency = Integer.MAX_VALUE;
        int maxFreqElement = arr[0];
        int minFreqElement = arr[0];

        // Find the elements with the maximum and minimum frequencies
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                maxFreqElement = key;
            }

            if (frequency < minFrequency) {
                minFrequency = frequency;
                minFreqElement = key;
            }
        }

        // Prepare the result
        Map<String, Object> result = new HashMap<>();
        result.put("maxFrequencyElement", maxFreqElement);
        result.put("maxFrequency", maxFrequency);
        result.put("minFrequencyElement", minFreqElement);
        result.put("minFrequency", minFrequency);

        return result;
    }
}
