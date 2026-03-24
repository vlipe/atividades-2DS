<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Inserir Cursos</title>
  <link rel="stylesheet" href="../inserir-curso/inserir-cursos.css" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap"
    rel="stylesheet"
  />
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
      <h1>Inserir Cursos</h1>

      <div class="container">
        <form class="formulario-produto" action="" method="post" name="curso">
          <fieldset class="grupo-campo">
            <legend>Dados do Curso</legend>

            <div class="campo">
              <label for="txtcod">Código do Curso:</label>
              <input type="number" name="txtcod" id="txtcod" placeholder="Código do Curso" min="0" required />
            </div>


            <div class="campo">
              <label for="txtnome">Nome do Curso:</label>
              <input type="text" name="txtnome" id="txtnome" placeholder="Nome do Curso" required />
            </div>

            <div class="campo">
              <label for="txtcod1">Código 1 do Curso:</label>
              <input type="number" name="txtcod1" id="txtcod1" placeholder="0" min="0" required />
            </div>

            <div class="campo">
              <label for="txtcod2">Código 2 do Curso:</label>
              <input type="number" name="txtcod2" id="txtcod2" placeholder="0" min="0" required />
            </div>

            <div class="campo">
              <label for="txtcod3">Código 3 do Curso:</label>
              <input type="number" name="txtcod3" id="txtcod3" placeholder="0" min="0" required />
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
            include_once '../../cursos.php';
            $curso = new Curso();   
            $curso->setCodCurso($txtcod);
            $curso->setNome($txtnome);
            $curso->setCodDisc1($txtcod1);
            $curso->setCodDisc2($txtcod2);
            $curso->setCodDisc3($txtcod3);
            echo "<p class='mensagem'>" . $curso->salvar() . "</p>";
        }
        ?>

        <button class="btn-voltar">
          <a href="../../menu.html">Voltar</a>
        </button>
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
