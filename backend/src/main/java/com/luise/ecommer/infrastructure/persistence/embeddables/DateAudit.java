package com.luise.ecommer.infrastructure.persistence.embeddables;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DateAudit {
    private LocalDateTime createdAt;
    private LocalDateTime updateAdt;
}
