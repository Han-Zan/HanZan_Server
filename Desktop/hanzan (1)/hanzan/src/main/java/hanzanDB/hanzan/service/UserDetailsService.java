package hanzanDB.hanzan.service;

import hanzanDB.hanzan.data.entity.UserDetails;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws Exception;
}
