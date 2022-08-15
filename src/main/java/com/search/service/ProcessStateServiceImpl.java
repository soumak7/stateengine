package com.search.service;

import com.search.configuration.RedisServiceMapImpl;
import com.search.model.request.StateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessStateServiceImpl implements ProcessStateService{

    @Autowired
    RedisServiceMapImpl redisServiceMap;

    @Override
    public boolean storeSearchHistory(StateRequest state) {

        List<String> filteredList = state.stateList.stream().distinct().collect(Collectors.toList());

        List<String> list = redisServiceMap.getQueue("SEARCH");

        if(list.isEmpty()) {
            for(String each : filteredList)
                redisServiceMap.rightPushIntoQueue("SEARCH",each);
            return true;
        }

        for(String each : filteredList) {
            if(!list.contains(each))
                redisServiceMap.rightPushIntoQueue("SEARCH", each);
        }
        return true;

    }

    @Override
    public List<String> returnSearchHistory() {
        return redisServiceMap.getQueue("SEARCH");
    }
}
