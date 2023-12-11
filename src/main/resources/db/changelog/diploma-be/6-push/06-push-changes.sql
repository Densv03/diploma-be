CREATE TABLE diploma.push
(
    id                 serial primary key,
    title              varchar(200) NOT NULL,
    template           varchar(200) NOT NULL,
    created_at         timestamptz NOT NULL,
    using_place_holder BOOLEAN     default false,
    from_name          varchar(40) DEFAULT NULL,
    email              varchar(40) DEFAULT NULL
);
