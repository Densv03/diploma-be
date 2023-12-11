CREATE TABLE diploma.users
(
    id       serial primary key,
    user_id   uuid unique NOT NULL,
    name      varchar(20) NOT NULL,
    last_name  varchar(20) NOT NULL,
    email     varchar(20) NOT NULL UNIQUE,
    password  varchar(20)  NOT NULL,
    encrypted_password  varchar(100)  NOT NULL,
    email_verification_token  varchar(100),
    email_verification_status  boolean  default false
);
