<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Soma dos Quadrados</title>
    <link rel="stylesheet" href="../exercicio-5/style.css">
</head>

<body>

    <div class="conteudo">

        <?php

        $num1 = $_POST['num1'];
        $num2 = $_POST['num2'];
        $num3 = $_POST['num3'];

        $quadrado1 = (pow($num1, 2));
        $quadrado2 = (pow($num2, 2));
        $quadrado3 = (pow($num3, 2));

        $soma = ($quadrado1 + $quadrado2 + $quadrado3);


        echo '<span>A soma dos quadrados dos três números informados é de <strong>' . $soma . '</strong>.</span>';

        ?>

        <a href="../exercicio-5/index.html">Voltar ao Início</a>
    </div>


</body>

</html>