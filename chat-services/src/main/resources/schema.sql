DROP TABLE IF EXISTS chat_messages;

CREATE TABLE IF NOT EXISTS chat_messages (
    id SERIAL PRIMARY KEY,
    sender_id INTEGER NOT NULL,
    receiver_id INTEGER NOT NULL,
    content TEXT NOT NULL,
    message_type TEXT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_sender_receiver ON chat_messages (sender_id, receiver_id);
CREATE INDEX IF NOT EXISTS idx_receiver ON chat_messages (receiver_id);