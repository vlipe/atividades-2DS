<?php
include_once 'cursos.php';
$curso = new Curso();

if (isset($_POST['txtcod'])) {
    $curso->setCodCurso($_POST['txtcod']);
    $resultado = $curso->alterar();
}

if (isset($_POST['btnalterar'])) {
    $curso->setCodCurso($_POST['txtcod']);
    $curso->setNome($_POST['txtnome']);
    $curso->setCodDisc1($_POST['txtcod1']);
    $curso->setCodDisc2($_POST['txtcod2']);
    $curso->setCodDisc3($_POST['txtcod3']);
    $msg = $curso->alterar2();
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8" />
  <title>Alterar Curso</title>
  <link rel="stylesheet" href="../css/alterar-cursos.css" />
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
      <a href="../menu.html"><button>Menu Principal</button></a>
    </div>
  </nav>

  <div class="tudo">
    <div class="conteudo">
      <h1>Alterar Curso</h1>
      <div class="container">
        <?php
        if (!empty($resultado)) {
            foreach ($resultado as $r) {
                ?>
                <form class="formulario-produto" method="post" action="">
                  <fieldset class="grupo-campo">
                    <legend>Dados do Curso</legend>
                    <div class="campo">
                      <label>Código:</label>
                      <input type="number" name="txtcod" value="<?php echo $r[0]; ?>" readonly />
                    </div>
                    <div class="campo">
                      <label>Nome:</label>
                      <input type="text" name="txtnome" value="<?php echo $r[1]; ?>" required />
                    </div>
                    <div class="campo">
                      <label>Código Disciplina 1:</label>
                      <input type="number" name="txtcod1" value="<?php echo $r[2]; ?>" required />
                    </div>
                    <div class="campo">
                      <label>Código Disciplina 2:</label>
                      <input type="number" name="txtcod2" value="<?php echo $r[3]; ?>" required />
                    </div>
                    <div class="campo">
                      <label>Código Disciplina 3:</label>
                      <input type="number" name="txtcod3" value="<?php echo $r[4]; ?>" required />
                    </div>
                  </fieldset>
                  <fieldset class="grupo-botoes">
                    <input type="submit" name="btnalterar" value="Salvar Alterações" class="btn-cadastrar" />
                  </fieldset>
                </form>
                <?php
            }
        }
        if (isset($msg)) {
            echo "<p class='mensagem'>$msg</p>";
        }
        ?>
        <button class="btn-voltar">
          <a href="consultar_alt-curso.php">Voltar</a>
        </button>
      </div>
    </div>
  </div>
</body>
</html>
