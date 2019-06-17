package data.repositories;

import data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "INSERT INTO users_roles (login, role) VALUES (?1, 'ROLE_USER')", nativeQuery = true)
    void setUserRole(String login);

    User getByLogin(String login);

    User getById(Long id);
}
