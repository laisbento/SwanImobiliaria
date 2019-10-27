function scheduleVisit() {
    var queryId = decodeURIComponent(window.location.search);
    queryId = queryId.substring(4);

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8087/imoveis/' + queryId,

        success: function (data) {
            var thumb = document.createElement('img');
            $('#imagem-choosen').append(thumb);
            thumb.setAttribute("src", data.thumbnail);
            thumb.setAttribute("width", "500");
            thumb.setAttribute("height", "400");

            $('#tipo').text(data.businessType + ' - ' + data.propertyType + ' - R$ ' + data.valor);
            $('#cidade').text(data.cidade + ', ' + data.estado);
            $('#quartos').text('Quartos: ' + data.quartos);
            $('#banheiros').text('Banheiros: ' + data.banheiros);
            $('#vaga').text('Vagas: ' + data.vagas);
            $('#area').text('Area: ' + data.area + ' m2');

            localMap(data.lat, data.lng);
        }
    });
}

function agendar() {
    var nome = $('#inputName').val();
    var email = $('#inputEmail').val();
    var data = $('#inputDate').val();
    var telefone = $('#inputPhone').val();

    var queryId = decodeURIComponent(window.location.search);
    queryId = queryId.substring(4);

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8087/visitas/',

        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(
            {
                name: nome,
                email: email,
                visitDate: data,
                phone: telefone,
                propertyId: queryId
            }
        ),

        success: function (data) {
            alert("Sua visita foi agendada com sucesso!");
        }
    });
}
