package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.User;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

//public interface UserService extends UserDetailsService {
//
//}

@Service
public interface UserService {

    List<User> getUserByUsername (String username);

//    User saveNewUser(User user) throws RoleNotFoundException;

    List<User> getAllUsers();

    User getUserByID(long id);

    User saveUser(User user);




}
