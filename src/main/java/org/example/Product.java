package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prd_id")
    private int productId;

    @Column(name = "prd_name", length = 200)
    @NonNull
    private String productName;

    @Column(name = "prd_price")
    private double productPrice;

    @Column(name = "prd_count")
    private int productCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prd_add_date")
    private Date productAddDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prd_update_date")
    private Date productUpdateDate;
}










