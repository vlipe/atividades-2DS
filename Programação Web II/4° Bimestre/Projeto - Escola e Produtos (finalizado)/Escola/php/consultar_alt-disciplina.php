<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8" />
  <title>Consultar Disciplina</title>
  <link rel="stylesheet" href="../css/alterar-disciplinas.css" />
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
      <h1>Consultar Disciplina</h1>
      <div class="container">
        <form class="formulario-produto" method="post" action="consultar_alt-disciplina2.php">
          <fieldset class="grupo-campo">
            <legend>Informe o Código</legend>
            <div class="campo">
              <label for="txtcod">Código da Disciplina:</label>
              <input type="number" name="txtcod" id="txtcod" required />
            </div>
          </fieldset>
          <fieldset class="grupo-botoes">
            <input type="submit" name="btnconsultar" value="Consultar" class="btn-cadastrar" />
          </fieldset>
        </form>
        <button class="btn-voltar">
          <a href="../menu.html">Voltar</a>
        </button>
      </div>
    </div>
  </div>
</body>
</html>
