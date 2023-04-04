package RuntimeTerror.OnlineDeliveryPortalLoginSignup.repository;

import RuntimeTerror.OnlineDeliveryPortalLoginSignup.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Same as before here use 'User' entity
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //search by 'username' for te 'User' entity that matches
    Optional<User> findByUsername(String username);

    //returns a boolean whether searched 'username' or 'email' exists
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}