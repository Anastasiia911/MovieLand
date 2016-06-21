package com.nabivach.movieland.dto.transformer;

import java.util.ArrayList;
import java.util.List;

public class ListTransformer<E, D> implements Transformer<List<E>, List<D>> {

    private final Transformer<E, D> transformer;

    public ListTransformer(Transformer<E, D> transformer) {
        this.transformer = transformer;
    }

    public List<D> transformToDto(List<E> entityList) {
        List<D> dtoList = new ArrayList<>(entityList.size());
        for (E entity : entityList) {
            dtoList.add(transformer.transformToDto(entity));
        }
        return dtoList;
    }
}
