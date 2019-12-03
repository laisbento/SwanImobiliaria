function checkButton(num) {
    console.log(num);
    switch (num) {
        case 1:
            var campo = document.getElementById("r1");
            campo.checked = true;
            break;
        case 2:
            document.getElementById("r2").checked = true;
            break;
        case 3:
            document.getElementById("r3").checked = true;
            break;
        case 4:
            document.getElementById("r4").checked = true;
            break;
    }
}

function filtrar() {
    cleanDivs(1);
    cleanDivs(2);
    cleanDivs(3);

    var tipoImovel = $('#options').val();
    var cidade = $('#inputAddress').val();
    var precoDe = $('#de').val();
    var precoPara = $('#para').val()
    var radioQuarto = document.querySelector('input[name="quartos"]:checked');

    cidade = cidade.split(",");

    //PADRÃO PRA BUSCA DE QUARTOS
    var numeroQuartos = 1;
    if (radioQuarto != null) {
        numeroQuartos = document.querySelector('input[name="quartos"]:checked').value;
    }

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8087/public/imoveis/search?propertyType=' + tipoImovel +
            '&city=' + cidade[0] +
            '&rooms=' + numeroQuartos +
            '&priceFrom=' + precoDe +
            '&priceTo=' + precoPara,

        success: function (data) {
            var aux = 0;
            for (var i = 0; i < data.length; i++) {
                if (aux < 3) {
                    aux++;
                    showAgain(aux);
                    var temp = data[i];
                    $('#tipo'.concat(aux)).text(temp.businessType + ' - ' + temp.propertyType);
                    $('#matricula'.concat(aux)).text(temp.codRef);
                    $('#valor'.concat(aux)).text('R$ ' + temp.valor);
                    $('#cidade'.concat(aux)).text(temp.cidade + ', ' + temp.estado);

                    var thumb = document.createElement('img');
                    $('#imagem'.concat(aux)).append(thumb);
                    thumb.setAttribute("src", temp.thumbnail);
                    thumb.setAttribute("width", "304");
                    thumb.setAttribute("height", "228");
                }
            }

            $('#inputAddress').val('');
            $('#de').val('');
            $('#para').val('');
            $('#r1').checked = true;
        }
    });
}

function cleanDivs(num) {
    document.getElementById("divClass".concat(num)).style.visibility = "hidden";
    $('#tipo'.concat(num)).text('');
    $('#matricula'.concat(num)).text('');
    $('#valor'.concat(num)).text('');
    document.getElementById("imagem".concat(num)).innerHTML = "";
}

function showAgain(num) {
    document.getElementById("divClass".concat(num)).style.visibility = "visible";
}