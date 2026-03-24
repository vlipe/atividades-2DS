<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Excluir Cursos</title>
  <link rel="stylesheet" href="../css/excluir-cursos.css" />
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

      <h1>Excluir Cursos</h1>
      <h2>Exclua cursos na escola</h2>

      <form class="formulario-curso" action="" method="post" name="curso">
        <fieldset id="a">
          <legend>Informe o Código do curso desejado:</legend>
          <p>Código: <input type="text" name="txtcurso" placeholder="Código do Curso" /></p>
          <input type="submit" name="btnenviar" value="Excluir" />
          <input type="reset" name="limpar" value="Limpar" />
        </fieldset>
      </form>

      <?php
      extract($_POST, EXTR_OVERWRITE);
      if (isset($btnenviar)) {
          include_once 'cursos.php';
          $p = new Curso();
          $p->setCodCurso($txtcurso);
          echo "<h3>" . $p->exclusao() . "</h3>";
      }
      ?>

      <button class="btn-voltar">
        <a href="../menu.html">Voltar</a>
      </button>

    </div>
  </div>

</body>

</html>
