package ru.egorov.dataanalyzermicroservice.service;

import ru.egorov.dataanalyzermicroservice.model.Data;

public interface KafkaDataService {

    void handle(Data data);
}
