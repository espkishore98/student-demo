CREATE TABLE students
  ( 
     roll_number   INTEGER GENERATED BY DEFAULT AS IDENTITY, 
     student_name VARCHAR(255), 
     address     VARCHAR(255), 
     phone_number INTEGER, 
     PRIMARY KEY (roll_number) 
  )