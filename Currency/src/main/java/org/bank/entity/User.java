package org.bank.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List <Transaction> transactionList = new ArrayList<>();

    public void addTransaction(Transaction tr){
        tr.setUser(this);
        transactionList.add(tr);
    }
}
