package com.github.ttwd80.tigerpayroll.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.ttwd80.tigerpayroll.model.entity.Role;
import com.github.ttwd80.tigerpayroll.model.repository.RoleRepository;
import com.github.ttwd80.tigerpayroll.model.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public UserDetailsServiceImpl(final UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final com.github.ttwd80.tigerpayroll.model.entity.User user = userRepository.findOne(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		} else {
			final String password = user.getPassword();
			List<Role> roles = roleRepository.findByUserRolesUserByUsernameUsername(username);
			final List<? extends GrantedAuthority> authorities = toList(roles);
			final String id = user.getUsername();
			final org.springframework.security.core.userdetails.User result = new org.springframework.security.core.userdetails.User(
					id, password, true, true, true, !user.isLocked(), authorities);
			return result;
		}
	}

	private List<? extends GrantedAuthority> toList(final List<Role> roles) {
		if (roles == null) {
			return Collections.emptyList();
		}
		final List<GrantedAuthority> list = new ArrayList<>();
		for (final Role value : roles) {
			list.add(new SimpleGrantedAuthority(value.getId()));
		}
		return list;
	}
}
