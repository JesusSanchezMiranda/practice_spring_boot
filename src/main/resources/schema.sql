CREATE TABLE users (
    users_id int IDENTITY(1,1),
    document_type CHAR(3) NOT NULL,
    document_number VARCHAR(20) NOT NULL,
    name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    cellphone CHAR(9) NOT NULL,
    email VARCHAR(120) NOT NULL,
    role CHAR(1)NOT NULL CHECK (role IN ('A', 'E', 'C')),
    registration_date DATETIME NOT NULL DEFAULT GETDATE(),
    state CHAR(1)CHECK (state IN ('A', 'I')) DEFAULT 'A',
    CONSTRAINT users_pk PRIMARY KEY  (users_id),
	CONSTRAINT uq_users_document UNIQUE (document_number),
	CONSTRAINT uq_users_email UNIQUE (email)
);