CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL
);

ALTER TABLE training_entries
    ADD COLUMN user_id BIGINT,
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id) REFERENCES users(id);
