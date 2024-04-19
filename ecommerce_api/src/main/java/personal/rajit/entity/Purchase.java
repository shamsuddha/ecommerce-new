package personal.rajit.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "purchase")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Purchase extends Auditable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "note")
    private String note;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "other_cost")
    private Double otherCost;

    // Purchase Many to One Supplier
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_supplier_id"))
    private Supplier supplier;

    // Purchase Many to One Employee
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false, foreignKey = @ForeignKey(name = "fk_employee_id"))
    private Employee employee;

    @Column(name = "supplier_id", insertable = false, updatable = false)
    private String supplierId;

    // Purchase One to Many Purchase Detail
    @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
    private List<PurchaseDetail> purchaseDetailList;

    public Purchase(String id) {
      this.id = id;
  }

}
