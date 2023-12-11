CREATE TABLE diploma.receiver_user
(
    id      serial primary key,
    group_id int   NOT NULL,
    email   varchar(200) NOT NULL
);
alter table diploma.receiver_user
    add constraint fk_group_user
        foreign key (group_id) references diploma.groups(id);
