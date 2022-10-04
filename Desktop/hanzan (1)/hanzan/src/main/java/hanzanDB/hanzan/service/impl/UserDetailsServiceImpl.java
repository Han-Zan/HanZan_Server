package hanzanDB.hanzan.service.impl;

import hanzanDB.hanzan.data.entity.UserDetails;
import hanzanDB.hanzan.data.repository.UserRepository;
import hanzanDB.hanzan.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws Exception {
        LOGGER.info("[loadUserByUsername] loadByUsername 수행. username : {username}");
        return userRepository.getByUid(username);
    }
}
