CREATE TABLE IF NOT EXISTS students_reg (
	st_id serial PRIMARY KEY,
	st_email VARCHAR NOT NULL,
	st_pass VARCHAR NOT NULL,
    st_firstName VARCHAR,
	st_lastName VARCHAR,
	st_age VARCHAR,
	st_city VARCHAR,
	st_country VARCHAR
);