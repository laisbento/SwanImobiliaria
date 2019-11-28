function loadProperties() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8087/public/imoveis/',

        success: function (data) {
            var i;
            for (i = 1; i <= 3; i++) {
                var j = Math.floor(Math.random() * (data.length));
                var temp = data[j];

                $('#matricula'.concat(i)).text(temp.codRef);
                $('#tipo'.concat(i)).text(temp.businessType + ' - ' + temp.propertyType);
                $('#valor'.concat(i)).text('R$ ' + temp.valor);
                $('#cidade'.concat(i)).text(temp.cidade + ', ' + temp.estado);

                var thumb = document.createElement('img');
                $('#imagem'.concat(i)).append(thumb);
                thumb.setAttribute("src", temp.thumbnail);
                thumb.setAttribute("width", "304");
                thumb.setAttribute("height", "228");
            }

        }
    });
}

function loadChoosen(num) {
    var id = $('#matricula'.concat(num)).text();
    var query = "?id=" + id;
    window.location.href = "choosen.html" + query;
}

function localMap(lat, lng) {
    var options = {
        center: {
            lat: parseFloat(lat),
            lng: parseFloat(lng)
        },
        zoom: 16
    };

    var map = new google.maps.Map(document.getElementById('map'), options);

    var marker = new google.maps.Marker({
        position: {
            lat: parseFloat(lat),
            lng: parseFloat(lng)
        },
        map: map
    });
}