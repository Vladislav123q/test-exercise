create table purchase
(
    id   serial
        primary key,
    name varchar(255)
);
alter table purchase
    owner to postgres;

create table info_purchase_user
(
    id               bigserial
        primary key,
    age              integer          not null,
    amount           double precision not null,
    count            integer          not null,
    lastname         varchar(255),
    name             varchar(255),
    purchase_date    timestamp,
    purchase_item_id integer
        constraint fkc19aw7a5hpf8fsn8yau5tnk1q
            references purchase
);

alter table info_purchase_user
    owner to postgres;




