create table pessoas(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    idade int not null,
    posicao_fila bigint not null,

    primary key(id)
);