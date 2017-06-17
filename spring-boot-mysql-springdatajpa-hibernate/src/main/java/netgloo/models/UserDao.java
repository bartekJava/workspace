package netgloo.models;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);
}
