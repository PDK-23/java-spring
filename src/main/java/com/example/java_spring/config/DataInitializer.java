package com.example.java_spring.config;

import com.example.java_spring.modules.auth.entity.Role;
import com.example.java_spring.modules.auth.entity.User;
import com.example.java_spring.modules.auth.repository.UserRepository;
import com.example.java_spring.modules.product.entity.Product;
import com.example.java_spring.modules.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        initUsers();
        initProducts();
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            // Tạo ADMIN user
            User admin = User.builder()
                    .name("Admin User")
                    .email("admin@example.com")
                    .password(passwordEncoder.encode("password123"))
                    .role(Role.ADMIN)
                    .active(true)
                    .build();
            userRepository.save(admin);
            log.info("✅ Đã tạo ADMIN user: admin@example.com / password123");

            // Tạo STAFF user
            User staff = User.builder()
                    .name("Staff User")
                    .email("staff@example.com")
                    .password(passwordEncoder.encode("password123"))
                    .role(Role.STAFF)
                    .active(true)
                    .build();
            userRepository.save(staff);
            log.info("✅ Đã tạo STAFF user: staff@example.com / password123");
        }
    }

    private void initProducts() {
        if (productRepository.count() == 0) {
            Product p1 = Product.builder()
                    .name("Laptop Dell XPS 13")
                    .description("Laptop cao cấp với màn hình 13 inch, chip Intel i7")
                    .price(new BigDecimal("25000000"))
                    .quantity(10)
                    .sku("LAPTOP-DELL-001")
                    .build();

            Product p2 = Product.builder()
                    .name("iPhone 15 Pro")
                    .description("Điện thoại thông minh cao cấp của Apple")
                    .price(new BigDecimal("30000000"))
                    .quantity(15)
                    .sku("IPHONE-15-PRO")
                    .build();

            Product p3 = Product.builder()
                    .name("Samsung Galaxy S24")
                    .description("Điện thoại Android flagship")
                    .price(new BigDecimal("22000000"))
                    .quantity(20)
                    .sku("SAMSUNG-S24")
                    .build();

            Product p4 = Product.builder()
                    .name("MacBook Pro M3")
                    .description("Laptop Apple với chip M3 mạnh mẽ")
                    .price(new BigDecimal("45000000"))
                    .quantity(5)
                    .sku("MACBOOK-PRO-M3")
                    .build();

            Product p5 = Product.builder()
                    .name("AirPods Pro 2")
                    .description("Tai nghe không dây chống ồn")
                    .price(new BigDecimal("6000000"))
                    .quantity(30)
                    .sku("AIRPODS-PRO-2")
                    .build();

            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);
            productRepository.save(p4);
            productRepository.save(p5);

            log.info("✅ Đã tạo {} sản phẩm mẫu", 5);
        }
    }
}

