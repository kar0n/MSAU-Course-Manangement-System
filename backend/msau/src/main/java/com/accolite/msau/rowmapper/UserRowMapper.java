package com.accolite.msau.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.msau.constants.Attributes;
import com.accolite.msau.models.User;

public class UserRowMapper {

	public static final RowMapper<User> UserRowMapperLambda = (rs, rowNum) ->  {
		
		User user = new User();
		
		user.setUserId(rs.getInt(Attributes.USER_ID));
		user.setType(rs.getString(Attributes.USER_TYPE));
		user.setName(rs.getString(Attributes.USER_NAME));
		user.setEmail(rs.getString(Attributes.USER_EMAIL));
		user.setLocation(rs.getString(Attributes.USER_LOCATION));
		user.setDesignation(rs.getString(Attributes.USER_DESIGNATION));
		user.setImage(rs.getBlob(Attributes.USER_IMAGE));
		user.setCreatedOn(rs.getTimestamp(Attributes.USER_CREATED));
		user.setModifiedOn(rs.getTimestamp(Attributes.USER_MODIFIED));
		
		return user;
		
		
		
	};
}
