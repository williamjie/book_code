package com.irish.dao;
import org.springframework.stereotype.Repository;

import com.irish.model.mongo.User;

/**
 * @author: huangyibo
 * @Date: 2019/1/31 0:12
 * @Description:
 */
@Repository
public class UserMongoDbDao extends MongoDbDao<User> {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}