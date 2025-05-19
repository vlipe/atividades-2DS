<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listagem</title>
    <link rel="stylesheet" href="lista.css">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet" />
</head>

<body>

    <nav class="nav-bar">
        <div class="nav-list">
            <ul>
                <li class="nav-item"><a href="menu.html" class="nav-link">Menu Principal</a></li>
            </ul>
        </div>
    </nav>

    <div class="tudo">
        <div class="conteudo">

            <h1>Produtos Cadastrados na Loja</h1>

            <div class="container">

                <?php
                include_once 'produto.php';
                $p = new produto();
                $pro_bd = $p->listar();
                ?>

                <table class="tabela-produtos">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Estoque</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach ($pro_bd as $pro_mostrar): ?>
                            <tr>
                                <td><?php echo $pro_mostrar[0]; ?></td>
                                <td><?php echo $pro_mostrar[1]; ?></td>
                                <td><?php echo $pro_mostrar[2]; ?></td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>

            </div>
        </div>

        <img src="../Produtos/imagens/undraw_task-list_qe3p.svg" alt="">

    </div>

</body>

</html>