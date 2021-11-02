package com.codegym.productmanager.service.role;

import com.codegym.productmanager.model.Role;
import com.codegym.productmanager.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}