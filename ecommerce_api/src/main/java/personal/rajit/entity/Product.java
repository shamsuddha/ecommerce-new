package personal.rajit.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Product extends Auditable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "current_stock")
    private Double currentStock;

    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "buying_price")
    private Double buyingPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    // Product Many to One ProductCategory
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product_category_id"))
    private ProductCategory productCategory;

    @Column(name = "product_category_id", insertable = false, updatable = false)
    private String productCategoryId;

    // Product Many to One Supplier
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_supplier_id"))
    private Supplier supplier;

    @Column(name = "supplier_id", insertable = false, updatable = false)
    private String supplierId;

    // Product One to Many Purchase Detail
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<PurchaseDetail> purchaseDetailList;

    // Product One to Many Sell Detail
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<SellDetail> sellDetailList;
}
