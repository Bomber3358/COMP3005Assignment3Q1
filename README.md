# COMP3005Assignment3Q1
# Steps for running the code:
1. Create a database using the following schema OR with the provided DLL file:
   CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    enrollment_date DATE);
2. Insert initial data using the following SQL query:
   INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
    ('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
    ('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
    ('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
4. Project was built using IntelliJ with Maven.  I recommend using this IDE to ensure the project works properly
5. In the provided Main.java file you will likely need to adjust some variables in the main function.
   Specifically the url for the created database, username, and password for the user
6. Maven should handle all dependencies.  If for whatever reason it does not the only outside library I am
   using is JDBC version 42.7.3
7. All functions are present in the main function.  They will need to be commented in/out depending on which
   function you are testing
   
