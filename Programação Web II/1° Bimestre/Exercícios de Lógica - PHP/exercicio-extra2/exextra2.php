<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado do Fatorial</title>
    <link rel="stylesheet" href="../exercicio-extra2/style.css">
</head>

<body>

<div class="conteudo">

    <h1>Resultado do Fatorial</h1>

    <?php
    $numero = $_POST["numero"];
    $fatorial = 1;
    $processo = "";

    for ($i = $numero; $i > 0; $i--) {
        $fatorial *= $i;
        $processo .= ($i > 1) ? "$i × " : "$i";
    }

    echo "<h2>Fatorial de $numero:</h2>";
    echo "<p><strong>$numero! = $processo = $fatorial</strong></p>";
    ?>

    <a href="../exercicio-extra2/index.html">Voltar</a>

</div>

</body>

</html>