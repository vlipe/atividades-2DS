<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../calculo-salario/style.css">
    <title>Página calcularsalario.php</title>
</head>

<body>
    <div class="conteudo">
        <?php
        $valor = $_POST['txtvalor'];
        $horas = $_POST['txthoras'];
        $salario = $valor * $horas;
        echo "De acordo com as informações digitadas na página anterior, o salário é de <strong>R$" . $salario . "</strong>";
        ?>

        <a class="a" href="../inicio/index.html">Voltar à Página Inicial</a>
    </div>
</body>

</html>