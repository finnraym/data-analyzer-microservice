package ru.egorov.dataanalyzermicroservice.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;
import ru.egorov.dataanalyzermicroservice.config.LocalDataTimeDeserializer;
import ru.egorov.dataanalyzermicroservice.model.Data;
import ru.egorov.dataanalyzermicroservice.service.KafkaDataReceiver;
import ru.egorov.dataanalyzermicroservice.service.KafkaDataService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaDataReceiverImpl implements KafkaDataReceiver {

    private final KafkaReceiver<String, Object> receiver;
    private final LocalDataTimeDeserializer localDataTimeDeserializer;
    private final KafkaDataService kafkaDataService;

    @PostConstruct
    private void init() {
        fetch();
    }
    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, localDataTimeDeserializer)
                .create();

        receiver.receive()
                .subscribe(r ->{
                    Data data = gson.fromJson(r.value().toString(), Data.class);
                    kafkaDataService.handle(data);
                    r.receiverOffset().acknowledge();
                });

    }
}
