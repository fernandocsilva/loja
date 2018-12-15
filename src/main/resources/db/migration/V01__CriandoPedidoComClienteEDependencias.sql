create table cliente (
       id  bigserial not null,
        email varchar(255),
        nome varchar(255),
        senha varchar(255),
        endereco_id int8,
        primary key (id)
    )

    create table endereco (
       id  bigserial not null,
        bairro varchar(255),
        cep varchar(255),
        cidade varchar(255),
        estado varchar(255),
        rua varchar(255),
        primary key (id)
    )

    create table pedido (
       id  bigserial not null,
        data_do_pedido timestamp,
        status_do_pedido int4,
        cliente_id int8,
        primary key (id)
    )

    create table pedido_item (
       id  bigserial not null,
        quantidade int4,
        total numeric(19, 2),
        valor numeric(19, 2),
        pedido_id int8,
        produto_id int8,
        primary key (id)
    )

    alter table if exists cliente
       add constraint FK64nr9yt889by5lufr1boo5i4s
       foreign key (endereco_id)
       references endereco

    alter table if exists pedido
       add constraint FK30s8j2ktpay6of18lbyqn3632
       foreign key (cliente_id)
       references cliente

    alter table if exists pedido_item
       add constraint FKeyouxfvoi291lpo5168e6wpej
       foreign key (pedido_id)
       references pedido

    alter table if exists pedido_item
       add constraint FK8eyfr31j751fjws2y012awmpg
       foreign key (produto_id)
       references produto