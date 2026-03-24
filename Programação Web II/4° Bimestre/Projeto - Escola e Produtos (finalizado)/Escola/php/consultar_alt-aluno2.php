<?php
include_once 'alunos.php';
$aluno = new Alunos();

if (isset($_POST['txtmatricula'])) {
    $aluno->setMatricula($_POST['txtmatricula']);
    $resultado = $aluno->alterar();
}

if (isset($_POST['btnalterar'])) {
    $aluno->setMatricula($_POST['txtmatricula']);
    $aluno->setNome($_POST['txtnome']);
    $aluno->setEndereco($_POST['txtendereco']);
    $aluno->setCidade($_POST['txtcidade']);
    $aluno->setCodcurso($_POST['txtcodcurso']);
    $msg = $aluno->alterar2();
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Alterar Aluno</title>
  <link rel="stylesheet" href="../css/alterar-alunos.css">
</head>
<body>
  <nav class="nav-bar">
    <div class="logo"><h4><span class="m">M</span><span class="mais">+</span></h4></div>
    <div class="login-button"><a href="../menu.html"><button>Menu Principal</button></a></div>
  </nav>

  <div class="tudo">
    <div class="conteudo">
      <h1>Alterar Aluno</h1>
      <div class="container">
        <?php
        if (!empty($resultado)) {
            foreach ($resultado as $r) {
        ?>
        <form method="post" action="">
          <fieldset class="grupo-campo">
            <legend>Dados do Aluno</legend>
            <div class="campo">
              <label>Matrícula:</label>
              <input type="number" name="txtmatricula" value="<?php echo $r[0]; ?>" readonly>
            </div>
            <div class="campo">
              <label>Nome:</label>
              <input type="text" name="txtnome" value="<?php echo $r[1]; ?>" required>
            </div>
            <div class="campo">
              <label>Endereço:</label>
              <input type="text" name="txtendereco" value="<?php echo $r[2]; ?>" required>
            </div>
            <div class="campo">
              <label>Cidade:</label>
              <input type="text" name="txtcidade" value="<?php echo $r[3]; ?>" required>
            </div>
            <div class="campo">
              <label>Código do Curso:</label>
              <input type="number" name="txtcodcurso" value="<?php echo $r[4]; ?>" required>
            </div>
          </fieldset>
          <fieldset class="grupo-botoes">
            <input type="submit" name="btnalterar" value="Salvar Alterações" class="btn-cadastrar">
          </fieldset>
        </form>
        <?php
            }
        }
        if (isset($msg)) {
            echo "<p class='mensagem'>$msg</p>";
        }
        ?>
        <button class="btn-voltar"><a href="consultar_alt-aluno.php">Voltar</a></button>
      </div>
    </div>
  </div>
</body>
</html>
