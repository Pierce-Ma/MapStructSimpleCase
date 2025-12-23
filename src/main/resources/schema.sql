-- 创建每日步数汇总表
CREATE TABLE IF NOT EXISTS daily_step_summaries (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    record_date DATE NOT NULL,
    total_duration DECIMAL(10, 2),
    total_energy INT,
    target_percent INT,
    overall_status INT,
    interpretation TEXT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_user_date (user_id, record_date)
);

