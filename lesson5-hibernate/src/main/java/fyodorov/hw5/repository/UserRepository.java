package fyodorov.hw5.repository;

import fyodorov.hw5.model.UserHW;

import java.util.List;

public interface UserRepository {

    void init();
    void insert(String name, int age);
    UserHW findById(Long id);
    List<UserHW> findAll();
    void deleteById(Long id);
    void save(UserHW user);
    void shutdown();

}
