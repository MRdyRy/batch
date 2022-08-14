package com.rdy.batch.processor;

import com.rdy.batch.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class UserProcessor implements ItemProcessor<UserModel, UserModel> {
    private static final Map<String,String> DEPT_NAME = new HashMap<>();

    public UserProcessor(){
        DEPT_NAME.put("A","TANK");
        DEPT_NAME.put("B","MAGE");
        DEPT_NAME.put("C","MARKSMAN");
    }

    @Override
    public UserModel process(UserModel userModel) throws Exception {
        String depcode = userModel.getDept();
        String deptName = DEPT_NAME.get(depcode);
        userModel.setDept(deptName);
        log.info("processing ......! {}",userModel);
        return userModel;
    }
}
