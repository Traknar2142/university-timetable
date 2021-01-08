DROP TABLE IF EXISTS postgres.universityTimetable.t_subject_classroom_relation;
DROP TABLE IF EXISTS postgres.universityTimetable.t_subject_groups_relation;
DROP TABLE IF EXISTS postgres.universityTimetable.t_subject_teacher_relation;
DROP TABLE IF EXISTS postgres.universityTimetable.t_day_of_week_lesson_on_table_relation;
DROP TABLE IF EXISTS postgres.universityTimetable.t_classroom_inaccessibility;
DROP TABLE IF EXISTS postgres.universityTimetable.t_time_table;
DROP TABLE IF EXISTS postgres.universityTimetable.t_classrooms;
DROP TABLE IF EXISTS postgres.universityTimetable.t_day_of_week;
DROP TABLE IF EXISTS postgres.universityTimetable.t_groups;
DROP TABLE IF EXISTS postgres.universityTimetable.t_lesson_on_time_table;
DROP TABLE IF EXISTS postgres.universityTimetable.t_subject;
DROP TABLE IF EXISTS postgres.universityTimetable.t_teachers;
DROP TABLE IF EXISTS postgres.universityTimetable.t_time_intervals;

CREATE TABLE universityTimetable.t_classroom_inaccessibility
(
    time_interval_id bigint NOT NULL,
    classroom_id bigint NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_classroom_inaccessibility
    OWNER to postgres;


CREATE TABLE universityTimetable.t_time_intervals
(
    time_interval_id BIGSERIAL,
    begin_time timestamp without time zone NOT NULL,
    end_time timestamp without time zone NOT NULL,
    CONSTRAINT t_time_intervals_pkey PRIMARY KEY (time_interval_id)
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_time_intervals
    OWNER to postgres;


CREATE TABLE universityTimetable.t_classrooms
(
    classroom_id BIGSERIAL,
    room_number bigint NOT NULL,
    CONSTRAINT t_classrooms_pkey PRIMARY KEY (classroom_id)
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_classrooms
    OWNER to postgres;


ALTER TABLE universityTimetable.t_classroom_inaccessibility
ADD CONSTRAINT t_classroom_inaccessibility_classroom_id_fkey FOREIGN KEY (classroom_id)
        REFERENCES universityTimetable.t_classrooms (classroom_id) MATCH SIMPLE
        ON DELETE CASCADE ON UPDATE CASCADE
        NOT VALID,
ADD CONSTRAINT t_classroom_inaccessibility_time_interval_id_fkey FOREIGN KEY (time_interval_id)
        REFERENCES universityTimetable.t_time_intervals (time_interval_id) MATCH SIMPLE
        ON DELETE CASCADE ON UPDATE CASCADE
        NOT VALID;


CREATE TABLE universityTimetable.t_teachers
(
    teacher_id BIGSERIAL,
    first_name character varying COLLATE pg_catalog."default" NOT NULL,
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT t_teachers_pkey PRIMARY KEY (teacher_id)
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_teachers
    OWNER to postgres;


CREATE TABLE universityTimetable.t_subject
(
    subject_id BIGSERIAL,
    subject_name character varying COLLATE pg_catalog."default",
    CONSTRAINT t_subject_pkey PRIMARY KEY (subject_id)
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_subject
    OWNER to postgres;


CREATE TABLE universityTimetable.t_subject_classroom_relation
(
    subject_id bigint NOT NULL,
    classroom_id bigint NOT NULL,
    CONSTRAINT t_subject_classroom_relation_classroom_id_fkey FOREIGN KEY (classroom_id)
        REFERENCES universityTimetable.t_classrooms (classroom_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT t_subject_classroom_relation_subject_id_fkey FOREIGN KEY (subject_id)
        REFERENCES universityTimetable.t_subject (subject_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_subject_classroom_relation
    OWNER to postgres;


CREATE TABLE universityTimetable.t_subject_teacher_relation
(
    subject_id bigint NOT NULL,
    teacher_id bigint NOT NULL,
    CONSTRAINT t_subject_teacher_relation_subject_id_fkey FOREIGN KEY (subject_id)
        REFERENCES universityTimetable.t_subject (subject_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT t_subject_teacher_relation_teacher_id_fkey FOREIGN KEY (teacher_id)
        REFERENCES universityTimetable.t_teachers (teacher_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_subject_teacher_relation
    OWNER to postgres;
    

CREATE TABLE universityTimetable.t_groups
(
    group_id BIGSERIAL,
    group_name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT t_groups_pkey PRIMARY KEY (group_id)
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_groups
    OWNER to postgres;
    
    
CREATE TABLE universityTimetable.t_subject_groups_relation
(
    subject_id bigint NOT NULL,
    group_id bigint NOT NULL,
    CONSTRAINT t_subject_groups_relation_group_id_fkey FOREIGN KEY (group_id)
        REFERENCES universityTimetable.t_groups (group_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT t_subject_groups_relation_subject_id_fkey FOREIGN KEY (subject_id)
        REFERENCES universityTimetable.t_subject (subject_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_subject_groups_relation
    OWNER to postgres;


CREATE TABLE universityTimetable.t_lesson_on_time_table
(
    lesson_on_table_id BIGSERIAL,
    subject_id bigint NOT NULL,
    classroom_id bigint NOT NULL,
    teacher_id bigint NOT NULL,
    CONSTRAINT t_lesson_on_time_table_pkey PRIMARY KEY (lesson_on_table_id)
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_lesson_on_time_table
    OWNER to postgres;


CREATE TABLE universityTimetable.t_day_of_week
(
    day_of_week_id BIGSERIAL,
    name_of_day timestamp without time zone NOT NULL,
    CONSTRAINT t_day_of_week_pkey PRIMARY KEY (day_of_week_id)
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_day_of_week
    OWNER to postgres;


CREATE TABLE universityTimetable.t_day_of_week_lesson_on_table_relation
(
    day_of_week_id bigint NOT NULL,
    lesson_on_time_table_id bigint NOT NULL,
    CONSTRAINT t_day_of_week_lesson_on_table_rela_lesson_on_time_table_id_fkey FOREIGN KEY (lesson_on_time_table_id)
        REFERENCES universityTimetable.t_lesson_on_time_table (lesson_on_table_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT t_day_of_week_lesson_on_table_relation_day_of_week_id_fkey FOREIGN KEY (day_of_week_id)
        REFERENCES universityTimetable.t_day_of_week (day_of_week_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_day_of_week_lesson_on_table_relation
    OWNER to postgres;


CREATE TABLE universityTimetable.t_time_table
(
    day_of_week_id bigint NOT NULL,
    group_id bigint NOT NULL,
    CONSTRAINT t_time_table_day_of_week_id_fkey FOREIGN KEY (day_of_week_id)
        REFERENCES universityTimetable.t_day_of_week (day_of_week_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT t_time_table_group_id_fkey FOREIGN KEY (group_id)
        REFERENCES universityTimetable.t_groups (group_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE universityTimetable.t_time_table
    OWNER to postgres;