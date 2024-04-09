package com.myschool.commons.dto.payments;

import com.myschool.commons.dto.StatefulRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AddSalary extends StatefulRequest {
    private UUID instituteId;
    private UUID processorStaffId;
    private UUID staffId;
    private BigDecimal amount;
}
