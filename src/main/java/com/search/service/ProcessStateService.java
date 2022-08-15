package com.search.service;

import com.search.model.request.StateRequest;

import java.util.List;

public interface ProcessStateService {

    boolean storeSearchHistory(StateRequest state);

    List<String> returnSearchHistory();

}
