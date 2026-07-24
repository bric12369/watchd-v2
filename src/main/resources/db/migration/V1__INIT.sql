CREATE TABLE account(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(30) NOT NULL UNIQUE,
    password_hash VARCHAR NOT NULL,
    email_verified BOOLEAN NOT NULL,
    city VARCHAR(58),
    country VARCHAR(30),
    date_of_birth DATE,
    avatar_type VARCHAR CHECK(avatar_type IN ('preset', 'uploaded')),
    avatar_key VARCHAR
);

CREATE TABLE film(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tmdb_id VARCHAR NOT NULL UNIQUE,
    title VARCHAR NOT NULL,
    poster_url VARCHAR,
    synopsis VARCHAR,
    release_date DATE
);

CREATE TABLE follow(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    follower_id UUID NOT NULL REFERENCES account(id) ON DELETE CASCADE,
    followed_id UUID NOT NULL REFERENCES account(id) ON DELETE CASCADE,
    UNIQUE (follower_id, followed_id)
);

CREATE TABLE diary_entry(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id UUID NOT NULL REFERENCES account(id),
    film_id UUID NOT NULL REFERENCES film(id),
    rating DECIMAL(2, 1) NOT NULL,
    review_text TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE comment(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    diary_entry_id UUID NOT NULL REFERENCES diary_entry(id),
    account_id UUID NOT NULL REFERENCES account(id),
    comment_text TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE diary_entry_like(
    diary_entry_id UUID NOT NULL REFERENCES diary_entry(id),
    account_id UUID NOT NULL REFERENCES account(id),
    PRIMARY KEY (diary_entry_id, account_id)
);

CREATE TABLE session(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id UUID NOT NULL REFERENCES account(id),
    expires_at TIMESTAMP
);

CREATE TABLE verification_token(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id UUID NOT NULL REFERENCES account(id),
    type VARCHAR,
    expires_at TIMESTAMP,
    used_at TIMESTAMP
);