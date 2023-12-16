CREATE TABLE IF NOT EXISTS batch_students (
    id UUID PRIMARY KEY,
    batch_id UUID REFERENCES batch(id),
    student_id UUID REFERENCES users(id),
    discounted_fees NUMERIC(19, 2) NOT NULL,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS batch_course_instructor (
    id UUID PRIMARY KEY,
    batch_id UUID REFERENCES batch(id),
    course_id UUID REFERENCES courses(id),
    instructor_id UUID REFERENCES institute(id),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS lecture (
    id UUID PRIMARY KEY,
    bacoin_id UUID REFERENCES batch_course_instructor(id),
    name VARCHAR(255),
    description TEXT,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    recurring BOOLEAN DEFAULT false,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS exam (
    id UUID PRIMARY KEY,
    lecture_id UUID REFERENCES lecture(id),
    marks FLOAT,
    invigilator_id UUID REFERENCES staff(id),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS exam_results (
    id UUID PRIMARY KEY,
    lecture_id UUID REFERENCES lecture(id),
    student_id UUID REFERENCES users(id),
    staff_id UUID REFERENCES staff(id),
    marks FLOAT,
    remark VARCHAR(255),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS student_attendance (
    id UUID PRIMARY KEY,
    staff_id UUID REFERENCES staff(id),
    lecture_id UUID REFERENCES lecture(id),
    student_id UUID REFERENCES users(id),
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS staff_attendance (
    id UUID PRIMARY KEY,
    staff_id UUID REFERENCES staff(id),
    processor_staff_id UUID REFERENCES staff(id),
    entry_time TIMESTAMP,
    exit_time TIMESTAMP,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS student_guardian (
    id UUID PRIMARY KEY,
    student_id UUID REFERENCES users(id),
    guardian_id UUID REFERENCES users(id),
    is_primary BOOLEAN DEFAULT false,
    created_on TIMESTAMP DEFAULT current_timestamp,
    updated_on TIMESTAMP DEFAULT current_timestamp
);