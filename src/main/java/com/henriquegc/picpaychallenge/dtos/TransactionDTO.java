package com.henriquegc.picpaychallenge.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal amount, String payerId, String payeeId) {
}
