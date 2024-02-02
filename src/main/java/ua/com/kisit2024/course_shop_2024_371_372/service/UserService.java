package ua.com.kisit2024.course_shop_2024_371_372.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Clients;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Users;
import ua.com.kisit2024.course_shop_2024_371_372.repository.ClientsRepository;
import ua.com.kisit2024.course_shop_2024_371_372.repository.UsersRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final ClientsRepository clientsRepository;

    public boolean getLogicByUsername(String username){
        return (!usersRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }

    public Users saveNewUserToDB(Users user){
        return usersRepository.save(user);
    }

    public Clients saveNewClientToDb(Clients client){
        return clientsRepository.save(client);
    }

    public boolean getLogicByUsernameAndPassword(String username, String password){
        return (!usersRepository.findAllByUsernameAndPassword(username, password).isEmpty());
    }

    public Users getUserByUsername(String username){
        return usersRepository.findAllByUsername(username).get(0);
    }

    public Optional<Users> getUserById(Long id){
        return usersRepository.findById(id);
    }

    public Clients getClientById(Long id){
        return clientsRepository.findById(id).get();
    }

}
