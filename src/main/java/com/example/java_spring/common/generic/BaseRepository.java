package com.example.java_spring.common.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
    // Bạn có thể thêm các method chung ở đây (ví dụ: soft delete)
    void refresh(T entity);
}