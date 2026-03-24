<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Inserir Disciplinas</title>
    <link rel="stylesheet" href="../inserir-disciplina/inserir-disciplinas.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap"
        rel="stylesheet" />
</head>

<body>

    <nav class="nav-bar">
        <div class="logo">
            <h4><span class="m">M</span><span class="mais">+</span></h4>
        </div>
        <div class="login-button">
            <a href="../../menu.html"><button>Menu Principal</button></a>
        </div>
    </nav>

    <div class="tudo">
        <div class="conteudo">
            <h1>Inserir Disciplinas</h1>

            <div class="container">
                <form class="formulario-disciplina" action="" method="post">
                    <fieldset class="grupo-campo">
                        <legend>Dados da Disciplina</legend>

                        <div class="campo">
                            <label for="txtnome">Nome da Disciplina:</label>
                            <input type="text" name="txtnome" id="txtnome" placeholder="Nome da Disciplina" required />
                        </div>

                        <div class="campo">
                            <label for="txtcod">Código da Disciplina:</label>
                            <input type="number" name="txtcod" id="txtcod" placeholder="0" required min="0" />
                        </div>
                    </fieldset>

                    <fieldset class="grupo-botoes">
                        <input type="submit" name="btnenviar" value="Cadastrar" class="btn-cadastrar" />
                        <input type="reset" name="limpar" value="Limpar" class="btn-limpar" />
                    </fieldset>
                </form>

                <?php
                extract($_POST, EXTR_OVERWRITE);
                if (isset($btnenviar)) {
                    include_once '../../disciplinas.php';
                    $disc = new Disciplina();
                    $disc->setCodDisciplina($txtcod);
                    $disc->setNomeDisciplinas($txtnome);
                    echo "<p class='mensagem'>" . $disc->salvar() . "</p>";
                }
                ?>

                <div class="botaoo">
                    <button class="btn-voltar">
                        <a href="../../menu.html">Voltar</a>
                    </button>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="centralizar">
            <h1><span>docente</span> <br> EDNA <br> <span class="dois">PITTNER.</span></h1>
        </div>
    </footer>

</body>

</html>