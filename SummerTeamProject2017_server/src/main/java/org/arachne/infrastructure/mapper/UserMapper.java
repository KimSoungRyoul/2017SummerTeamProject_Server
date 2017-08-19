package org.arachne.infrastructure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.arachne.domain.testvo.User;

@Mapper
public interface UserMapper {

	public List<User> selectList(String id);
	
}
