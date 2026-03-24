<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/login.css">
    <title>Retro Experience</title>

    <script>
        function blokletras(keypress) {
         
            if (keypress >= 48 && keypress <= 57) {
                return true;
            } else {
                return false;
            }
        }
    </script>
</head>
<body>

    <form action="" method="POST">
        <div class="login-container">
        <h1>Login</h1>
        </div>

        <label for="usuario">Usuário</label>
        <input type="text" id="usuario" name="txtusuario" required maxlength="15">

        <label for="senha">Senha</label>
        <input type="password" id="senha" name="txtsenha" maxlength="3" 
               onkeypress="return blokletras(event.which || event.keyCode)" required>

        <button type="submit" name="btnconsultar">Entrar</button>
    </form>

    <?php
    include_once './php/usuario.php';
    $existe = false;

    if (isset($_POST['btnconsultar'])) {
        extract($_POST, EXTR_OVERWRITE);

        $u = new Usuario();
        $u->setUsu($txtusuario);
        $u->setSenha($txtsenha);

        $resultado = $u->logar();

        if ($resultado && count($resultado) > 0) {
            $existe = true;
            echo "<h3>Bem-vindo! Usuário: " . $resultado[0]['login'] . "</h3>";
            echo "<script>window.location='menu.html';</script>"; 
        }
    }

    if ($existe == false && isset($_POST['btnconsultar'])) {
        header("location:loginInvalido.html");
        exit;
    }
    ?>
</body>
</html>
