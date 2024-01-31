create table _address
(
    id         bigint not null auto_increment,
    builder    varchar(255),
    city       varchar(255),
    country    varchar(255),
    cliente_id bigint,
    primary key (id)
) engine = InnoDB;
create table _order
(
    id           bigint not null auto_increment,
    date_created datetime(6),
    delivery     varchar(255),
    payment      varchar(255),
    status       bit    not null,
    client_id    bigint,
    primary key (id)
) engine = InnoDB;
create table attribute
(
    id          bigint not null auto_increment,
    description varchar(255),
    name        varchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_has_product
(
    id           bigint not null auto_increment,
    attribute_id bigint,
    producte_id  bigint,
    primary key (id)
) engine = InnoDB;
create table brands
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
create table category
(
    id          bigint not null auto_increment,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    primary key (id)
) engine = InnoDB;
create table clients
(
    id         bigint  not null,
    age        integer not null,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    phone      integer not null,
    primary key (id)
) engine = InnoDB;
create table product_has_order
(
    id         bigint  not null auto_increment,
    quantity   integer not null,
    order_id   bigint,
    product_id bigint,
    primary key (id)
) engine = InnoDB;
create table products
(
    id          bigint not null auto_increment,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    price       decimal(38, 2),
    brand_id    bigint,
    category_id bigint,
    primary key (id)
) engine = InnoDB;
create table rolers
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
create table users
(
    id       bigint not null auto_increment,
    password varchar(255),
    username varchar(255),
    primary key (id)
) engine = InnoDB;
create table users_rolesset
(
    users_id    bigint not null,
    rolesset_id bigint not null,
    primary key (users_id, rolesset_id)
) engine = InnoDB;
alter table _address
    add constraint FKnix5grh7trnvtthicrqi2jt7e foreign key (cliente_id) references clients (id);
alter table _order
    add constraint FKdr1hf5kgevnhwb3adi2p9qm1p foreign key (client_id) references clients (id);
alter table attribute_has_product
    add constraint FKaqflkuf85xwswl7ypsjjhht6a foreign key (attribute_id) references attribute (id);
alter table attribute_has_product
    add constraint FKj9h4evjhcdbuwm78s198x53d2 foreign key (producte_id) references products (id);
alter table clients
    add constraint FK1hgwdp9vl25xl9i7s354sifey foreign key (id) references users (id);
alter table product_has_order
    add constraint FK4sx8safku3mpls0cdw7ng5br8 foreign key (order_id) references _order (id);
alter table product_has_order
    add constraint FKfgp6lkbm40x2ofocigdkfm1io foreign key (product_id) references products (id);
alter table products
    add constraint FKa3a4mpsfdf4d2y6r8ra3sc8mv foreign key (brand_id) references brands (id);
alter table products
    add constraint FK1cf90etcu98x1e6n9aks3tel3 foreign key (category_id) references category (id);
alter table users_rolesset
    add constraint FKfyvjgad65f7rtqsbrw1hviqxr foreign key (rolesset_id) references rolers (id);
alter table users_rolesset
    add constraint FKt7213is417582bjg6e95g5w53 foreign key (users_id) references users (id);