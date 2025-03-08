<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ordem Decrescente (Ímpares)</title>
    <link rel="stylesheet" href="../exercicio-12/style.css">
</head>

<body>

    <div class="conteudo">

        <?php

        $num1 = $_POST['num1'];
        $num2 = $_POST['num2'];

        $inicio = min($num1, $num2);
        $fim = max($num1, $num2);

        echo "<span>Números ímpares entre <strong>$num1</strong> e <strong>$num2</strong> em ordem <strong>decrescente</strong>:</span>";
        echo "<ul>";

        for ($i = $fim; $i >= $inicio; $i--) {
            if ($i % 2 != 0) {
                echo "<li>$i</li>";
            }
        }

        echo "</ul>";
        ?>

        <a href="../exercicio-12/index.html">Voltar ao Início</a>

    </div>

</body>

</html>