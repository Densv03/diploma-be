CREATE TABLE diploma.template
(
    id                  serial primary key,
    label_id          bigint   NOT NULL,
    title            varchar(200) NOT NULL,
    template         varchar NOT NULL,
    created_at        timestamptz  NOT NULL,
    using_place_holder boolean      NOT NULL default false,
    from_name             varchar(40)
);

alter table diploma.template
    add constraint fk_group_user
        foreign key (label_id) references diploma.label(id);


