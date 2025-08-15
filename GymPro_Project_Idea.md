# 🎯 Dự Án: GymPro – Hệ Thống Quản Lý Phòng Gym Thông Minh

## 🧩 Mục tiêu
Không chỉ quản lý CRUD, mà là **giám sát hoạt động, hỗ trợ quyết định và tự động hóa**.

---

## ✅ 1. Cơ bản – Quản lý dữ liệu & người dùng

| Module                  | Mô tả                                                        |
|-------------------------|--------------------------------------------------------------|
| Đăng nhập + phân quyền  | `ADMIN`, `STAFF`, `MEMBER` → phân giao diện và quyền thao tác |
| Hội viên + gói tập      | CRUD + tính hạn sử dụng theo gói tập                         |
| Lịch lớp                | CRUD lớp học, huấn luyện viên, giới hạn số lượng tham gia     |
| Đăng ký lớp             | Hội viên đăng ký, kiểm tra trùng giờ & giới hạn số lượng     |
| Thanh toán              | Ghi nhận thanh toán & cập nhật hạn gói tập                   |

---

## 🧠 2. Nâng cao – Tự động hóa & logic nghiệp vụ

| Module                  | Mô tả nâng cấp                                               |
|-------------------------|--------------------------------------------------------------|
| Gửi email nhắc hạn      | Trước 3 ngày hết gói → gửi mail                              |
| Dashboard thống kê      | Doanh thu tháng, lớp hot nhất, tổng hội viên mới             |
| Nhật ký truy cập        | Lưu lịch sử đăng nhập, đăng ký lớp, thanh toán               |
| Quản lý thiết bị        | Cảnh báo cần bảo trì, lọc theo trạng thái                    |
| Quản lý trạng thái      | Hội viên bị khóa tự động khi hết hạn                         |

---

## 🚀 3. Smart Features – Nâng tầm sản phẩm

| Tính năng                | Mô tả kỹ thuật                                                      |
|--------------------------|----------------------------------------------------------------------|
| Gợi ý lớp phù hợp         | Dựa theo lịch rảnh, giới tính, sở thích hội viên                    |
| Lọc thống kê linh hoạt    | Doanh thu theo tháng/quý, theo gói tập                              |
| Xem lịch sử giao dịch     | Truy xuất giao dịch gần nhất, hoàn tiền                             |
| Export CSV/PDF            | Xuất danh sách hội viên hoặc lớp học ra file                        |
| Thông báo realtime (nâng cao)| Cập nhật trạng thái lớp học tức thời qua WebSocket hoặc polling |

---

## 🧰 Kiến trúc đề xuất

### Backend – Spring Boot
- `controller → service → repository`
- DTO + Mapper (MapStruct)
- JWT Auth + Role Guard
- Cron Job (`@Scheduled`)
- Swagger

### Frontend – JavaFX (desktop)
- UI chia màn: Login / Hội viên / Lớp / Dashboard
- Gọi API bằng `HttpClient`, lưu JWT
- Hiển thị `TableView`, `Chart`, `Dialog`

---

## ✅ Lợi thế khi triển khai
| Điểm mạnh kỹ thuật                   | Khi đi phỏng vấn có thể nói                                      |
|-------------------------------------|------------------------------------------------------------------|
| Tách UI khỏi logic backend          | “App desktop nhưng triển khai backend chuẩn REST.”              |
| Cron + Tự động hóa nghiệp vụ        | “Em có tự động gửi mail nhắc hạn, update hạn gói.”              |
| Dashboard thống kê từ API           | “Frontend vẽ biểu đồ realtime từ dữ liệu backend thống kê.”     |
| Bảo mật & phân quyền rõ ràng        | “Em dùng JWT và phân quyền `ADMIN`, `STAFF`, `MEMBER` bằng Spring Security.” |

---

## 🟢 Gợi ý bắt đầu
- [ ] Triển khai cron job gửi mail nhắc hạn
- [ ] Viết API thống kê doanh thu, số hội viên mới
- [ ] Gọi API từ JavaFX và hiển thị bảng/lịch
- [ ] Kiểm tra trùng lịch khi đăng ký lớp học

> **Bạn có thể chọn 1 module để bắt đầu mở rộng theo hướng thông minh và có chiều sâu.**