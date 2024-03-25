DROP TABLE IF EXISTS subscriptions;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS rooms;

CREATE TABLE IF NOT EXISTS  users (
    id SERIAL PRIMARY KEY,
    password_hash TEXT NOT NULL,
    username TEXT NOT NULL,
    email TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS rooms (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT idx_name_unique UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS subscriptions (
    user_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES rooms(id),
    PRIMARY KEY (user_id, room_id)
);
