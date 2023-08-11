package com.rkuryshev.messenger.service;

import com.rkuryshev.messenger.entity.User;
import com.rkuryshev.messenger.exeption.UsernameExistsException;
import com.rkuryshev.messenger.repository.RoleRepository;
import com.rkuryshev.messenger.repository.UserRepository;
import com.rkuryshev.messenger.security.dto.RegistrationRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

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

    public void createNewUser(RegistrationRequest registrationRequest) throws UsernameExistsException {
        if (userRepository.findByUsername(registrationRequest.getUsername()).isPresent()) {
            throw new UsernameExistsException("User with username '%s' exists");
        } else {
            User user = new User(registrationRequest.getUsername(), passwordEncoder.encode(registrationRequest.getPassword()));
            user.setRoleSet(Set.of(roleRepository.findByName("ROLE_USER").get()));
            userRepository.save(user);
        }
    }

    public void createNewAdmin(RegistrationRequest registrationRequest) {
        createNewUser(registrationRequest);
        User admin = userRepository.findByUsername(registrationRequest.getUsername()).get();
        admin.getRoleSet().add(roleRepository.findByName("ROLE_ADMIN").get());
        userRepository.save(admin);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
