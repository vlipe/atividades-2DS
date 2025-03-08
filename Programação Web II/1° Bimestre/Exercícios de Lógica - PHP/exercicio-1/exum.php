<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabuada</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="conteudo">
        <?php
        $numero = $_POST['numero'];
        echo '<h1>Resultado da Tabuada do ' . $numero . ':</h1><br><br>';

        $i = 0;
        while ($i <= 10) {
            $tab = $numero * $i;

            echo '<strong>' . $numero . ' x ' . $i . ' =</strong> ' . $tab . '<br />';
            $i++;
        }
        ?>

        <a href="../exercicio-1/index.html">Voltar ao Início</a>

    </div>
</body>

</html>