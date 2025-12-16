
-- 스키마 생성
CREATE DATABASE IF NOT EXISTS matchdb DEFAULT CHARACTER SET utf8mb4;
USE matchdb;

-- 사용자 테이블
CREATE TABLE IF NOT EXISTS users (
    user_id VARCHAR(50) PRIMARY KEY,
    email VARCHAR(100),
    password VARCHAR(100),
    favorite_team VARCHAR(50)
);

-- 경기 일정 테이블
CREATE TABLE IF NOT EXISTS match_schedule (
    match_id VARCHAR(50) PRIMARY KEY,
    match_date DATE,
    start_time TIME,
    team_a VARCHAR(50),
    team_b VARCHAR(50),
    location VARCHAR(100),
    score_a INT,
    score_b INT
);

-- 댓글 테이블
CREATE TABLE IF NOT EXISTS comments (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    match_id VARCHAR(50),
    content TEXT,
    timestamp DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (match_id) REFERENCES match_schedule(match_id)
);


-- 상위 50경기 INSERT 문
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G01', '2025-05-01', '18:00', 'T1', 'GEN', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G02', '2025-05-02', '17:00', 'T1', 'KT', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G03', '2025-05-03', '18:00', 'T1', 'HLE', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G04', '2025-05-04', '17:00', 'T1', 'DK', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G05', '2025-05-07', '18:00', 'T1', 'DRX', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G06', '2025-05-08', '17:00', 'T1', 'NS', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G07', '2025-05-09', '18:00', 'T1', 'BRO', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G08', '2025-05-10', '17:00', 'GEN', 'KT', '서울 롤파크', 1, 2);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G09', '2025-05-11', '18:00', 'GEN', 'HLE', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G10', '2025-05-14', '17:00', 'GEN', 'DK', '서울 롤파크', 0, 2);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G11', '2025-05-15', '18:00', 'GEN', 'DRX', '서울 롤파크', 1, 2);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G12', '2025-05-16', '17:00', 'GEN', 'NS', '서울 롤파크', 0, 2);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G13', '2025-05-17', '18:00', 'GEN', 'BRO', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G14', '2025-05-18', '17:00', 'KT', 'HLE', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G15', '2025-05-21', '18:00', 'KT', 'DK', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G16', '2025-05-22', '17:00', 'KT', 'DRX', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G17', '2025-05-23', '18:00', 'KT', 'NS', '서울 롤파크', 2, 1);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G18', '2025-05-24', '17:00', 'KT', 'BRO', '서울 롤파크', 1, 2);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G19', '2025-05-25', '18:00', 'HLE', 'DK', '서울 롤파크', 1, 2);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G20', '2025-05-28', '17:00', 'HLE', 'DRX', '서울 롤파크', 2, 1);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G21', '2025-05-29', '18:00', 'HLE', 'NS', '서울 롤파크', 2, 1);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G22', '2025-05-30', '17:00', 'HLE', 'BRO', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G23', '2025-05-31', '18:00', 'DK', 'DRX', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G24', '2025-06-01', '17:00', 'DK', 'NS', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G25', '2025-06-04', '18:00', 'DK', 'BRO', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G26', '2025-06-05', '17:00', 'DRX', 'NS', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G27', '2025-06-06', '18:00', 'DRX', 'BRO', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G28', '2025-06-07', '17:00', 'NS', 'BRO', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G29', '2025-06-08', '18:00', 'T1', 'GEN', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G30', '2025-06-11', '17:00', 'T1', 'KT', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G31', '2025-06-12', '18:00', 'T1', 'HLE', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G32', '2025-06-13', '17:00', 'T1', 'DK', '서울 롤파크', 2, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G33', '2025-06-14', '18:00', 'T1', 'DRX', '서울 롤파크', 2, 1);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G34', '2025-06-15', '17:00', 'T1', 'NS', '서울 롤파크', 2, 1);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G35', '2025-06-18', '18:00', 'T1', 'BRO', '서울 롤파크', 2, 1);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G36', '2025-06-19', '17:00', 'GEN', 'KT', '서울 롤파크', 1, 2);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G37', '2025-06-20', '18:00', 'GEN', 'HLE', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G38', '2025-06-21', '17:00', 'GEN', 'DK', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G39', '2025-06-22', '18:00', 'GEN', 'DRX', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G40', '2025-06-25', '17:00', 'GEN', 'NS', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G41', '2025-06-26', '18:00', 'GEN', 'BRO', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G42', '2025-06-27', '17:00', 'KT', 'HLE', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G43', '2025-06-28', '18:00', 'KT', 'DK', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G44', '2025-06-29', '17:00', 'KT', 'DRX', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G45', '2025-07-02', '18:00', 'KT', 'NS', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G46', '2025-07-03', '17:00', 'KT', 'BRO', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G47', '2025-07-04', '18:00', 'HLE', 'DK', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G48', '2025-07-05', '17:00', 'HLE', 'DRX', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G49', '2025-07-06', '18:00', 'HLE', 'NS', '서울 롤파크', 0, 0);
INSERT INTO match_schedule (match_id, match_date, start_time, team_a, team_b, location, score_a, score_b) VALUES ('LCK2025S1G50', '2025-07-09', '17:00', 'HLE', 'BRO', '서울 롤파크', 0, 0);
