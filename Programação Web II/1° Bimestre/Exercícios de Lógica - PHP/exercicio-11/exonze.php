<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado da Operação</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="conteudo">
        <?php
        $num1 = $_POST['num1'];
        $num2 = $_POST['num2'];
        $operacao = $_POST['operacao'];
        $resultado = 0;
        $mensagem = "";

        switch ($operacao) {
            case '+':
                $resultado = $num1 + $num2;
                $mensagem = "A soma de <strong>$num1</strong> e <strong>$num2</strong> é <strong>$resultado</strong>.";
                break;
            case '-':
                $resultado = $num1 - $num2;
                $mensagem = "A subtração de <strong>$num1</strong> por <strong>$num2</strong> é <strong>$resultado</strong>.";
                break;
            case '*':
                $resultado = $num1 * $num2;
                $mensagem = "A multiplicação de <strong>$num1</strong> por <strong>$num2</strong> é <strong>$resultado</strong>.";
                break;
            case '/':
                if ($num2 == 0) {
                    $mensagem = "Erro: divisão por zero não é permitida.";
                } else {
                    $resultado = $num1 / $num2;
                    $mensagem = "A divisão de <strong>$num1</strong> por <strong>$num2</strong> é <strong>$resultado</strong>.";
                }
                break;
            default:
                $mensagem = "Operação inválida.";
                break;
        }

        echo "<span>$mensagem</span>";
        ?>

        <a href="../exercicio-11/index.html">Voltar ao Início</a>

    </div>

</body>
</html>
