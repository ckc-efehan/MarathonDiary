CREATE TABLE training_entries (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  date DATE NOT NULL,
                                  target_time DOUBLE PRECISION NOT NULL,
                                  target_kilometre DOUBLE PRECISION NOT NULL,
                                  kilometre_ran DOUBLE PRECISION NOT NULL,
                                  time_ran DOUBLE PRECISION NOT NULL,
                                  goal_reached BOOLEAN NOT NULL
);
