package com.lingxin.cloud.message.app.service.impl;

import com.lingxin.cloud.app.message.model.Message;
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
    //@CachePut(value = "findById")
    //@CacheEvict(value = "findAll")
    public Message save(Message message) {
        Message msg = messageRepository.save(message);
        return msg;
    }

    @Override
    //@CachePut(value = "findById")
    //@CacheEvict(value = "findAll")
    public Message update(Message message) {
        Message msg = messageRepository.save(message);
        return msg;
    }

    @Override
    //@CacheEvict(value = {"findAll","messageUpdate","messageSave","findById"})
    public void delete(String id) {
        messageRepository.delete(id);
    }

    @Override
    //@Cacheable(value = "findById")
    public Message findById(String id) {
        return messageRepository.findOne(id);
    }

    @Override
    //@Cacheable(value = "findAll")
    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}
