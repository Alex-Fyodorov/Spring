package fyodorov.repository;

import fyodorov.model.User;

import java.util.List;

public interface UserRepository {

    void insert(String name);
    User findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
    void save(User user);


}
