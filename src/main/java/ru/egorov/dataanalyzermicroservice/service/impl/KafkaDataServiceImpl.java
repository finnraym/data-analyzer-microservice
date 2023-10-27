package ru.egorov.dataanalyzermicroservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.egorov.dataanalyzermicroservice.model.Data;
import ru.egorov.dataanalyzermicroservice.repository.DataRepository;
import ru.egorov.dataanalyzermicroservice.service.KafkaDataService;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final DataRepository dataRepository;
    @Override
    public void handle(Data data) {
        log.info("Data object {} was saved", data);
        dataRepository.save(data);
    }

}
