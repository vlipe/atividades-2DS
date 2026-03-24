<?php

include_once 'conectar.php';

class Alunos
{
    private $matricula;
    private $nome;
    private $endereco;
    private $cidade;
    private $codcurso;
    private $conn;

    public function getMatricula()
    {
        return $this->matricula;
    }

    public function setMatricula($matriculas)
    {
        $this->matricula = $matriculas;
    }

    public function getNome()
    {
        return $this->nome;
    }

    public function setNome($name)
    {
        $this->nome = $name;
    }

    public function getEndereco()
    {
        return $this->endereco;
    }

    public function setEndereco($enderecos)
    {
        $this->endereco = $enderecos;
    }

    public function getCidade()
    {
        return $this->cidade;
    }

    public function setCidade($cidades)
    {
        $this->cidade = $cidades;
    }

    public function getCodcurso()
    {
        return $this->codcurso;
    }

    public function setCodcurso($codcursos)
    {
        $this->codcurso = $codcursos;
    }

        function consultar()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("SELECT * FROM alunos WHERE nome LIKE ?");
            @$sql->bindParam(1, $this->getNome(), PDO::PARAM_STR);
            $sql->execute();
            $resultado = $sql->fetchAll(PDO::FETCH_NUM);
            $this->conn = null;
            return $resultado;
        } catch (PDOException $e) {
            echo "Erro na consulta: " . $e->getMessage();
            return [];
        }
    }

    function listar()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->query("SELECT * FROM alunos ORDER BY nome");
            $sql->execute();
            return $sql->fetchAll();
            $this->conn = null;
        } catch (PDOException $exc) {
            echo "Erro ao executar consulta. " . $exc->getMessage();
        }
    }

    function salvar()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("INSERT INTO alunos (matricula, nome, endereco, cidade, codcurso) VALUES (?, ?, ?, ?, ?)");

            $matricula = $this->getMatricula();
            $nome = $this->getNome();
            $endereco = $this->getEndereco();
            $cidade = $this->getCidade();
            $codcurso = $this->getCodcurso();

            $sql->bindParam(1, $matricula, PDO::PARAM_INT); 
            $sql->bindParam(2, $nome, PDO::PARAM_STR);
            $sql->bindParam(3, $endereco, PDO::PARAM_STR);
            $sql->bindParam(4, $cidade, PDO::PARAM_STR);
            $sql->bindParam(5, $codcurso, PDO::PARAM_INT);
            
            if ($sql->execute()) {
                return "Registro salvo com sucesso!";
            } else {
                return "Erro ao salvar o registro.";
            }

            $this->conn = null;
        } catch (PDOException $exc) {
            return "Erro ao salvar o registro. " . $exc->getMessage();
        }
    }

        function exclusao()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("delete from alunos where matricula = ?");
            @$sql->bindParam(1, $this->getMatricula(), PDO::PARAM_STR);
            if ($sql->execute() == 1) {
                return "Exclusão com sucesso!";
            } else {
                return "Erro na conexão!";
            }

            $this->conn = null;
        } catch (PDOException $exc) {
            echo "Erro ao excluir." . $exc->getMessage();
        }
    }

    function alterar()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("SELECT * FROM alunos WHERE matricula = ?");
            $sql->bindParam(1, $this->matricula, PDO::PARAM_INT);
            $sql->execute();
            return $sql->fetchAll(PDO::FETCH_NUM);
        } catch (PDOException $exc) {
            echo "Erro ao buscar aluno. " . $exc->getMessage();
        }
    }

    function alterar2()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare(
                "UPDATE alunos SET nome = ?, endereco = ?, cidade = ?, codcurso = ? WHERE matricula = ?"
            );
            @$sql->bindParam(1, $this->nome, PDO::PARAM_STR);
            @$sql->bindParam(2, $this->endereco, PDO::PARAM_STR);
            @$sql->bindParam(3, $this->cidade, PDO::PARAM_STR);
            @$sql->bindParam(4, $this->codcurso, PDO::PARAM_INT);
            @$sql->bindParam(5, $this->matricula, PDO::PARAM_INT);

            if ($sql->execute()) {
                return "Aluno alterado com sucesso!";
            } else {
                return "Erro ao alterar aluno.";
            }
        } catch (PDOException $exc) {
            echo "Erro ao alterar. " . $exc->getMessage();
        }
    }
}
