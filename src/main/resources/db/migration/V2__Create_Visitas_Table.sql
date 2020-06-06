create table visitas
(
    id uuid,
    imovel integer constraint visitas_imoveis_cod_ref_fk references imoveis(cod_ref)
            on update cascade on delete cascade,
    nome varchar(200),
    email varchar(300),
    telefone varchar(20),
    data date
);

