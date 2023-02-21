create table computers (
    id bigint not null,
    name varchar(255),
    graphics_card_id bigint,
    primary key (id));
create table graphics_cards (
    id bigint not null,
    name varchar(255),
    price integer,
    primary key (id));
create table ordered_computers (
    order_id bigint not null,
    computer_id bigint not null);
create table orders (
    id bigint not null,
    name varchar(255),
    primary key (id));
create table processors (
    id bigint not null,
    name varchar(255),
    price integer,
    computer_id bigint,
    primary key (id));
alter table if exists computers add constraint
    FKqycrgvwi6diwig61jexudjtlk foreign key (graphics_card_id) references graphics_cards;
alter table if exists ordered_computers add constraint
    FKg0aeecoccyat8lqb8qolx5nmr foreign key (computer_id) references computers;
alter table if exists ordered_computers add constraint
    FKcvxinlpy1k9lj8utxe7u9yyca foreign key (order_id) references orders;
alter table if exists processors add constraint
    FK4778vi4u9xbck3yyw0ic4b2v0 foreign key (computer_id) references computers