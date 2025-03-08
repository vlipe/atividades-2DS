<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Média do Aluno</title>
    <link rel="stylesheet" href="../exercicio-3/style.css">
</head>
<body>
    
    <div class="conteudo">

    <?php
    $nome = $_POST['nome'];
    $nota1 = $_POST['nota1'];
    $nota2 = $_POST['nota2'];
    $nota3 = $_POST['nota3'];
    $nota4 = $_POST['nota4'];

    $media = ($nota1 + $nota2 + $nota3 + $nota4) / 4;

    if ($media >= 5) {
        
        echo '<span>Aluno(a) <strong>' . $nome . '</strong> teve a média de: <strong>' . $media . '</strong>, portanto, foi <strong>aprovado(a)</strong>!</span>';
    
    }

    else {

        echo '<span>Aluno(a) <strong>' . $nome . '</strong> teve a média de: <strong>' . $media . '</strong>, portanto, foi <strong>reprovado(a)</strong>!</span>';

    }

    ?>

    <a href="../exercicio-3/index.html">Voltar ao Início</a>

    </div>

</body>
</html>