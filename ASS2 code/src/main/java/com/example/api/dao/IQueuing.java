package com.example.api.dao;

import com.example.api.domain.NotificationTemplate;
import com.example.api.domain.Queuing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IQueuing extends CrudRepository<Queuing , Long> {
    List<Queuing> findAll();
}
