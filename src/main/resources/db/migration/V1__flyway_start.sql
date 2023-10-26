CREATE TABLE contact (
    id UUID PRIMARY KEY,
    email VARCHAR(255),
    phone_number VARCHAR(20),
    address VARCHAR(255),
    address_pin VARCHAR(10),
    created_on TIMESTAMP,
    updated_on TIMESTAMP
);

CREATE TABLE user_profile (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    contact_id UUID REFERENCES contact (id),
    date_of_birth VARCHAR(255),
    primary_goal VARCHAR(255),
    created_on TIMESTAMP,
    updated_on TIMESTAMP
);

CREATE TABLE institute (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    user_name VARCHAR(255),
    motto VARCHAR(255),
    about TEXT,
    established_on DATE,
    owner_user_id UUID REFERENCES user_profile(id),
    contact_id UUID REFERENCES contact(id),
    created_on TIMESTAMP,
    updated_on TIMESTAMP
);

CREATE TABLE courses (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    institute_id UUID REFERENCES institute(id),
    category VARCHAR(50),
    batch_size INT,
    instructor_id INT,
    fees INT,
    created_on TIMESTAMP,
    updated_on TIMESTAMP
);

CREATE TABLE institute_branch (
    id UUID PRIMARY KEY,
    institute_id UUID REFERENCES institute(id),
    name VARCHAR(255),
    about TEXT,
    established_on DATE,
    contact_id UUID REFERENCES contact(id),
    is_main_branch BOOLEAN,
    created_on TIMESTAMP,
    updated_on TIMESTAMP
);

CREATE TABLE student_courses (
    id UUID PRIMARY KEY,
    student_id UUID REFERENCES user_profile(id),
    course_id UUID REFERENCES courses(id),
    discounted_fees VARCHAR(255),
    created_on TIMESTAMP,
    updated_on TIMESTAMP
);
