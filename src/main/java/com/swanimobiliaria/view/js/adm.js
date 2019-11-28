function insert() {
    $('#welcome').addClass('hidden');
    $('#imovel-insert-form').removeClass('hidden');
    $('#imovel-edit-form').addClass('hidden');
    $('#imovel-delete-form').addClass('hidden');

}

function edit() {
    $('#welcome').addClass('hidden');
    $('#imovel-insert-form').addClass('hidden');
    $('#imovel-edit-form').removeClass('hidden');
    $('#imovel-delete-form').addClass('hidden');
}

function del() {
    $('#welcome').addClass('hidden');
    $('#imovel-insert-form').addClass('hidden');
    $('#imovel-edit-form').addClass('hidden');
    $('#imovel-delete-form').removeClass('hidden');
}

function autoCompleteCep() {

    function limpa_formulario_cep() {

        $("#rua").val("");
        $("#cidade").val("");
        $("#uf").val("");
    }

    $("#cep").blur(function () {
        var cep = $(this).val().replace(/\D/g, '');

        if (cep != "") {

            var validacep = /^[0-9]{8}$/;

            if (validacep.test(cep)) {

                $("#rua").val("Pesquisando...");
                $("#cidade").val("Pesquisando...");
                $("#uf").val("Pesquisando...");

                $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

                    if (!("erro" in dados)) {
                        $("#rua").val(dados.logradouro);
                        $("#cidade").val(dados.localidade);
                        $("#uf").val(dados.uf);
                    } else {
                        limpa_formulario_cep();
                        alert("CEP não encontrado.");
                    }
                });
            } else {
                limpa_formulario_cep();
                alert("Formato de CEP inválido.");
            }
        } else {
            limpa_formulario_cep();
        }
    });
}

function salvarImovel() {
    var tipoImovel = $('#tipo-imovel').val();
    var tipoNegocio = $('#tipo-negocio').val();
    var cep = $('#cep').val().replace(/\D/g, '');
    var rua = $('#rua').val();
    var num = $('#numero').val();
    var cidade = $('#cidade').val();
    var uf = $('#uf').val();
    var area = $('#area').val();
    var foto = $('#foto').val();
    var quartos = $('#quartos').val();
    var banheiros = $('#banheiros').val();
    var vagas = $('#vagas').val();
    var valor = $('#valor').val();
    var lat = $('#lat').val();
    var lng = $('#lng').val();

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8087/public/imoveis/',

        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(
            {
                area: area,
                banheiros: banheiros,
                businessType: tipoNegocio,
                cep: cep,
                cidade: cidade,
                estado: uf,
                lat: lat,
                lng: lng,
                numero: num,
                propertyType: tipoImovel,
                quartos: quartos,
                rua: rua,
                thumbnail: foto,
                vagas: vagas,
                valor: valor
            }
        ),

        success: function (data) {
            alert('Imovel cadastrado com sucesso!');
            location.reload();
        },

        error: function (data) {
            alert('Houve um erro em sua solicitação. Verifique os dados enviados e tente novamente.');
        }

    });
}

function buscarImovelEdit() {
    var cod = $('#codref').val();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8087/public/imoveis/' + cod,

        success: function (data) {
            $('#editable-table').removeClass('hidden');

            $('#tipo-imovel-editable').val(data.propertyType);
            $('#tipo-negocio-editable').val(data.businessType);
            $('#cep-editable').val(data.cep);
            $('#rua-editable').val(data.rua);
            $('#numero-editable').val(data.numero);
            $('#cidade-editable').val(data.cidade);
            $('#uf-editable').val(data.estado);
            $('#area-editable').val(data.area);
            $('#foto-editable').val(data.thumbnail);
            $('#quartos-editable').val(data.quartos);
            $('#banheiros-editable').val(data.banheiros);
            $('#vagas-editable').val(data.vagas);
            $('#valor-editable').val(data.valor);
            $('#lat-editable').val(data.lat);
            $('#lng-editable').val(data.lng);

        }
    })
}

function buscarImovelDel() {
    var cod = $('#codref-del').val();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8087/public/imoveis/' + cod,

        success: function (data) {
            $('#del-table').removeClass('hidden');

            $('#tipo-imovel-del').val(data.propertyType);
            $('#tipo-negocio-del').val(data.businessType);
            $('#cep-del').val(data.cep);
            $('#rua-del').val(data.rua);
            $('#num-del').val(data.numero);
            $('#cidade-del').val(data.cidade);
            $('#uf-del').val(data.estado);
            $('#area-del').val(data.area);
            $('#foto-del').val(data.thumbnail);
        }
    })
}

function atualizar() {
    var codRef = $('#codref').val();
    var tipoImovel = $('#tipo-imovel-editable').val();
    var tipoNegocio = $('#tipo-negocio-editable').val();
    var cep = $('#cep-editable').val();
    var rua = $('#rua-editable').val();
    var num = $('#numero-editable').val();
    var cidade = $('#cidade-editable').val();
    var uf = $('#uf-editable').val();
    var area = $('#area-editable').val();
    var foto = $('#foto-editable').val();
    var quartos = $('#quartos-editable').val();
    var banheiros = $('#banheiros-editable').val();
    var vagas = $('#vagas-editable').val();
    var valor = $('#valor-editable').val();
    var lat = $('#lat-editable').val();
    var lng = $('#lng-editable').val();

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8087/public/imoveis/' + codRef,

        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(
            {
                area: area,
                banheiros: banheiros,
                businessType: tipoNegocio,
                cep: cep,
                cidade: cidade,
                estado: uf,
                lat: lat,
                lng: lng,
                numero: num,
                propertyType: tipoImovel,
                quartos: quartos,
                rua: rua,
                thumbnail: foto,
                vagas: vagas,
                valor: valor
            }
        ),

        success: function (data) {
            alert('Imovel atualizado com sucesso!');
            location.reload();
        },

        error: function (data) {
            alert('Houve um erro em sua solicitação. Verifique os dados enviados e tente novamente.');
        }

    });
}

function deletarImovel() {
    
}