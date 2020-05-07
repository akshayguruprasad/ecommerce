package io.indreams.ecommerceuserinfoservice.dao;

import io.indreams.ecommerceuserinfoservice.model.UserDAO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserDAO,String> {
}
