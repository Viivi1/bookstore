package hh.backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.backend.bookstore.domain.AppUser;
import hh.backend.bookstore.domain.AppUserRepository;

@Service
public class AppUserDetailService implements UserDetailsService {

    private final AppUserRepository repository;

    public AppUserDetailService(AppUserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
        AppUser curruser = repository.findByUsername(username);
    	UserDetails user = new User(username, curruser.getPasswordHash(), 
		AuthorityUtils.createAuthorityList(curruser.getRole()));
        
        return user;
    }
}
