package lk.ijse.cmjd108.Lost_and_Found.config;

import lk.ijse.cmjd108.Lost_and_Found.entity.User;
import lk.ijse.cmjd108.Lost_and_Found.repository.UserRepository;
import lk.ijse.cmjd108.Lost_and_Found.config.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new UserDetailsImpl(user);
    }
}
