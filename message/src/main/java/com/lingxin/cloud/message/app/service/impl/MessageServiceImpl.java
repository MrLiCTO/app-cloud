package com.lingxin.cloud.message.app.service.impl;

import com.lingxin.cloud.message.app.model.Message;
import com.lingxin.cloud.message.app.repository.MessageRepository;
import com.lingxin.cloud.message.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr_Li on 2016/9/2.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void update(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void delete(String id) {
        messageRepository.delete(id);
    }

    @Override
    public Message findById(String id) {
        return messageRepository.findOne(id);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}
