package com.rian.learnblock.service;

import com.rian.learnblock.bean.LoginRequest;
import com.rian.learnblock.bean.LoginResponse;
import com.rian.learnblock.bean.UserRequest;
import com.rian.learnblock.bean.UserResponse;
import com.rian.learnblock.entity.BlockChain;
import com.rian.learnblock.entity.User;
import com.rian.learnblock.repository.BlockChainRepository;
import com.rian.learnblock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlockChainRepository blockChainRepository;

    @Override
    public UserResponse createUser(UserRequest user) {

        BlockChain block = blockChainRepository.getLastBlockCode();
        int lastCode = user.getCode();
        if (block == null || block.getCode() == lastCode || block.getId() == 1) {

            BlockChain blockChain = new BlockChain();
            if(block == null){
                blockChain.setId(1);
            }else{
                blockChain.setId(block.getId()+1);
            }
            int newCode = user.hashCode();


            blockChain.setCode(newCode);
            blockChain.setLastcode(lastCode);
            BlockChain newBlockChain = blockChainRepository.save(blockChain);

            User userEntity = new User();
            userEntity.setId(user.getId());
            userEntity.setFullname(user.getFullname());
            userEntity.setEmail(user.getEmail());
            userEntity.setLastcode(newCode);
            userEntity.setPassword(user.getPassword());
            userEntity.setStatus(true);
            userEntity.setVerified(true);

            User cUSer = userRepository.save(userEntity);

            UserResponse userResponse = new UserResponse();
            userResponse.setVerified(true);
            userResponse.setCode(newBlockChain.getCode());
            userResponse.setEmail(cUSer.getEmail());
            userResponse.setId(cUSer.getId());
            userResponse.setFullname(cUSer.getFullname());
            userResponse.setEmail(cUSer.getEmail());

            return userResponse;
        }
        return null;
    }

    @Override
    public User getUserById(String id) {
        return userRepository.getUserByUsername(id);
    }

    @Override
    public User getUserByEmail(String email) {

        User user = userRepository.getUserByEmail(email);
        System.out.println(user == null ? "null" : user.getEmail());
        return user;
    }

    @Override
    public void deleteUser(String id) {

        User user = getUserById(id);

        if (user != null)
            userRepository.delete(user);
    }

    @Override
    public LoginResponse login(LoginRequest bean) {
        System.out.println(bean.getEmail());
        System.out.println(bean.getPassword());

        List<User> users = userRepository.getUserByUserAndEmail(bean.getEmail().trim(), bean.getPassword().trim());

        if (users == null || users.size() > 1 || !users.get(0).isVerified()
                || !users.get(0).isStatus())
            return null;

        User user = users.get(0);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(user.getId());
        loginResponse.setFullname(user.getFullname());
        loginResponse.setEmail(user.getEmail());
        loginResponse.setVerified(user.isVerified());
        loginResponse.setStatus(user.isStatus());

        return loginResponse;
    }

}
