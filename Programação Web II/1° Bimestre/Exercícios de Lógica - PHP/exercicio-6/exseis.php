<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Salário Bruto</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="conteudo">

        <?php

        $bruto = $_POST['bruto'];

        $gratificacao = $bruto * 0.10;
        $imposto = ($bruto + $gratificacao) * 0.20;
        $liquido = ($bruto + $gratificacao) - $imposto;

        echo '<span>Pagando <strong>20%</strong> de Imposto de Renda e havendo <strong>10%</strong> de gratificação, o valor do salário líquido é de: <strong>R$ ' . $liquido . '.</span>';

        ?>

        <a href="../exercicio-6/index.html">Voltar ao Início</a>

    </div>

</body>

</html>