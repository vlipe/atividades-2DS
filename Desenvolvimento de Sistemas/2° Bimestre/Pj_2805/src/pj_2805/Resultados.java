package pj_2805;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Resultados extends JFrame {

    JLabel rnome, rmatricula, rcurso, rserie, rperiodo, rrestricoes;
    JLabel nome, matricula, curso, serie, periodo, restricoes;
    JButton voltar, sair;

    public Resultados(String nom, String matr, String curs, String seri, String period, String restricoe) {

        super("Resultados do Aluno");
        ImageIcon icone = new ImageIcon("imagens/estudante.png");
        setIconImage(icone.getImage());
        Container tela = getContentPane();
        setLayout(null);
        tela.setBackground(new Color(38, 38, 59));

        Font fonte = new Font("Poppins", Font.PLAIN, 14);
        Color cor = Color.white;

        rnome = new JLabel("Nome:");
        rnome.setFont(fonte);
        rnome.setForeground(cor);
        rnome.setBounds(50, 60, 100, 20);

        nome = new JLabel(nom);
        nome.setFont(fonte);
        nome.setForeground(cor);
        nome.setBounds(150, 60, 400, 20);
        
        rmatricula = new JLabel("Matrícula:");
        rmatricula.setFont(fonte);
        rmatricula.setForeground(cor);
        rmatricula.setBounds(50, 90, 100, 20);

        matricula = new JLabel(matr);
        matricula.setFont(fonte);
        matricula.setForeground(cor);
        matricula.setBounds(150, 90, 400, 20);

        rcurso = new JLabel("Curso:");
        rcurso.setFont(fonte);
        rcurso.setForeground(cor);
        rcurso.setBounds(50, 120, 100, 20);

        curso = new JLabel(curs);
        curso.setFont(fonte);
        curso.setForeground(cor);
        curso.setBounds(150, 120, 400, 20);

        rserie = new JLabel("Série:");
        rserie.setFont(fonte);
        rserie.setForeground(cor);
        rserie.setBounds(50, 150, 100, 20);

        serie = new JLabel(seri);
        serie.setFont(fonte);
        serie.setForeground(cor);
        serie.setBounds(150, 150, 400, 20);

        rperiodo = new JLabel("Turno:");
        rperiodo.setFont(fonte);
        rperiodo.setForeground(cor);
        rperiodo.setBounds(50, 180, 100, 20);

        periodo = new JLabel(period);
        periodo.setFont(fonte);
        periodo.setForeground(cor);
        periodo.setBounds(150, 180, 400, 20);

        rrestricoes = new JLabel("Restrições:");
        rrestricoes.setFont(fonte);
        rrestricoes.setForeground(cor);
        rrestricoes.setBounds(50, 210, 100, 20);

        restricoes = new JLabel(restricoe);
        restricoes.setFont(fonte);
        restricoes.setForeground(cor);
        restricoes.setBounds(150, 210, 400, 20);

        voltar = new JButton("Voltar");
        voltar.setBounds(150, 320, 150, 30);
        voltar.setFont(fonte);
        voltar.setBackground(new Color(81, 137, 250));
        voltar.setForeground(Color.white);
        voltar.setBorderPainted(false);

        sair = new JButton("Sair");
        sair.setBounds(320, 320, 150, 30);
        sair.setBackground(new Color(81, 137, 250));
        sair.setForeground(Color.white);
        sair.setBorderPainted(false);
        sair.setFont(fonte);

        voltar.addActionListener(e -> {
            new Interface();
            dispose();
        });
        
        voltar.setMnemonic(KeyEvent.VK_V);
        sair.setMnemonic(KeyEvent.VK_S);
        
        tela.add(rnome);
        tela.add(nome);
        tela.add(rmatricula);
        tela.add(matricula);
        tela.add(rcurso);
        tela.add(curso);
        tela.add(rserie);
        tela.add(serie);
        tela.add(rperiodo);
        tela.add(periodo);
        tela.add(rrestricoes);
        tela.add(restricoes);
        tela.add(voltar);
        tela.add(sair);

        sair.addActionListener(e -> System.exit(0));

        setSize(800, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
