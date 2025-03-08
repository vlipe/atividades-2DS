<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado da Soma dos Números Ímpares</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="conteudo">

        <?php

        $num1 = $_POST['num1'];
        $num2 = $_POST['num2'];

        $inicio = min($num1, $num2);
        $fim = max($num1, $num2);

        $soma = 0;

        for ($i = $inicio; $i <= $fim; $i++) {
            if ($i % 2 != 0) {
                $soma += $i;
            }
        }

        echo "<span>A soma dos números ímpares entre <strong>$inicio</strong> e <strong>$fim</strong> é <strong>$soma</strong>.</span>";
        ?>

        <a href="../exercicio-9/index.html">Voltar ao Início</a>

    </div>

</body>

</html>