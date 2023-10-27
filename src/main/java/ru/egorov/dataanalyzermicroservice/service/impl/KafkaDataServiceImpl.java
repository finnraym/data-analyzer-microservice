package ru.egorov.dataanalyzermicroservice.service.impl;

import org.springframework.stereotype.Service;
import ru.egorov.dataanalyzermicroservice.model.Data;
import ru.egorov.dataanalyzermicroservice.service.KafkaDataService;

@Service
public class KafkaDataServiceImpl implements KafkaDataService {
    @Override
    public void handle(Data data) {
        System.out.println("Data object is received: " + data.toString());
    }
}
