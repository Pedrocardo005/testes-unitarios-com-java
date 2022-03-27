$(document).ready(function () {
    'use strict';
    function inicial() {
        $.ajax({
            url: "/cliente",
            success: function (response) {
                response.map((item) => {
                    var $tr, $td1, $td2, $td3, $td4, $del, $id;
    
                    $tr = $("<tr>");
                    $td1 = $(`<td>${item.nome}</td>`);
                    $td2 = $(`<td>${item.cpf}</td>`);
                    $td3 = $(`<td>${item.sexo}</td>`);
                    $td4 = $(`<td>${item.telefone}</td>`);
                    $del = $(`<button class="btn btn-danger">Deletar</button>`);
                    $id = $(`<input type="hidden" value="${item.id}"/>`);
    
                    $("tbody").append($tr);
    
                    $tr.append($id);
                    $tr.append($td1);
                    $tr.append($td2);
                    $tr.append($td3);
                    $tr.append($td4);
                    $tr.append($del);
                });
                $(".btn-danger").on("click", function (event) {
                    var $button;

                    $button = $(this);
                    console.log($button.closest("tr").find("input").val());
                    if (confirm("Deseja realmente excluir essa informação?")) {
                        // $.ajax({
                        //     url: "/cliente/deletar/",
                        //     method: "DELETE",

                        // });
                    }  
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