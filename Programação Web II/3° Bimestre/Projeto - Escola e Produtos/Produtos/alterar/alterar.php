<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Alterar</title>
    <link rel="stylesheet" href="../alterar/alterar.css" />
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
                    <a href="./menu.html" class="nav-link">Menu Principal</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="tudo">
        <div class="conteudo">
            <h1>Alterar produtos na Loja</h1>

            <form action="cliente2" method = "POST" action = "">
                <?php
                foreach($pro_bd as $pro_mostrar)
                {
                    ?>
                    <input type="hidden" name="txtid" value='<?php echo $pro_mostrar[0]?>'>
                    <?php echo "ID: " . $pro_mostrar[0];
                    <?php echo "Nome: " ;?>
                    <input type="text">
                }
            </form>

            <?php
            $txtid=$_POST["txtid"];
            include_once 'produto.php';
            $p = new produto();
            $p->setId($txtid);
            $pro_bd=$p->alterar();
            ?>


            <button class="btn-voltar">
                <a href="./menu.html">Voltar</a>
            </button>
        </div>
    </div>
</body>

</html>