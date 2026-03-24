<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Consultar Aluno</title>
  <link rel="stylesheet" href="../css/alterar-alunos.css">
</head>
<body>
  <nav class="nav-bar">
    <div class="logo"><h4><span class="m">M</span><span class="mais">+</span></h4></div>
    <div class="login-button"><a href="../menu.html"><button>Menu Principal</button></a></div>
  </nav>

  <div class="tudo">
    <div class="conteudo">
      <h1>Consultar Aluno</h1>
      <div class="container">
        <form method="post" action="consultar_alt-aluno2.php">
          <fieldset class="grupo-campo">
            <legend>Informe a Matrícula</legend>
            <div class="campo">
              <label for="txtmatricula">Matrícula:</label>
              <input type="number" name="txtmatricula" id="txtmatricula" required>
            </div>
          </fieldset>
          <fieldset class="grupo-botoes">
            <input type="submit" name="btnconsultar" value="Consultar" class="btn-cadastrar">
          </fieldset>
        </form>
        <button class="btn-voltar"><a href="../menu.html">Voltar</a></button>
      </div>
    </div>
  </div>
</body>
</html>
