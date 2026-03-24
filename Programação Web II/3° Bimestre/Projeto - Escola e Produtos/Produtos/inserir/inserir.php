<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Inserir</title>
    <link rel="stylesheet" href="../inserir/inserir.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap"
        rel="stylesheet"
    />
</head>
<body>
    <nav class="nav-bar">
        <div class="nav-list">
            <ul>
                <li class="nav-item">
                    <a href="menu.html" class="nav-link">Menu Principal</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="tudo">
        <div class="conteudo">
            <h1>Cadastre produtos na Loja</h1>

            <form class="formulario-produto" action="" method="post" name="cliente">
                <fieldset class="grupo-campo">
                    <legend>Dados do Produto</legend>

                    <div class="campo">
                        <label for="txtnome">Nome do Produto:</label>
                        <input type="text" name="txtnome" id="txtnome" placeholder="Nome do Produto" />
                    </div>

                    <div class="campo">
                        <label for="txtestoq">Estoque:</label>
                        <input type="text" name="txtestoq" id="txtestoq" placeholder="0" />
                    </div>
                </fieldset>

                <fieldset class="grupo-botoes">
                    <input type="submit" name="btnenviar" value="Cadastrar" class="btn-cadastrar" />
                    <input type="reset" name="limpar" value="Limpar" class="btn-limpar" />
                </fieldset>
            </form>

            <?php
            extract($_POST, EXTR_OVERWRITE);
            if(isset($btnenviar))
            {
                include_once 'produto.php';
                $pro = new Produto();
                $pro->setNome($txtnome);
                $pro->setEstoque($txtestoq);
                echo "<p class='mensagem'>" . $pro->salvar() . "</p>";
            }
            ?>

            <button class="btn-voltar">
                <a href="../menu.html">Voltar</a>
            </button>
        </div>
    </div>
</body>
</html>
