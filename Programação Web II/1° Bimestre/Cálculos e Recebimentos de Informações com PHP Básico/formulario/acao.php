<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ação - Recebimento dos dados de um Formulário</title>
    <link rel="stylesheet" href="../formulario/style.css">
</head>

<body>
    <div class="conteudo">
        <?php
        $Vnome = $_POST["nome"];
        $Vidade = $_POST["idade"];

        echo "Oi, <strong>" . $Vnome . "</strong>." . "<br>" . "Você tem <strong>" . $Vidade . "</strong> anos.";
        ?>

        <a class="a" href="../inicio/index.html">Voltar à Página Inicial</a>
    </div>
</body>

</html>