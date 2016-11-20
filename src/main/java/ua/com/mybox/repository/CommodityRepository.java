package ua.com.mybox.repository;

import java.lang.annotation.Repeatable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import ua.com.mybox.entity.Commodity;
import ua.com.mybox.entity.Producer;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {

	
	@Query("select distinct c from Commodity c left join fetch c.producers p ")
	List<Commodity> findAllByFetch();
	
}
