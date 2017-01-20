package com.github.ttwd80.tigerpayroll.model.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.ttwd80.tigerpayroll.model.entity.UserRole;
import com.github.ttwd80.tigerpayroll.model.repository.UserRepository;
import com.github.ttwd80.tigerpayroll.model.repository.UserRoleRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;

	@Autowired
	public UserDetailsServiceImpl(final UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final com.github.ttwd80.tigerpayroll.model.entity.User user = userRepository.findOne(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		} else {
			final String password = user.getPassword();
			List<UserRole> userroles = userRoleRepository.findByUserByUsernameUsername(username);
			final List<? extends GrantedAuthority> authorities = toList(userroles);
			final String id = user.getUsername();
			final org.springframework.security.core.userdetails.User result = new org.springframework.security.core.userdetails.User(
					id, password, true, true, true, !user.isLocked(), authorities);
			return result;
		}
	}

	private List<? extends GrantedAuthority> toList(final List<UserRole> userroles) {
		if (userroles == null) {
			return Collections.emptyList();
		}
		return userroles.stream().map(ur -> new SimpleGrantedAuthority(ur.getRole().getId()))
				.collect(Collectors.toList());
	}
}
