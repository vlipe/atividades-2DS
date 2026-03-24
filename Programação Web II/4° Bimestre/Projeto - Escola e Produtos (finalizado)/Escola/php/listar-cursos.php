<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Cursos</title>
    <link rel="stylesheet" href="../css/listar-cursos.css">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet" />
</head>

<body>

    <header>

        <nav class="nav-bar">
            <div class="logo">
                <h4><span class="m">M</span><span class="mais">+</span></h4>
            </div>
            <div class="login-button">
                <a href="../menu.html"><button>Menu Principal</button></a>
            </div>
        </nav>

    </header>


    <div class="tudo">
        <div class="conteudo">

            <h1>Lista de Cursos</h1>

            <div class="container">

                <?php
                include_once 'cursos.php';
                $p = new Curso();
                $pro_bd = $p->listar();
                ?>

                <table class="tabela-cursos">
                    <thead>
                        <tr>
                            <th>Cód. Curso</th>
                            <th>Nome</th>
                            <th>Cód. Disc 1</th>
                            <th>Cód. Disc 2</th>
                            <th>Cód. Disc 3</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach ($pro_bd as $pro_mostrar): ?>
                            <tr>
                                <td><?php echo $pro_mostrar[0]; ?></td>
                                <td><?php echo $pro_mostrar[1]; ?></td>
                                <td><?php echo $pro_mostrar[2]; ?></td>
                                <td><?php echo $pro_mostrar[3]; ?></td>
                                <td><?php echo $pro_mostrar[4]; ?></td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>

            </div>
        </div>

        <img src="../imagens/mochilas.png" alt="">

    </div>

    <footer>

    <div class="centralizar">
      <h1><span>docente</span> <br> EDNA <br> <span class="dois">PITTNER.</span></h1>
    </div>

  </footer>

</body>

</html>