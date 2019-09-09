package fa.haint53.repository;

import fa.haint53.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Override
    <S extends Product> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(String s);

    @Override
    <S extends Product> S save(S entitys);




    @Override
    <S extends Product> S insert(S entity);

    @Override
    void deleteById(String s);


}
