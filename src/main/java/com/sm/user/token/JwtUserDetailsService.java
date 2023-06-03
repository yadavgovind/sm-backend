package com.sm.user.token;

import java.util.ArrayList;

import com.sm.user.document.Store;
import com.sm.user.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	StoreRepository storeRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Store store = storeRepository.findByStoreIdOrPhone(username, username);
		if (store.getPhone().equals(username)) {
			return new User(store.getPhone(), "$2a$10$.JjsHs.vrEm1tbpkq98VJedRj9vMCHaSmL8GHGiy0E9C3yACCbTjG",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}