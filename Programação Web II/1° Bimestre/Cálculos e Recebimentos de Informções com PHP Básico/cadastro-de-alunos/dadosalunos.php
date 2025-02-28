<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página dadosalunos.php</title>
    <link rel="stylesheet" href="../cadastro-de-alunos/style.css">
</head>

<body>
    <div class="conteudo">
        <?php
        echo "<p><strong>Segue abaixo as informações digitadas na página anterior:</strong></p>";
        echo "<p><span>Nome digitado:</span> " . $_POST['txtnome'] . "</p>";
        echo "<p><span>Telefone:</span> " . $_POST['txttelefone'] . "</p>";
        echo "<p><span>Curso:</span> " . $_POST['cbocursos'] . "</p>";
        echo "<p><span>RG:</span> " . $_POST['txtRG'] . "</p>";
        echo "<p><span>Módulo:</span> " . $_POST['txtmodulo'] . "</p>";
        ?>

        <a class="a" href="../inicio/index.html">Voltar à Página Inicial</a>
    </div>

</body>

</html>