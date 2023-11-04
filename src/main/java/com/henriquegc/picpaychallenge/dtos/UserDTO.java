package com.henriquegc.picpaychallenge.dtos;

import com.henriquegc.picpaychallenge.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String email, UserType userType, String document,
                      BigDecimal amount, String password) {
}
