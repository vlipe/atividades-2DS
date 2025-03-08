<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Desconto</title>
    <link rel="stylesheet" href="../exercicio-2/style.css">
</head>

<body>

    <div class="conteudo">
        <?php
        $nome = $_POST['produto'];
        $preco = $_POST['preco'];
        $porcentagem = $_POST['porcentagem'];

        $desconto = ($preco * $porcentagem) / 100;
        $resultado = $preco - $desconto;

        echo "<h2>O total do produto <strong>$nome</strong> após o desconto de <strong>$porcentagem%</strong> é: <strong>R$ $resultado.</strong></h2>";

        ?>

        <a href="../exercicio-2/index.html">Voltar ao Início</a>

    </div>

</body>

</html>