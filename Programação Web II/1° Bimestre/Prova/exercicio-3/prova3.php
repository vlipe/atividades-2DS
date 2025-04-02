<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../exercicio-3/style.css">
    <title>Resultados</title>
</head>

<body>

    <div class="conteudo">

        <?php

    $distancia = $_POST['distancia'];
    $combustivel = $_POST['combustivel'];
    
    $media = $distancia / $combustivel;

    echo "O consumo médio de combustível foi de: " . $media;

        ?>


    </div>

</body>

</html>