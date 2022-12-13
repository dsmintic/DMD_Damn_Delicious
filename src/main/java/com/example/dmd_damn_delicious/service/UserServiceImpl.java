package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.User;
import com.example.dmd_damn_delicious.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override
    public List<User> getUserByUsername(String username) {
        return userRepository.findByUsernameContaining(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(long id) {
        Optional<User> optional = this.userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }else{
            throw new RuntimeException("User with id: " + id + " is not found");
        }
        return user;
    }

    @Override
    public User saveUser(User user){
        user.setPassword(user.getPassword());
        return this.userRepository.save(user);
    }

    @Override
    public void deletePersonById(long id) {
        userRepository.deleteById(id);
    }


//    @Override
//    public User saveNewUser(User user) throws RoleNotFoundException {
//        System.err.println("SaveNewUser: " + user);
//
//        user.setPassword(this.bcryptEncoder.encode(user.getPassword()));
//
//        Optional<Authority> optionalAuthority = this.authorityRepository.findByAuthority("ROLE_USER");
//
//        System.err.print("Optional Authority: " + optionalAuthority);
//
//        if (optionalAuthority.isPresent()) {
//
//            Authority authority = optionalAuthority.get();
//            user.setAuthority(authority);
//            System.err.println("blogUser after Roles: " + user);
//
//            return this.userRepository.saveAndFlush(user);
//
//        } else {
//            throw new RoleNotFoundException("Default role not found for blog user with username " + user.getUsername());
//        }
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUsername(username);
//        if (user.isPresent()) {
//            return user.get();
//        } else {
//            throw new UsernameNotFoundException("No user found with username " + username);
//        }
//    }
}
