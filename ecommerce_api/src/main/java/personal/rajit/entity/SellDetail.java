package personal.rajit.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sellDetail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class SellDetail extends Auditable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    // SELL Detail Many to One sell
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sell_id", nullable = false, foreignKey = @ForeignKey(name = "fk_sell_id"))
    private Sell sell;

    @Column(name = "sell_id", insertable = false, updatable = false)
    private String sellId;

    // SELL Detail Many to One Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product_id"))
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private String productId;

    public SellDetail(String id) {
        this.id = id;
    }
}
