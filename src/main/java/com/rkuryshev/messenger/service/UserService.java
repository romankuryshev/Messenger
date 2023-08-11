package com.rkuryshev.messenger.service;

import com.rkuryshev.messenger.entity.User;
import com.rkuryshev.messenger.repository.RoleRepository;
import com.rkuryshev.messenger.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Optional<User> findByUUID(UUID uuid){
        return userRepository.findByUuid(uuid);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' not found", username)
        ));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoleSet().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

    public void createNewUser(User user){
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("User with username '%s' exists");
        } else {
            user.setRoleSet(Set.of(roleRepository.findByName("ROLE_USER").get()));
            userRepository.save(user);
        }
    }

    public void createNewAdmin(User user) {
        createNewUser(user);
        User admin = userRepository.findByUsername(user.getUsername()).get();
        admin.getRoleSet().add(roleRepository.findByName("ROLE_ADMIN").get());
        userRepository.save(admin);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
