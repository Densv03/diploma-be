CREATE TABLE diploma.groups
(
    id       serial primary key,
    user_id    uuid  NOT NULL,
    group_name varchar(200) NOT NULL
);

alter table diploma.groups
    add constraint fk_group_user
        foreign key (user_id) references diploma.users (user_id);
