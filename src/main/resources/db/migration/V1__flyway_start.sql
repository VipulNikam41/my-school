CREATE TABLE IF NOT EXISTS contact (
    id UUID PRIMARY KEY,
    email VARCHAR(255),
    email_verified BOOLEAN DEFAULT false,
    phone_number VARCHAR(20),
    phone_number_verified BOOLEAN DEFAULT false,
    address VARCHAR(255),
    address_pin VARCHAR(20),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS profile_picture (
    id UUID PRIMARY KEY,
    color VARCHAR(255),
    image_link VARCHAR(255),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    profile_picture_id UUID REFERENCES profile_picture(id),
    name VARCHAR(255),
    contact_id UUID REFERENCES contact(id),
    date_of_birth VARCHAR(20),
    primary_goal VARCHAR(255),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);


CREATE TABLE IF NOT EXISTS user_credentials (
    user_id UUID PRIMARY KEY REFERENCES users(id),
    password VARCHAR(255) NOT NULL,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS institute (
    id UUID PRIMARY KEY,
    profile_picture_id UUID REFERENCES profile_picture(id),
    name VARCHAR(255),
    user_name VARCHAR(255),
    motto VARCHAR(255),
    about TEXT,
    established_on DATE,
    owner_id UUID,
    contact_id UUID REFERENCES contact(id),
    home_branch_id UUID REFERENCES institute(id),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE staff (
    id UUID PRIMARY KEY,
    institute_id UUID REFERENCES institute (id),
    profile_picture_id UUID REFERENCES profile_picture(id),
    name VARCHAR(255),
    contact_id UUID REFERENCES contact (id),
    date_of_birth VARCHAR(20),
    salary NUMERIC(19, 2) NOT NULL,
    primary_goal VARCHAR(255),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS staff_credentials (
    staff_id UUID PRIMARY KEY REFERENCES staff(id),
    password VARCHAR(255) NOT NULL,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

ALTER TABLE institute
ADD CONSTRAINT fk_institute_owner
FOREIGN KEY (owner_id) REFERENCES staff(id);

CREATE TABLE IF NOT EXISTS batch (
    id UUID PRIMARY KEY,
    profile_picture_id UUID REFERENCES profile_picture(id),
    name VARCHAR(255),
    description TEXT,
    institute_id UUID REFERENCES institute (id),
    batch_size INT,
    fees NUMERIC(19, 2) NOT NULL,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS courses (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    institute_id UUID REFERENCES institute(id),
    category_id INT,
    profile_picture_id UUID REFERENCES profile_picture(id),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS fees_records (
    id UUID PRIMARY KEY,
    institute_id UUID REFERENCES institute(id),
    cashier_id UUID REFERENCES staff(id),
    student_id UUID REFERENCES users(id),
    amount NUMERIC(19, 2) NOT NULL,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS salary_records (
    id UUID PRIMARY KEY,
    institute_id UUID REFERENCES institute(id),
    processor_staff_id UUID REFERENCES staff(id),
    staff_id UUID REFERENCES staff(id),
    amount NUMERIC(19, 2) NOT NULL,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS expenses (
    id UUID PRIMARY KEY,
    institute_id UUID REFERENCES institute(id),
    staff_id UUID REFERENCES staff(id),
    amount NUMERIC(19, 2) NOT NULL,
    description TEXT,
    approved BOOLEAN DEFAULT false,
    processor_staff_id UUID REFERENCES staff(id),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);
