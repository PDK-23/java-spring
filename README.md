# Java Spring RBAC API

Kiến trúc hiện tại theo module + layer:

- `config`: Cấu hình hệ thống (Security, Swagger, JPA Auditing)
- `common`: Thành phần dùng chung
- `modules/auth`: Quản lý xác thực + người dùng
- `modules/product`: Quản lý sản phẩm
- `security`: JWT utility + filter

## Role và quyền

- `ADMIN`: CRUD User + CRUD Product
- `STAFF`: Chỉ CRUD Product

## API chính

- `POST /api/auth/login`
- `CRUD /api/users` (ADMIN only)
- `CRUD /api/products` (ADMIN, STAFF)

## Swagger UI

- `http://localhost:8080/swagger-ui.html`

## Tài khoản mẫu (DataInitializer)

- Admin: `admin@example.com / password123`
- Staff: `staff@example.com / password123`

## application.properties

File cấu hình local `src/main/resources/application.properties` đã được ignore.

Bạn chỉ cần:

1. Copy `src/main/resources/application.properties.template`
2. Đổi tên thành `src/main/resources/application.properties`
3. Cập nhật thông tin database + JWT secret