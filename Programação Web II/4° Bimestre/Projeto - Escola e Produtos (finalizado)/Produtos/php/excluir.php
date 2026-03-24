<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Exclusão</title>
    <link rel="stylesheet" href="../css/excluir.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap"
        rel="stylesheet" />
</head>

<body>
    <nav class="nav-bar">
        <div class="nav-list">
            <ul>
                <li class="nav-item">
                    <a href="../menu.html" class="nav-link">Menu Principal</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="tudo">
        <div class="conteudo">
            <h1>Exclua produtos na Loja</h1>

            <form class="formulario-produto" action="" method="post" name="cliente">
                <fieldset id="a">
                    <legend>Informe o ID do produto desejado:</legend>
                    <p>ID: <input type="text" name="txtid" placeholder="ID do produto"></p>
                    <input type="submit" name="btnenviar" value="Excluir">
                    <input type="reset" name="limpar" value="Limpar">
                </fieldset>
            </form>

            <?php
            extract($_POST, EXTR_OVERWRITE);
            if (isset($btnenviar)) {
                include_once 'produto.php';
                $p = new Produto();
                $p->setId($txtid);
                echo "<h3>" . $p->exclusao() . "</h3>";
            }
            ?>
        </div>
    </div>
</body>

</html>