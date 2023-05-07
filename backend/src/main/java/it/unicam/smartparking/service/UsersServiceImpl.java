package it.unicam.smartparking.service;

import it.unicam.smartparking.dto.LoginUserDto;
import it.unicam.smartparking.dto.UserDto;
import it.unicam.smartparking.dto.UsersDto;
import it.unicam.smartparking.model.Permissions;
import it.unicam.smartparking.model.Roles;
import it.unicam.smartparking.model.Users;
import it.unicam.smartparking.repository.RolesRepository;
import it.unicam.smartparking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = (List<Users>) usersRepository.findAll();

        List<UsersDto> usersDtos = new ArrayList<>();
        for (Users user: users) {
            UsersDto allUsers = new UsersDto();
            allUsers.setId(user.getUserId());
            allUsers.setName(user.getName());
            allUsers.setLastName(user.getLastName());
            allUsers.setEmail(user.getEmail());

            List<String> roles = new ArrayList<>();
            for (Roles role: user.getUserRoles()) {
                roles.add(role.getRoleName());
            }
            allUsers.setRoles(roles.stream().toArray(String[]::new));

            usersDtos.add(allUsers);
        }
        return usersDtos;
    }

    @Override
    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    @Override
    public boolean editUSer(UsersDto users) {

        Users user = usersRepository.findByEmail(users.getEmail());
        if (user != null){
            user.setName(users.getName());
            user.setLastName(users.getLastName());
            user.setDisabled(users.getDisabled());
            if (users.getRoles() != null){
                Set<Roles> rolesSet = new HashSet<>();
                for (String role: users.getRoles()) {
                    Roles roles = rolesRepository.findByRoleName(role);
                    rolesSet.add(roles);
                }
                user.setUserRoles(rolesSet);
            }
            usersRepository.save(user);
            return true;
        }
        return false;
    }


}
