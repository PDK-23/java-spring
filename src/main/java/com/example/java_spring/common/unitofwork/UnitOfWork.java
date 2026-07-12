package com.example.java_spring.common.unitofwork;

import com.example.java_spring.modules.product.repository.ProductRepository;
import com.example.java_spring.modules.auth.repository.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Getter
public class UnitOfWork {

    private final EntityManager entityManager;

    // Khai báo các Repository cụ thể tại đây
    // Dùng @Getter của Lombok để Service có thể gọi: unitOfWork.getProductRepository()
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    /**
     * Đồng bộ các thay đổi trong Persistence Context xuống Database thủ công.
     * Thường dùng khi bạn cần lấy ID của entity ngay lập tức sau khi save.
     */
    @Transactional
    public void flush() {
        entityManager.flush();
    }

    /**
     * Xóa bỏ các entity đang được quản lý khỏi EntityManager.
     */
    public void clear() {
        entityManager.clear();
    }
}