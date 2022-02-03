package edu.eci.ieti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.ieti.data.User;
import edu.eci.ieti.dto.UserDTO;
@Service
public interface UserService
{
    User create( User user );

    User findById( String id );
    
    List<User> getAll();

    boolean deleteById( String id );

    User update( UserDTO userDto, String userId );
} 