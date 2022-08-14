package com.rdy.batch.writer;

import com.rdy.batch.model.UserModel;
import com.rdy.batch.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserWriter implements ItemWriter<UserModel> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserWriter(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends UserModel> list) throws Exception {
        log.info("writting.....! {}",list);
        userRepository.saveAll(list);
    }
}
