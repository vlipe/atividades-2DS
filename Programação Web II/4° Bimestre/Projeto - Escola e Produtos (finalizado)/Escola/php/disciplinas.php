<?php

include_once 'conectar.php';

class Disciplina
{
    private $coddisciplina;
    private $nomedisciplina;
    private $conn;

    public function getCodDisciplina()
    {
        return $this->coddisciplina;
    }

    public function setCodDisciplina($disciplinas)
    {
        $this->coddisciplina = $disciplinas;
    }

    public function getNomeDisciplina()
    {
        return $this->nomedisciplina;
    }

    public function setNomeDisciplinas($disciplinas)
    {
        $this->nomedisciplina = $disciplinas;
    }

    public function listar()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->query("SELECT * FROM disciplina ORDER BY CodDisciplina");
            $sql->execute();
            return $sql->fetchAll();
            $this->conn = null;
        } catch (PDOException $exc) {
            echo "Erro ao executar consulta. " . $exc->getMessage();
        }
    }

    function consultar()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("SELECT * FROM disciplina WHERE nomedisciplina LIKE ?");
            @$sql->bindParam(1, $this->getCodDisciplina(), PDO::PARAM_STR);
            $sql->execute();
            $resultado = $sql->fetchAll(PDO::FETCH_NUM);
            $this->conn = null;
            return $resultado;
        } catch (PDOException $e) {
            echo "Erro na consulta: " . $e->getMessage();
            return [];
        }
    }

    public function salvar()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("INSERT INTO disciplina (CodDisciplina, NomeDisciplina) VALUES (?, ?)");
            $sql->bindParam(1, $this->coddisciplina, PDO::PARAM_INT);
            $sql->bindParam(2, $this->nomedisciplina, PDO::PARAM_STR);

            if ($sql->execute()) {
                return "Disciplina salva com sucesso!";
            } else {
                return "Erro ao salvar a disciplina.";
            }

            $this->conn = null;
        } catch (PDOException $exc) {
            return "Erro ao salvar a disciplina: " . $exc->getMessage();
        }
    }

    function exclusao()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare("delete from disciplina where CodDisciplina = ?");
            @$sql->bindParam(1, $this->getCodDisciplina(), PDO::PARAM_STR);
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
            @$sql = $this->conn->prepare("SELECT * FROM disciplina WHERE CodDisciplina = ?");
            @$sql->bindParam(1, $this->getCodDisciplina(), PDO::PARAM_INT);
            @$sql->execute();
            return $sql->fetchAll(PDO::FETCH_NUM);
        } catch (PDOException $exc) {
            echo "Erro ao buscar disciplina: " . $exc->getMessage();
        }
    }

    function alterar2()
    {
        try {
            $this->conn = new conectar();
            $sql = $this->conn->prepare(
                "UPDATE disciplina SET NomeDisciplina = ? WHERE CodDisciplina = ?"
            );
            @$sql->bindParam(1, $this->getNomeDisciplina(), PDO::PARAM_STR);
            @$sql->bindParam(2, $this->getCodDisciplina(), PDO::PARAM_INT);

            if ($sql->execute()) {
                return "Disciplina alterada com sucesso!";
            } else {
                return "Erro ao alterar a disciplina.";
            }
        } catch (PDOException $exc) {
            echo "Erro ao alterar disciplina: " . $exc->getMessage();
        }
    }
}

