# Database ERD

Generated from `src/main/resources/db/migration/V1__INIT.sql`. Update this diagram whenever a new Flyway migration changes the schema.

```mermaid
erDiagram
    ACCOUNT ||--o{ FOLLOW : "is follower in"
    ACCOUNT ||--o{ FOLLOW : "is followed in"
    ACCOUNT ||--o{ DIARY_ENTRY : logs
    FILM ||--o{ DIARY_ENTRY : "logged as"
    DIARY_ENTRY ||--o{ COMMENT : has
    ACCOUNT ||--o{ COMMENT : writes
    DIARY_ENTRY ||--o{ DIARY_ENTRY_LIKE : has
    ACCOUNT ||--o{ DIARY_ENTRY_LIKE : gives
    ACCOUNT ||--o{ SESSION : has
    ACCOUNT ||--o{ VERIFICATION_TOKEN : has

    ACCOUNT {
        uuid id PK
        varchar email UK
        varchar username UK
        varchar password_hash
        boolean email_verified
        varchar city
        varchar country
        date date_of_birth
        varchar avatar_type
        varchar avatar_key
    }

    FILM {
        uuid id PK
        varchar tmdb_id UK
        varchar title
        varchar poster_url
        varchar synopsis
        date release_date
    }

    FOLLOW {
        uuid follower_id PK_FK
        uuid followed_id PK_FK
    }

    DIARY_ENTRY {
        uuid id PK
        uuid account_id FK
        uuid film_id FK
        decimal rating
        text review_text
        timestamp created_at
    }

    COMMENT {
        uuid id PK
        uuid diary_entry_id FK
        uuid account_id FK
        text comment_text
        timestamp created_at
    }

    DIARY_ENTRY_LIKE {
        uuid diary_entry_id PK_FK
        uuid account_id PK_FK
    }

    SESSION {
        uuid id PK
        uuid account_id FK
        timestamp expires_at
    }

    VERIFICATION_TOKEN {
        uuid id PK
        uuid account_id FK
        varchar type
        timestamp expires_at
        timestamp used_at
    }
```

## Notes

- `FOLLOW` and `DIARY_ENTRY_LIKE` are pure join tables with composite primary keys (both columns are `PK, FK` — marked `PK_FK` above since Mermaid doesn't support a comma inside a single key tag).
- `FOLLOW` has two relationships to `ACCOUNT` because it's self-referencing: one account can follow many accounts, and be followed by many accounts.
- `session` and `verification_token` are not yet backed by a JPA entity in the codebase (as of the current backlog) — this diagram reflects the DB schema, not the current entity layer.
