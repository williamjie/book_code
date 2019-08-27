package com.irish.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.irish.dao.UserMongoDbDao;
import com.irish.model.mongo.User;

@Service
public class UserMongoDbService {
    private static final Logger logger = LoggerFactory.getLogger(UserMongoDbService.class);

    @Autowired
    private UserMongoDbDao  userMongoDbDao;

    /**
     * 保存对象
     * @param id 
     *
     * @param book
     * @return
     */
    public void  saveObj(Long id) {
        logger.info("--------------------->[MongoDB save start]");
        User user = new User();
        user.setId(id);
        user.setAge(21);
        user.setUserName("zhangsan");
        user.setCreateTime(new Date().getTime());
        userMongoDbDao.save(user);
        logger.info("--------------------->[MongoDB save end]");
    }

    
    public  void deleteById() {
    	userMongoDbDao.deleteById(200L);
    }
    
    
    public void listUser() {
    	User user = new User();
    	user.setUserName("zhangsan");
    	List<User> users = userMongoDbDao.getPage(user, 1, 3);
    	users.forEach((x) -> {
			System.out.println(x.getId());
		});
    }
    
}