package com.example.java_spring.modules.product.entity;

import com.example.java_spring.common.generic.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Giá sản phẩm là bắt buộc")
    @Min(value = 0, message = "Giá không được nhỏ hơn 0")
    private BigDecimal price; // Dùng BigDecimal để đảm bảo độ chính xác tài chính

    @NotNull(message = "Số lượng là bắt buộc")
    @Min(value = 0, message = "Số lượng không được nhỏ hơn 0")
    private Integer quantity;

    @Column(unique = true)
    private String sku; // Mã kho hàng (Stock Keeping Unit)
}