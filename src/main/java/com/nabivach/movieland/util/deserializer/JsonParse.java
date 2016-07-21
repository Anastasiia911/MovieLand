package com.nabivach.movieland.util.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JsonParse {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonParse.class);
    private ObjectMapper mapper = new ObjectMapper();

    public <DTO> DTO parseJson(String json, Class<DTO> clazz) throws IOException {
        LOGGER.debug("Starting parsing json", json);
        return mapper.readValue(json, clazz);
    }

    public <DTO> List<DTO> parseJsonList(String json, Class<DTO> clazz) throws IOException {
        LOGGER.debug("Starting parsing JsonList", json);
        return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}
