package com.henriquegc.picpaychallenge.services;

import com.henriquegc.picpaychallenge.domain.user.User;
import com.henriquegc.picpaychallenge.domain.user.UserType;
import com.henriquegc.picpaychallenge.dtos.UserDTO;
import com.henriquegc.picpaychallenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User payer, BigDecimal amount) throws Exception {
        if (payer.getAmount().compareTo(amount) < 0) {
            System.out.println("ERRPR");

            throw new Exception("valor insuficiente");
        }

        if (payer.getUserType() == UserType.SELLER) {
            throw new Exception("lojista não é permitido pagar");
        }
    }

    public void createUser(UserDTO user) {
        this.userRepository.save(new User(user.email(), user.userType(),user.password(), user.firstName(), user.lastName(), user.document(), user.amount()));
    }

    public User getUserById(String id) throws Exception  {
        return userRepository.findUserById(id).orElseThrow(() -> new Exception("user not found"));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void putUser(User user) {
        userRepository.save(user);
    }
}
