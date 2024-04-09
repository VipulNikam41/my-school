package com.myschool.commons.dto.payments;

import com.myschool.commons.dto.StatefulRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AddFees extends StatefulRequest {
    private UUID instituteId;
    private UUID cashierId;
    private UUID studentId;
    private BigDecimal amount;
}
