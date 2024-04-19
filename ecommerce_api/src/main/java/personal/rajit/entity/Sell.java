package personal.rajit.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "sell")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Sell extends Auditable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    // Sell One to Many Sell Detail
    @OneToMany(mappedBy = "sell", fetch = FetchType.LAZY)
    private List<SellDetail> sellDetailList;

    // SELL Many to One Customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "fk_customer_id"))
    private Customer customer;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private String customerId;

    public Sell(String id) {
        this.id = id;
    }
}
