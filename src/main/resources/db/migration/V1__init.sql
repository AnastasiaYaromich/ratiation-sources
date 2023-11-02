CREATE TABLE radiation.departments (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE radiation.directions (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    department_id BIGINT REFERENCES radiation.departments (id)
);

CREATE TABLE radiation.radiation_sources (
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(255),
    activity DECIMAL,
    half_life DECIMAL,
    manufacture_at DATE,
    direction_id BIGINT REFERENCES radiation.directions (id)
);

CREATE TABLE radiation.users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(36) NOT NULL,
    password VARCHAR(80) NOT NULL,
    email VARCHAR(50) UNIQUE
);

CREATE TABLE radiation.roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE radiation.users_roles (
     user_id BIGINT NOT NULL REFERENCES users(id),
     role_id BIGINT NOT NULL REFERENCES roles (id),
     primary key (user_id, role_id)
);