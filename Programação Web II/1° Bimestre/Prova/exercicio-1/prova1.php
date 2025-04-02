<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../exercicio-1/style.css">
    <title>Resultados</title>
</head>
<body>
    
<div class="conteudo">

<?php

    $preco = $_POST['preco'];
    $nome = $_POST['nome'];

    $acrescentado = ($preco * 16) / 100;
    $final = $preco + $acrescentado;
    $parcela = $final / 10;

    echo "O preço original é de: R$ " . number_format($preco, 2, ',', '.') . "<br>";
    echo "O preço final com 16% de acréscimo: R$ " . number_format($final, 2, ',', '.') . '<br>'; 
    echo "A parcela é de: R$ " . $parcela;

?>


</div>

</body>
</html>