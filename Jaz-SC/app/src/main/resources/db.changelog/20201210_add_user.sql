DROP TABLE test1;

CREATE TABLE "user"(
    id BIGINT NOT NULL,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT unique_username UNIQUE(username)
);

CREATE TABLE user_role(
    user_id BIGINT NOT NULL,
    role VARCHAR(100) NOT NULL,

    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES "user"(id)
)