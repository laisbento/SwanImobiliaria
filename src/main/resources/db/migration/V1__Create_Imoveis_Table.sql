create table imoveis
(
    tipo_imovel varchar(15) not null,
    rua varchar(300),
    numero varchar(5),
    cidade varchar(150),
    estado varchar(2),
    cep integer,
    quartos integer,
    banheiros integer,
    vagas integer,
    area numeric(7, 2),
    tipo_negocio varchar(7) not null,
    thumbnail varchar(500),
    valor numeric(10, 2),
    lat varchar(20),
    lng varchar(20),
    cod_ref serial unique not null primary key
);