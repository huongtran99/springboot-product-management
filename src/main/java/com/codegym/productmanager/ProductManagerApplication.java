package com.codegym.productmanager;

import com.codegym.productmanager.model.Role;
import com.codegym.productmanager.model.User;
import com.codegym.productmanager.service.role.IRoleService;
import com.codegym.productmanager.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ProductManagerApplication {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(ProductManagerApplication.class, args);
	}

	@PostConstruct
	public void init() {
		List<User> users = (List<User>) userService.findAll();
		List<Role> roleList = (List<Role>) roleService.findAll();
		if (roleList.isEmpty()) {
			Role roleAdmin = new Role();
			roleAdmin.setId(1L);
			roleAdmin.setName("ROLE_ADMIN");
			roleService.save(roleAdmin);
			Role roleUser = new Role();
			roleUser.setId(2L);
			roleUser.setName("ROLE_USER");
			roleService.save(roleUser);
		}
		if (users.isEmpty()) {
			User admin = new User();
			Set<Role> roles = new HashSet<>();
			Role roleAdmin = new Role();
			roleAdmin.setId(1L);
			roleAdmin.setName("ROLE_ADMIN");
			roles.add(roleAdmin);
			admin.setUsername("admin");
			admin.setPassword("123456");
			admin.setFullName("HuongTran");
			admin.setRoles(roles);
			userService.save(admin);
		}
	}


}
