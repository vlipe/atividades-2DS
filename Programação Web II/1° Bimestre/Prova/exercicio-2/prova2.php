<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../exercicio-2/style.css">
    <title>Resultados</title>
</head>

<body>

    <div class="conteudo">

        <?php

        $area = $_POST['area'];

        $litros = $area / 6;

        $clata = 18;
        $cgalao = 3.6;
        $preco_lata = 80;
        $preco_galao = 25;

        echo "Resultado: <br><br>";
        echo "Litros necessários: " . round($litros, 2) . "L <br>";

        if ($litros >= $clata) {

            $qtd_latas = round($litros / $clata);
            $custo_total = $qtd_latas * $preco_lata;

            echo "Quantidade de latas: " . $qtd_latas . "<br>";
            echo "Custo total: R$ " . number_format($custo_total, 2, ',', '.');
        } else {

            $qtd_galoes = round($litros / $cgalao);
            $custo_total = $qtd_galoes * $preco_galao;

            echo "Quantidade de galões: " . $qtd_galoes . "<br>";
            echo "Custo total: R$ " . number_format($custo_total, 2, ',', '.');
        }

        ?>

    </div>

</body>

</html>