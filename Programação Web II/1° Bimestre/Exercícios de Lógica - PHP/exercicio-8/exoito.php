<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Maior e Menor Número</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="conteudo">

        <?php

        $num1 = $_POST['num1'];
        $num2 = $_POST['num2'];
        $num3 = $_POST['num3'];

        if ($num1 == $num2 && $num1 == $num3) {
            echo '<span>Todos os números são iguais: <strong>' . $num1 . '</strong>.</span><br>';
            $numeroMeio = $num1;
        } else {

            if ($num1 > $num2 && $num1 > $num3) {
                echo '<span>O maior número é <strong>' . $num1 . '</strong>.</span><br>';

                if ($num2 > $num3) {
                    $numeroMeio = $num2;
                } else {
                    $numeroMeio = $num3;
                }
            } elseif ($num2 > $num1 && $num2 > $num3) {
                echo '<span>O maior número é <strong>' . $num2 . '</strong>.</span><br>';

                if ($num1 > $num3) {
                    $numeroMeio = $num1;
                } else {
                    $numeroMeio = $num3;
                }
            } elseif ($num3 > $num1 && $num3 > $num2) {
                echo '<span>O maior número é <strong>' . $num3 . '</strong>.</span><br>';

                if ($num1 > $num2) {
                    $numeroMeio = $num1;
                } else {
                    $numeroMeio = $num2;
                }
            } else {
                echo '<span>Existem números iguais ou empatados no maior valor.</span><br>';
            }

            if ($num1 < $num2 && $num1 < $num3) {
                echo '<span>O menor número é <strong>' . $num1 . '</strong>.</span><br>';
            } elseif ($num2 < $num1 && $num2 < $num3) {
                echo '<span>O menor número é <strong>' . $num2 . '</strong>.</span><br>';
            } elseif ($num3 < $num1 && $num3 < $num2) {
                echo '<span>O menor número é <strong>' . $num3 . '</strong>.</span><br>';
            } else {
                echo '<span>Existem números iguais ou empatados no menor valor.</span><br>';
            }
        }

        echo '<span>O número do meio é <strong>' . $numeroMeio . '</strong>.</span>';

        ?>

        <a href="../exercicio-8/index.html">Voltar ao Início</a>

    </div>

</body>

</html>