package com.example.java_spring.common.generic;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // Đánh dấu đây không phải là một bảng, chỉ là lớp cha
@EntityListeners(AuditingEntityListener.class) // Lắng nghe sự kiện để tự chèn ngày tháng
@Getter
@Setter
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Bạn có thể thêm createdBy, updatedBy nếu muốn quản lý người dùng thực hiện
}
