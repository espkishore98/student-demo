-- Database: college_project

-- DROP DATABASE college_project;

CREATE DATABASE college_project
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_India.1252'
    LC_CTYPE = 'English_India.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
==================================================================================
-- Table: public.department

-- DROP TABLE public.department;

CREATE TABLE public.department
(
    id bigint NOT NULL,
    department_id character varying(200) COLLATE pg_catalog."default",
    department_name character varying(200) COLLATE pg_catalog."default",
    created_on timestamp(6) without time zone,
    modified_on timestamp(6) without time zone,
    CONSTRAINT department_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.department
    OWNER to postgres;
====================================================================================
-- Table: public.student

-- DROP TABLE public.student;

CREATE TABLE public.student
(
    id bigint NOT NULL,
    roll_number character varying(200) COLLATE pg_catalog."default",
    name character varying(200) COLLATE pg_catalog."default",
    address character varying(200) COLLATE pg_catalog."default",
    email_address character varying(200) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    modified_on timestamp without time zone,
    department_id bigint,
    CONSTRAINT student_pkey PRIMARY KEY (id),
    CONSTRAINT student_department_id_fkey FOREIGN KEY (department_id)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.student
    OWNER to postgres;

-- Index: department_fk

-- DROP INDEX public.department_fk;

CREATE INDEX department_fk
    ON public.student USING btree
    (department_id)
    TABLESPACE pg_default;
==================================================================================
-- Table: public.faculty

-- DROP TABLE public.faculty;

CREATE TABLE public.faculty
(
    id bigint NOT NULL,
    faculty_id character varying(200) COLLATE pg_catalog."default",
    name character varying(200) COLLATE pg_catalog."default",
    address character varying(200) COLLATE pg_catalog."default",
    email_address character varying(200) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    modified_on timestamp without time zone,
    department_id bigint,
    CONSTRAINT faculty_pkey PRIMARY KEY (id),
    CONSTRAINT fk_department FOREIGN KEY (department_id)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.faculty
    OWNER to postgres;

-- Index: fki_fk_department

-- DROP INDEX public.fki_fk_department;

CREATE INDEX fki_fk_department
    ON public.faculty USING btree
    (department_id)
    TABLESPACE pg_default;
=============================================================================
-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    id bigint NOT NULL,
    user_id character varying(200) COLLATE pg_catalog."default",
    first_name character varying(200) COLLATE pg_catalog."default",
    last_name character varying(200) COLLATE pg_catalog."default",
    email_address character varying(200) COLLATE pg_catalog."default",
    password character varying(200) COLLATE pg_catalog."default",
    type character varying(200) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    modified_on timestamp without time zone,
    student_id bigint,
    faculty_id bigint,
    department_id bigint,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT department_fk FOREIGN KEY (department_id)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT faculty_fk FOREIGN KEY (faculty_id)
        REFERENCES public.faculty (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT student_fk FOREIGN KEY (student_id)
        REFERENCES public.student (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;

-- Index: fki_department_fk

-- DROP INDEX public.fki_department_fk;

CREATE INDEX fki_department_fk
    ON public.users USING btree
    (department_id)
    TABLESPACE pg_default;

-- Index: fki_faculty_fk

-- DROP INDEX public.fki_faculty_fk;

CREATE INDEX fki_faculty_fk
    ON public.users USING btree
    (faculty_id)
    TABLESPACE pg_default;

-- Index: fki_student_fk

-- DROP INDEX public.fki_student_fk;

CREATE INDEX fki_student_fk
    ON public.users USING btree
    (student_id)
    TABLESPACE pg_default;
====================================================================