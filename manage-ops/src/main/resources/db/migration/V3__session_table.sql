CREATE TABLE IF NOT EXISTS user_session (
    id UUID PRIMARY KEY,
    user_id UUID REFERENCES users(id),
    endsOn TIMESTAMP,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);