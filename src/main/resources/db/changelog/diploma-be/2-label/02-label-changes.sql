CREATE TABLE diploma.label
(
    id          serial  primary key ,
    user_id      UUID NOT NULL,
    label_id     UUID  NOT NULL,
    description varchar(200) NOT NULL,
    name        varchar(20)  NOT NULL,
    created_at   timestamptz  NOT NULL
);
alter table diploma.label
add constraint fk_label_user
foreign key (user_id) references diploma.users (user_id);
