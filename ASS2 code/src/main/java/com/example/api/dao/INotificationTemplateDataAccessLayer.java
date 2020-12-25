package com.example.api.dao;


import com.example.api.domain.NotificationTemplate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface INotificationTemplateDataAccessLayer extends CrudRepository<NotificationTemplate , Long> {

    List<NotificationTemplate> findAll();
}
