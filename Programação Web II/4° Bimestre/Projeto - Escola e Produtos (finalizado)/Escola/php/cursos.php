<?php

include_once 'conectar.php';

class Curso
{
    private $codcurso;
    private $nome;
    private $coddisc1;
    private $coddisc2;
    private $coddisc3;
    private $conn;

    public function getCodCurso()
    {
        return $this->codcurso;
    }

    public function setCodCurso($codcursoo)
    {
        $this->codcurso = $codcursoo;
    }

    public function getNome()
    {
        return $this->nome;
    }

    public function setNome($nomes)
    {
        $this->nome = $nomes;
    }

    public function getCodDisc1()
    {
        return $this->coddisc1;
    }

    public function setCodDisc1($coddis1)
    {
        $this->coddisc1 = $coddis1;
    }

    public function getCodDisc2()
    {
        return $this->coddisc2;
    }

    public function setCodDisc2($coddis2)
    {
        $this->coddisc2 = $coddis2;
    }

    public function getCodDisc3()
    {
        return $this->coddisc3;
    }

    public function setCodDisc3($coddis3)
    {
        $this->coddisc3 = $coddis3;
    }

    function consultar()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("SELECT * FROM cursos WHERE nome LIKE ?");
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
            $sql = $this->conn->query("SELECT * FROM cursos ORDER BY codcurso");
            return $sql->fetchAll();
        } catch (PDOException $exc) {
            echo "Erro ao executar consulta. " . $exc->getMessage();
        }
    }

    function salvar()
    {   
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("INSERT INTO cursos VALUES (?, ?, ?, ?, ?)");
            @$sql->bindParam(1, $this->getCodCurso(), PDO::PARAM_INT);
            @$sql->bindParam(2, $this->getNome(), PDO::PARAM_STR);
            @$sql->bindParam(3, $this->getCodDisc1(), PDO::PARAM_INT);
            @$sql->bindParam(4, $this->getCodDisc2(), PDO::PARAM_INT);
            @$sql->bindParam(5, $this->getCodDisc3(), PDO::PARAM_INT);
            if ($sql->execute()) {
                return "Curso cadastrado com sucesso!";
            } else {
                return "Erro ao cadastrar curso.";
            }
        } catch (PDOException $exc) {
            return "Erro ao salvar o curso: " . $exc->getMessage();
        }
    }

    function exclusao()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("DELETE FROM cursos WHERE codcurso = ?");
            $sql->bindParam(1, $this->getCodCurso(), PDO::PARAM_STR);
            if ($sql->execute()) {
                return "Exclusão com sucesso!";
            } else {
                return "Erro na conexão!";
            }
        } catch (PDOException $exc) {
            echo "Erro ao excluir: " . $exc->getMessage();
        }
    }

function alterar()
{
    try {
        $this->conn = new conectar();
        @$sql = $this->conn->prepare("SELECT * FROM cursos WHERE codcurso = ?");
        @$sql->bindParam(1, $this->getCodCurso(), PDO::PARAM_INT);
        @$sql->execute();
        return $sql->fetchAll(PDO::FETCH_NUM);
    } catch (PDOException $exc) {
        echo "Erro ao buscar curso para alterar: " . $exc->getMessage();
    }
}

function alterar2()
{
    try {
        $this->conn = new conectar();
        $sql = $this->conn->prepare(
            "UPDATE cursos 
             SET nome = ?, coddisc1 = ?, coddisc2 = ?, coddisc3 = ? 
             WHERE codcurso = ?"
        );
        @$sql->bindParam(1, $this->getNome(), PDO::PARAM_STR);
        @$sql->bindParam(2, $this->getCodDisc1(), PDO::PARAM_INT);
        @$sql->bindParam(3, $this->getCodDisc2(), PDO::PARAM_INT);
        @$sql->bindParam(4, $this->getCodDisc3(), PDO::PARAM_INT);
        @$sql->bindParam(5, $this->getCodCurso(), PDO::PARAM_INT);

        if ($sql->execute()) {
            return "Curso alterado com sucesso!";
        } else {
            return "Erro ao alterar o curso.";
        }
    } catch (PDOException $exc) {
        echo "Erro ao alterar curso: " . $exc->getMessage();
    }
}

}
