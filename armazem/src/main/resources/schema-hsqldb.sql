
    create table secao (
        id integer not null,
        descricao varchar(255),
        primary key (id)
    );
 
    
    create table tipo_produto (
       id integer not null,
        descricao varchar(255),
        volume_total_permitido double,
        primary key (id)
    );

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1;


 create table movimentacao_estoque (
       id bigint not null,
        data_lancamento timestamp,
        produto varchar(255),
        responsavel varchar(255),
        id_secao integer,
        id_tipo_produto integer,
        volume double,
        primary key (id)
    );



    alter table movimentacao_estoque 
       add constraint fk_secao 
       foreign key (id_secao) 
       references secao;

    
    alter table movimentacao_estoque 
       add constraint fk_tipo_secao
       foreign key (id_tipo_produto) 
       references tipo_produto;
