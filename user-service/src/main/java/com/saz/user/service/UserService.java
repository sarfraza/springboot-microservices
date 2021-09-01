package com.saz.user.service;

import com.saz.user.entity.User;
import com.saz.user.repository.UserRepository;
import com.saz.user.vo.Department;
import com.saz.user.vo.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        log.info("inside saveUser() of UserService..");
        return userRepository.save(user);
    }

    public UserResponse getUserById(Long userId){
        log.info("inside getUserById() of UserService..");
        UserResponse userResponse = new UserResponse();
        User user = userRepository.findByUserId(userId);
        userResponse.setUser(user);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        userResponse.setDepartment(department);
        return userResponse;
    }
}
