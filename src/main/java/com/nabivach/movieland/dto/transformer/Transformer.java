package com.nabivach.movieland.dto.transformer;

/**
 * Created by anabivach on 17/06/2016.
 */
public interface Transformer<E, D> {

    D transformToDto(E entity);
}
