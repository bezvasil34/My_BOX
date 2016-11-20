package ua.com.mybox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.mybox.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {

	
	@Query("select distinct p from Producer p left join fetch p.categories ca ")
	List<Producer> findAllByFetch();
}
