USE gym_management;

-- =========================
-- Membership Plans
-- =========================
INSERT INTO membership_plans (plan_name, description, duration_month, price, is_active)
VALUES
('Monthly Basic', '1 month basic access', 1, 500000, true),
('Quarterly Standard', '3 months full access', 3, 1300000, true),
('Annual Premium', '12 months full access + trainer support', 12, 4500000, true);

-- =========================
-- Members
-- =========================
INSERT INTO members (first_name, last_name, email, phone, birth_date, gender, join_date, expired_date, notes, status)
VALUES
('Nguyen', 'Van A', 'a@example.com', '0901234567', '1995-05-20', 'MALE', '2025-01-01', '2025-02-01', 'New member', 'ACTIVE'),
('Tran', 'Thi B', 'b@example.com', '0907654321', '1998-08-15', 'FEMALE', '2025-01-15', '2025-04-15', 'Prefers yoga classes', 'ACTIVE'),
('Le', 'Van C', 'c@example.com', '0912345678', '1990-12-01', 'MALE', '2025-02-01', NULL, 'Trial member', 'INACTIVE');

-- =========================
-- Users (BCrypt passwords)
-- admin123 / staff123 / 123456
-- =========================
INSERT INTO users (username, password, email, role, member_id, status)
VALUES
('admin1',  '$2a$10$Dow1wlz6cjcDpdCjEuMaS.0g2F4RdvJlFPaXcYsQlAsI7/VvfY9vK', 'admin1@gym.com', 'ADMIN', NULL, 'ACTIVE'),
('staff1',  '$2a$10$9oV2Z2Zn3sOaXkCpt5gl6eXPZh6qkjK7CD6bnPfOiLMuEBMepjL.O', 'staff1@gym.com', 'STAFF', NULL, 'ACTIVE'),
('member1', '$2a$10$hZFTjCN31kwkSrxkMnEvkuy6V.VjqQo9BFgQlVmUKYFSrbe3fBqcu', 'a@example.com', 'MEMBER', 1, 'ACTIVE'),
('member2', '$2a$10$hZFTjCN31kwkSrxkMnEvkuy6V.VjqQo9BFgQlVmUKYFSrbe3fBqcu', 'b@example.com', 'MEMBER', 2, 'ACTIVE');

-- =========================
-- Trainers
-- =========================
INSERT INTO trainers (full_name, phone, email, specialty, hire_date, status)
VALUES
('Pham Van Trainer', '0933222111', 'trainer1@gym.com', 'Fitness & Cardio', '2024-10-01', 'ACTIVE'),
('Hoang Thi Coach', '0944333222', 'trainer2@gym.com', 'Yoga & Pilates', '2025-01-10', 'ACTIVE');

-- =========================
-- Payments
-- =========================
INSERT INTO payments (member_id, membership_plan_id, amount, payment_method, status, transaction_reference)
VALUES
(1, 1, 500000, 'CASH', 'COMPLETED', 'TXN001'),
(2, 2, 1300000, 'CREDIT_CARD', 'COMPLETED', 'TXN002'),
(3, 1, 500000, 'BANK_TRANSFER', 'PENDING', 'TXN003');

-- =========================
-- Member Membership History
-- =========================
INSERT INTO member_memberships (member_id, membership_plan_id, start_date, end_date, is_active)
VALUES
(1, 1, '2025-01-01', '2025-02-01', true),
(2, 2, '2025-01-15', '2025-04-15', true),
(3, 1, '2025-02-01', '2025-03-01', false);

-- =========================
-- Class Schedules
-- =========================
INSERT INTO class_schedules (class_name, description, trainer_id, start_time, end_time, location, max_capacity, current_capacity, status)
VALUES
('Morning Yoga', 'Yoga for beginners', 2, '2025-02-20 07:00:00', '2025-02-20 08:00:00', 'Room 1', 20, 10, 'ACTIVE'),
('Evening Cardio', 'High intensity cardio training', 1, '2025-02-21 18:00:00', '2025-02-21 19:30:00', 'Room 2', 25, 15, 'ACTIVE');

-- =========================
-- Registrations
-- =========================
INSERT INTO registrations (member_id, class_schedule_id, attendance_status, notes)
VALUES
(1, 1, 'PRESENT', 'On time'),
(2, 1, 'ABSENT', 'Did not show'),
(1, 2, 'PENDING', 'Registered in advance');

-- =========================
-- Equipment
-- =========================
INSERT INTO equipment (name, description, purchase_date, status, location, notes)
VALUES
('Treadmill', 'Running machine', '2024-08-01', 'IN_USE', 'Cardio Zone', 'Regular use'),
('Yoga Mats', 'Set of 20 mats', '2024-09-15', 'AVAILABLE', 'Yoga Room', 'For group classes'),
('Bench Press', 'Weight training bench', '2023-12-01', 'MAINTENANCE', 'Strength Area', 'Broken handle');

-- =========================
-- Equipment Maintenance Logs
-- =========================
INSERT INTO equipment_maintenance (equipment_id, maintenance_date, description, staff_id)
VALUES
(3, '2025-02-10', 'Fix broken handle', 2),
(1, '2025-01-15', 'Lubricate running belt', 2);

-- =========================
-- Access Logs
-- =========================
INSERT INTO access_logs (member_id, check_in_time, check_out_time, notes)
VALUES
(1, '2025-02-20 06:50:00', '2025-02-20 08:30:00', 'Morning workout'),
(2, '2025-02-20 07:10:00', '2025-02-20 08:05:00', 'Yoga class'),
(1, '2025-02-21 17:50:00', '2025-02-21 19:40:00', 'Cardio session');
