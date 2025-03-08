<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Número Par ou Ímpar</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="conteudo">
        <?php

        $numero = $_POST['numero'];

        if ($numero % 2) {
            echo '<span>O número digitado (<strong>' . $numero . '</strong>) é <strong>ímpar</strong>.</span>';
        } else {
            echo '<span>O número digitado (<strong>' . $numero . '</strong>) é <strong>par</strong>.</span>';
        }

        ?>

        <a href="../exercicio-10/index.html">Voltar ao Início</a>

    </div>

</body>

</html>