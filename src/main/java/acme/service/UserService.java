package acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import acme.model.user.User;
import acme.response.UserResponse;
import io.quarkus.hibernate.orm.PersistenceUnit;

@ApplicationScoped
public class UserService {

    @Inject
    @PersistenceUnit("users") 
    EntityManager entityManagerUser;
	
    
    public UserResponse getUser(Integer userId) {
    	User user = entityManagerUser.find(User.class, userId);
    	UserResponse userResponse = new UserResponse();
    	userResponse.setId(user.getId());
    	userResponse.setName(user.getName());
    	userResponse.setSurname(user.getSurname());
    	return userResponse;
    }
	
}
