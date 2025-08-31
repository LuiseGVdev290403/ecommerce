package com.luise.ecommer.infrastructure.persistence;

import com.luise.ecommer.infrastructure.persistence.embeddables.DateAudit;
import com.luise.ecommer.infrastructure.persistence.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @Column(name = "total_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalAmount;
    @Column(name = "payment_method", nullable = false, length = 120)
    private String paymentMethod;
    @Column(name = "shipping_address",  length = 250)
    private String shippingAddress;
    @Column(name = "shipping_status", length = 120)
    private String shippingStatus;
    @Embedded
    private DateAudit dateAudit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserJpaEntity user;


}
