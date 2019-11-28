function addLog(profile, timestamp, registro) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8087/public/log/',

        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(
            {
                user: profile.getEmail(),
                timestamp: timestamp,
                registro: registro
            }
        )
    });
}

function onSignIn() {
    var googleUser = gapi.auth2.getAuthInstance().currentUser.get();
    var profile = googleUser.getBasicProfile();
    var timestamp = new Date();

    $('#googleButton').addClass('hidden');
    $('#email').removeClass('hidden');
    $('#email').text('Bem-vindo(a) ' + profile.getName());
    $('#signOut').removeClass('hidden');

    addLog(profile, timestamp, 'login');
}

function signOut() {
    var googleUser = gapi.auth2.getAuthInstance().currentUser.get();
    var profile = googleUser.getBasicProfile();
    var timestamp = new Date();
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        location.reload();

        addLog(profile, timestamp, 'logout')
    });
}

function logar() {
    var username = $('#inputEmail').val();
    var password = $('#inputPassword').val();

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8087/public/admin/',

        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(
            {
                username: username,
                password: password
            }
        ),

        success: function (data) {
            if (data) {
                location.href = 'admin.html'
            }
        },

        error: function (data) {
            alert('Usuario e/ou Senha invalidos! Tente novamente!');
            $('#inputEmail').val('');
            $('#inputPassword').val('');
        }
    });
}

