package fa.haint53.repository;

import fa.haint53.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MongoRepository<User, Long> {
    @Override
    List<User> findAll();

    @Override
    User save(User user);

    Long deleteById(String id);

    @Override
    <S extends User> S insert(S entity);

    User findById(String ids);
}
