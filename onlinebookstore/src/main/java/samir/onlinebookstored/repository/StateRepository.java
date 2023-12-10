package samir.onlinebookstored.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import samir.onlinebookstored.entity.State;

@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Long>{
	
	List<State> findByCountryCode(@Param("code") String code);
}
