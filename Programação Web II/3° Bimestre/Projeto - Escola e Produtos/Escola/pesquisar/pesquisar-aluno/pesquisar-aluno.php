<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisar Alunos</title>
    <link rel="stylesheet" href="../pesquisar-aluno/pesquisar-aluno.css">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet" />
</head>

<body>

    <nav class="nav-bar">
        <div class="logo">
            <h4><span class="m">M</span><span class="mais">+</span></h4>
        </div>
        <div class="login-button">
            <a href="../Escola/menu.html"><button>Menu Principal</button></a>
        </div>
    </nav>

    <div class="tudo">
        <div class="conteudo">

            <h1>Pesquisar Alunos</h1>

            <div class="container">

                <form action="" method="post" name="cliente">
                    <fieldset id="a">
                        <legend>Informe o nome do aluno desejado:</legend>
                        <p>Nome: <input type="text" name="txtnome" placeholder="Nome do Aluno"></p>
                        <input type="submit" name="btnenviar" value="Consultar">
                        <input type="reset" name="limpar" value="Limpar">
                    </fieldset>

                    <fieldset id="b">
                        <legend>Resultado: </legend>

                        <?php
                        if (isset($_POST['btnenviar'])) {
                            include_once '../../alunos.php';
                            $p = new Alunos();
                            $p->setNome($_POST['txtnome'] . '%');
                            $pro_bd = $p->consultar();

                            foreach ($pro_bd as $pro_mostrar) {
                                echo "Código: " . $pro_mostrar[0] . "<br>";
                                echo "Nome do Aluno: " . $pro_mostrar[1] . "<br>";
                                echo "Endereço: " . $pro_mostrar[2] . "<br>";
                                echo "Cidade: " . $pro_mostrar[3] . "<br>";
                                echo "Cód. Curso: " . $pro_mostrar[4] . "<br><br>";
                            }
                        }
                        ?>
                    </fieldset>
                </form>

                <button class="btn-voltar">
                    <a href="../../menu.html">Voltar</a>
                </button>

            </div>
        </div>

    </div>

</body>

</html>