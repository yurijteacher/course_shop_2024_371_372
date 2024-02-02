package ua.com.kisit2024.course_shop_2024_371_372.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByUsername(String username);

    List<Users> findAllByUsernameAndPassword(String username, String password);
}
