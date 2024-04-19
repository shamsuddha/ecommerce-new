package personal.rajit.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "supplier")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Supplier extends Auditable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "current_balance")
    private String currentBalance;

    // Supplier One to Many Product
    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Product> productList;

    // Supplier One to Many Purchase
    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Purchase> purchaseList;

    public Supplier(String id) {
        this.id = id;
    }

}
