package edu.eci.ieti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.eci.ieti.data.User;
import edu.eci.ieti.dto.UserDTO;

public class UserServiceimpl implements UserService {
	UserDTO newuser = new UserDTO();
	private HashMap<String, User> hash = new HashMap<String,User>();

	@Override
	public User create(User user) {
		
		user.setName(user.getName());
		user.setEmail(user.getEmail());
		user.setLastName(user.getLastName());
		hash.put(user.getId(), user);
		return user;
		
	}

	@Override
	public User findById(String id) {
		User usuarioID = new User();
		List<User> allusers = getAll();
		for (User users : allusers) {
				if (users.getId().equals(id)) {
					usuarioID.setId(users.getId());
					usuarioID.setEmail(users.getEmail());
					usuarioID.setLastName(users.getLastName());
					usuarioID.setName(users.getName());
					usuarioID.setCreatedAt(users.getCreatedAt());
				}
			}
		return usuarioID ;
		}

		
		

	@Override
	public List<User> getAll() {
		List<User> arrayusers = new ArrayList<User>();
		for (User usersinhash : hash.values()) {
			arrayusers.add(usersinhash);
		};
		return arrayusers;
		
	}

	@Override
	public boolean deleteById(String id) {
		hash.remove(id);
		return hash.containsKey(id);
		}
		

	@Override
	public User update(UserDTO userDto, String userId) {
		User olduser= findById(userId);
		olduser.setName(userDto.getName()); 
		olduser.setEmail(userDto.getEmail()); 
		olduser.setLastName(userDto.getLastName());
		hash.put(olduser.getId(), olduser);
		return olduser;
	}

}
