package com.adiye.happyhome.coreapi.exception;

/**
 * Created by nyeluri on 1/16/17.
 */
public class EntityNotFoundException extends RuntimeException {

    String entity;
    long timestamp;

    public EntityNotFoundException(String entity, long timestamp){
        this.entity = entity;
        this.timestamp = timestamp;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
