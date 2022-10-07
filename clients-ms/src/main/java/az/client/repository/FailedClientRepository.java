package az.client.repository;


import az.client.entity.FailedClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FailedClientRepository extends JpaRepository<FailedClientEntity, Long> {

    List<FailedClientEntity> findByActiveTrue();

}
