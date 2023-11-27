DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS todo;

CREATE TABLE category
(
    id    NUMBER(38, 0) GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title VARCHAR2(255),
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE todo
(
    id           NUMBER(38, 0) GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title        VARCHAR2(255),
    contents     VARCHAR2(255),
    complete_chk NUMBER(1),
    start_time   date,
    category_id  NUMBER(38, 0),
    CONSTRAINT pk_todo PRIMARY KEY (id)
);

ALTER TABLE todo
    ADD CONSTRAINT FK_TODO_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);