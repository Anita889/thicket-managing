CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(255) unique not null ,
                       password VARCHAR(255) unique not null ,
                       user_role VARCHAR(50)
);

CREATE TABLE projects (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description VARCHAR(1000)
);

CREATE TABLE categories (
                            id BIGSERIAL PRIMARY KEY,
                            name VARCHAR(255),
                            project_id BIGINT,
                            CONSTRAINT fk_category_project
                                FOREIGN KEY (project_id)
                                    REFERENCES projects(id)
                                    ON DELETE CASCADE
);

CREATE TABLE tickets (
                         id BIGSERIAL PRIMARY KEY,
                         title VARCHAR(255),
                         description VARCHAR(1000),
                         status VARCHAR(50),
                         created_at TIMESTAMP,
                         category_id BIGINT,
                         user_id BIGINT,

                         CONSTRAINT fk_ticket_category
                             FOREIGN KEY (category_id)
                                 REFERENCES categories(id)
                                 ON DELETE SET NULL,

                         CONSTRAINT fk_ticket_user
                             FOREIGN KEY (user_id)
                                 REFERENCES users(id)
                                 ON DELETE SET NULL
);

CREATE TABLE comments (
                          id BIGSERIAL PRIMARY KEY,
                          content VARCHAR(1000),
                          created_at TIMESTAMP,
                          ticket_id BIGINT,
                          user_id BIGINT,

                          CONSTRAINT fk_comment_ticket
                              FOREIGN KEY (ticket_id)
                                  REFERENCES tickets(id)
                                  ON DELETE CASCADE,

                          CONSTRAINT fk_comment_user
                              FOREIGN KEY (user_id)
                                  REFERENCES users(id)
                                  ON DELETE SET NULL
);