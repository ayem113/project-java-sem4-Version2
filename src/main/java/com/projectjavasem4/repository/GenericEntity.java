package com.projectjavasem4.repository;

public interface GenericEntity<T> {

    // update current instance with provided data
    void update(T source);

    Long getId();

    // based on current data create new instance with new id
    T createNewInstance();

}