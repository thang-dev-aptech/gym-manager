CREATE DATABASE IF NOT EXISTS gym_management;
USE gym_management;

-- =========================
-- Membership Plans
-- =========================
CREATE TABLE membership_plans (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plan_name VARCHAR(50) NOT NULL,
    description TEXT,
    duration_month INT NOT NULL,
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    is_active BOOLEAN DEFAULT TRUE, -- active/inactive plan
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- =========================
-- Members
-- =========================
CREATE TABLE members (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    birth_date DATE,
    gender ENUM('MALE', 'FEMALE', 'OTHER'),
    join_date DATE NOT NULL,
    expired_date DATE,
    notes TEXT,
    status ENUM('ACTIVE', 'INACTIVE', 'SUSPENDED') DEFAULT 'ACTIVE', -- soft lock
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    CONSTRAINT chk_member_dates CHECK (expired_date IS NULL OR expired_date > join_date)
);

-- =========================
-- Users (system login)
-- =========================
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role ENUM('ADMIN', 'STAFF', 'MEMBER') NOT NULL,
    member_id BIGINT NULL,
    last_login DATETIME,
    status ENUM('ACTIVE','LOCKED','SUSPENDED') DEFAULT 'ACTIVE', -- replace is_active
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_user_member FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE SET NULL
);

-- =========================
-- Trainers
-- =========================
CREATE TABLE trainers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    specialty VARCHAR(100),
    hire_date DATE,
    status ENUM('ACTIVE', 'INACTIVE', 'SUSPENDED') DEFAULT 'ACTIVE', -- soft lock trainer
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- =========================
-- Payments
-- =========================
CREATE TABLE payments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    membership_plan_id BIGINT,
    amount DECIMAL(10,2) NOT NULL CHECK (amount >= 0),
    payment_method ENUM('CASH', 'BANK_TRANSFER', 'CREDIT_CARD', 'OTHER') NOT NULL,
    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('PENDING', 'COMPLETED', 'FAILED', 'REFUNDED') DEFAULT 'PENDING',
    transaction_reference VARCHAR(100),
    notes TEXT,
    
    CONSTRAINT fk_payment_member FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE CASCADE,
    CONSTRAINT fk_payment_plan FOREIGN KEY (membership_plan_id) REFERENCES membership_plans(id) ON DELETE SET NULL
);

-- =========================
-- Member Membership History
-- =========================
CREATE TABLE member_memberships (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    membership_plan_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_mm_member FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE CASCADE,
    CONSTRAINT fk_mm_plan FOREIGN KEY (membership_plan_id) REFERENCES membership_plans(id) ON DELETE CASCADE,
    CONSTRAINT chk_dates CHECK (end_date > start_date)
);

-- =========================
-- Class Schedules
-- =========================
CREATE TABLE class_schedules (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(100) NOT NULL,
    description TEXT,
    trainer_id BIGINT NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    location VARCHAR(100),
    max_capacity INT NOT NULL CHECK (max_capacity > 0),
    current_capacity INT DEFAULT 0,
    status ENUM('ACTIVE', 'CANCELLED', 'COMPLETED') DEFAULT 'ACTIVE',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_class_trainer FOREIGN KEY (trainer_id) REFERENCES trainers(id) ON DELETE CASCADE,
    CONSTRAINT chk_class_times CHECK (end_time > start_time)
);

-- =========================
-- Registrations (Member joins class)
-- =========================
CREATE TABLE registrations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    class_schedule_id BIGINT NOT NULL,
    registered_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    attendance_status ENUM('PRESENT', 'ABSENT', 'PENDING') DEFAULT 'PENDING',
    notes TEXT,
    
    CONSTRAINT fk_reg_member FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE CASCADE,
    CONSTRAINT fk_reg_class FOREIGN KEY (class_schedule_id) REFERENCES class_schedules(id) ON DELETE CASCADE,
    CONSTRAINT uc_member_class UNIQUE (member_id, class_schedule_id)
);

-- =========================
-- Equipment
-- =========================
CREATE TABLE equipment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    purchase_date DATE,
    status ENUM('AVAILABLE', 'IN_USE', 'MAINTENANCE', 'RETIRED') DEFAULT 'AVAILABLE',
    location VARCHAR(100),
    notes TEXT
);

-- =========================
-- Equipment Maintenance Logs
-- =========================
CREATE TABLE equipment_maintenance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    equipment_id BIGINT NOT NULL,
    maintenance_date DATE NOT NULL,
    description TEXT,
    staff_id BIGINT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_em_equipment FOREIGN KEY (equipment_id) REFERENCES equipment(id) ON DELETE CASCADE,
    CONSTRAINT fk_em_staff FOREIGN KEY (staff_id) REFERENCES users(id) ON DELETE SET NULL
);

-- =========================
-- Access Logs (Check-in / Check-out)
-- =========================
CREATE TABLE access_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    check_in_time DATETIME NOT NULL,
    check_out_time DATETIME,
    notes TEXT,
    
    CONSTRAINT fk_al_member FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE CASCADE
);
