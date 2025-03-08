<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Troca de Conteúdos</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="conteudo">

        <?php

        $a = $_POST['a'];
        $b = $_POST['b'];
        
        $troca = $a;
        $a = $b;
        $b = $troca;

        echo "<span>O valor de <strong>A</strong> (primeiro número informado) é de: <strong>" .$a . "</strong>.</span> <br>";
        echo "<span>O valor de <strong>B</strong> (segundo número informado) é de: <strong>" .$b . "</strong>.</span>";

        ?>

        <a href="../exercicio-4/index.html">Voltar ao Início</a>

    </div>

</body>

</html>