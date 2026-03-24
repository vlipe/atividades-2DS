<?php
include_once 'produto.php';

$txtid = $_POST["txtid"] ?? null;
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Alterar Produto</title>
    <link rel="stylesheet" href="../css/alterar.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap"
        rel="stylesheet" />
</head>
<body>
        <div class="conteudo container">
            <h1>Alterar Produto</h1>
            <?php
            if ($txtid) {
                $p = new Produto();
                $p->setId($txtid);

                $pro_bd = $p->alterar();

                foreach ($pro_bd as $pro_mostrar) {
                    ?>
                    <form action="" method="POST">
                        <input type="hidden" name="txtid" value="<?php echo $pro_mostrar[0]; ?>">

                        <label>Nome:</label>
                        <input type="text" name="txtnome" value="<?php echo $pro_mostrar[1]; ?>">

                        <label>Estoque:</label>
                        <input type="text" name="txtestoq" value="<?php echo $pro_mostrar[2]; ?>">

                        <input type="submit" name="btnalterar" value="Salvar">
                    </form>
                    <?php
                }
            }

            if (isset($_POST["btnalterar"])) {
                $p = new Produto();
                $p->setId($_POST["txtid"]);
                $p->setNome($_POST["txtnome"]);
                $p->setEstoque($_POST["txtestoq"]);

                $msg = $p->alterar2();
                echo "<p>$msg</p>";
            }
            ?>
            <div class="b">
            <button class="btn-voltar2">
                <a href="../menu.html">Voltar</a>
            </button>
        </div>
        </div>
    </div>
</body>
</html>
