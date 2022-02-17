package org.bank.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(exclude = "user")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    private String created;
    @NonNull
    private String buy;
    @NonNull
    private BigDecimal amount;
    @NonNull
    private String sell;
    @NonNull
    private BigDecimal sum;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


}
