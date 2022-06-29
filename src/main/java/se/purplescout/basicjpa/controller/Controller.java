package se.purplescout.basicjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface Controller<T> {
    @GetMapping(path = "/{id}")
    T getById(@PathVariable("id") Long id);

    @PostMapping
    void persist(T t);
}
