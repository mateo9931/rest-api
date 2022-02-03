package edu.eci.ieti.service;

import java.util.List;

import edu.eci.ieti.data.User;
import edu.eci.ieti.dto.UserDTO;

public interface UserService
{
    User create( User user );

    User findById( String id );
    
    List<User> getAll();

    boolean deleteById( String id );

    User update( UserDTO userDto, String userId );
} 