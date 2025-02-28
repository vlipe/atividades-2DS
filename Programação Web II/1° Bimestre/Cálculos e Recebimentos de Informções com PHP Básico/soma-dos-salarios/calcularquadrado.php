<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Página calcularquadrado.php </title>
    <link rel="stylesheet" href="../soma-dos-salarios/style.css">
</head>

<body>

    <div class="conteudo">
        <?php
        $A = $_POST['txta'];
        $B = $_POST['txtb'];
        $soma = $A + $B;
        $quadr = pow($soma, 2);

        echo "A soma dos valores é: <strong>" . $soma . "</strong><br>";
        echo "O quadrado da soma é: <strong>" . $quadr . "</strong><br>";
        ?>

        <a class="a" href="../inicio/index.html">Voltar à Página Inicial</a>
    </div>
</body>

</html>