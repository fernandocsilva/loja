create table categoria (
   id  bigserial not null,
   nome varchar(255),
   primary key (id)
);

create table produto (
   id  bigserial not null,
    descricao varchar(255),
    nome_produto varchar(100),
    preco numeric(19, 2),
    quantidade int4,
    url_foto varchar(255),
    categoria_id int8,
    primary key (id)
);

alter table if exists produto
   add constraint FKopu9jggwnamfv0c8k2ri3kx0a
   foreign key (categoria_id)
   references categoria;