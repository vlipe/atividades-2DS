<?php
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Alterar</title>
        <link rel="stylesheet" href="../css/alterar.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap"
        rel="stylesheet" />
</head>
<body>
    
    <h2>Consultar Produto para Alterar</h2>
    <form action="consultar_alt2.php" method="POST">
        <label for="txtid">Digite o ID do produto:</label>
        <input type="text" name="txtid" id="txtid" required>
        <input type="submit" value="Consultar">
                    <button class="btn-voltar">
                <a href="../menu.html">Voltar</a>
            </button>
    </form>
</body>
</html>
