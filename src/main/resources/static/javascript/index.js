$(document).ready(function () {
    function inicial() {
        $.ajax({
            url: "/cliente",
            success: function (response) {
                response.map((item) => {
                    var tr, td1, td2, td3, td4;
    
                    tr = $("<tr>");
                    td1 = $(`<td>${item.nome}</td>`);
                    td2 = $(`<td>${item.cpf}</td>`);
                    td3 = $(`<td>${item.sexo}</td>`);
                    td4 = $(`<td>${item.telefone}</td>`);
    
                    $("tbody").append(tr);
    
                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
                    tr.append(td4);
                });
            },
            error: function (response) {
                console.log("Falha!"+response);
            },
        });
    }

    inicial();

    $(".main-form").on("submit", function (event) {
        var data, nome, cpf, sexo, telefone;
        
        event.preventDefault();

        nome = $("#nome").val();
        cpf = $("#cpf").val();
        sexo = $("#sexo").val();
        telefone = $("#telefone").val();

        data = {
            nome: nome,
            cpf: cpf,
            sexo: sexo,
            telefone: telefone
        }

        $.ajax({
            url: "/cliente/salvar",
            method: "POST",
            data: data,
            success: function (response) {
                alert("Inserido com sucesso!");
                $("tbody").empty();
                inicial();
            },
            error: function (response) {
                alert("Erro ao inserir o cliente");
            }
        });
    });
});