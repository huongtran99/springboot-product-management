package com.codegym.productmanager.service.user;

import com.codegym.productmanager.model.User;
import com.codegym.productmanager.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
