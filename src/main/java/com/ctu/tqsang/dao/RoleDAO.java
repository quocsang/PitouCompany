package com.ctu.tqsang.dao;

import com.ctu.tqsang.domain.Role;

public interface RoleDAO {
	
	Role findOne(String name);
	
}
