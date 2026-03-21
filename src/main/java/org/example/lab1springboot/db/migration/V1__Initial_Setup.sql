CREATE TABLE book (
                      id BIGSERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      genre VARCHAR(255) NOT NULL,
                      published_date DATE NOT NULL
);

CREATE TABLE contact_messages (
                                  id BIGSERIAL PRIMARY KEY,
                                  first_name VARCHAR(255),
                                  last_name VARCHAR(255),
                                  email VARCHAR(255) NOT NULL,
                                  phone VARCHAR(50),
                                  message TEXT,
                                  submit VARCHAR(255),
                                  submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

