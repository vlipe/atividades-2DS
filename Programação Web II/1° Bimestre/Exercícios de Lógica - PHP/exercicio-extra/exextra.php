<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contagem Regressiva</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="conteudo">

    <?php


    echo '<h2>A contagem é: </h2>';
    echo '<p>';

    $numero = $_POST['numero'];

    for ($i = $numero; $i >= 0; $i--) {

        if ($i > 0) {
            echo $i . ", ";
        } else {
            echo $i . ".";
        }
    }

    echo "</p>";
    
    ?>

    <a href="../exercicio-extra/index.html">Voltar ao Início</a> 

</div>


</body>

</html>