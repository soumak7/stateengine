package com.search.configuration;

import java.util.List;

public interface RedisServiceMap {

    List<String> getQueue(String queue);

    void pushIntoQueue(String queue, String item);

    String popFromQueue(String queue);

    String peekFromQueue(String queue);

    void rightPushIntoQueue(String queue, String item);
}
