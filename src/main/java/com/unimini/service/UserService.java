package com.unimini.service;

import com.unimini.mapper.UserMapper;
import com.unimini.vo.User;
import com.unimini.vo.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserInfo(user);
    }

    @Transactional
    public void createUserInfo(Map<String, Object> paramMap) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        paramMap.put("userAuth", "USER");
        paramMap.put("password", passwordEncoder.encode(paramMap.get("password").toString()));
        
        // 프로필 랜덤생성
        Random random = new Random();
        int profileImageCode = random.nextInt(16) + 1;
        paramMap.put("profileImageCode", profileImageCode);
        userMapper.createUserInfo(paramMap);
    }

    public Map<String, String> checkUserId(Map<String, Object> paramMap) {
        return userMapper.checkUserId(paramMap);
    }

    public List<Map<String, String>> getMajor(Map<String, Object> paramMap) {
        return userMapper.getMajor(paramMap);
    }
}
