<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Inserir Alunos</title>
    <link rel="stylesheet" href="../inserir-aluno/inserir-alunos.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap" rel="stylesheet" />
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
            <h1>Inserir Alunos</h1>

            <div class="container">
                <form class="formulario-alunos" action="" method="post">
                    <fieldset class="grupo-campo">
                        <legend>Dados do Aluno</legend>

                        <div class="campo">
                            <label for="txtmatricula">Matrícula:</label>
                            <input type="number" name="txtmatricula" id="txtmatricula" placeholder="Matrícula" required
                                value="" />
                        </div>

                        <div class="campo">
                            <label for="txtnome">Nome do(a) aluno(a):</label>
                            <input type="text" name="txtnome" id="txtnome" placeholder="Nome do Aluno" required
                                value="" />
                        </div>

                        <div class="campo">
                            <label for="txtendereco">Endereço:</label>
                            <input type="text" name="txtendereco" id="txtendereco" placeholder="Endereço" required
                                value="" />
                        </div>

                        <div class="campo">
                            <label for="txtcidade">Cidade:</label>
                            <input type="text" name="txtcidade" id="txtcidade" placeholder="Cidade" required
                                value="" />
                        </div>

                        <div class="campo">
                            <label for="txtcodcurso">Código do Curso:</label>
                            <input type="number" name="txtcodcurso" id="txtcodcurso" placeholder="Código do Curso" min="0" required
                                value=" " />
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
                    include_once '../../alunos.php';

                    $aluno = new Alunos();
                    $aluno->setMatricula($txtmatricula);
                    $aluno->setNome($txtnome);
                    $aluno->setEndereco($txtendereco);
                    $aluno->setCidade($txtcidade);
                    $aluno->setCodcurso($txtcodcurso);

                    echo "<p class='mensagem'>" . $aluno->salvar() . "</p>";
                }
                ?>

                <div class="botaoo">
                    <a href="../../menu.html" class="btn-voltar">Voltar</a>
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
