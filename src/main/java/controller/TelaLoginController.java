
package controller;

import java.sql.Connection;
import model.DAO.LoginDAO;
import model.Login;
import view.TelaLogin;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaLoginController
{

    //controllador que vai efetuar a autenticação do usuario

    private TelaLogin view;
    //controllador que vai obter ou setar o modelo


    public TelaLoginController(TelaLogin view) {
        this.view = view;
    }

    //metodo autenticar
    public void autenticar() throws SQLException
    {

        //comparações logicas
        if(view.txtLogin.getText().trim().isEmpty() && view.txtSenha.getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campo usuario e senha estão vazios!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.txtLogin.getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campo usuario esta vazio!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }
        else if(view.txtSenha.getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campo senha esta vazio!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }

        //Busca usuario da view
        Login login = obterModelo();

        //verifica se existe no banco de dados
        //chama loginDAO
        Connection conexao = new Conexao().Conectar();
        LoginDAO loginDAO = new LoginDAO(conexao);

        //existe loginAutenticar no banco por pesquisarUsuarioSenha?
        boolean existe = loginDAO.pesquisarUsuarioSenha(login);

        //se existir direciona para tela principal
        if(existe)
        {
            //mensagem no console informando que o usuario existe
            System.out.println("Usuario existe!");

        }
        else//senao
        {

        JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalidos, ou não existe no banco de dados!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }

    }        public Login obterModelo()
{

    String usuario = view.getTxtLogin().getText();//string usuario recebe view pegue gettxtlogin e pegue o texto
    String senha = view.getTxtSenha().getText();//string senha recebe view pegue gettxtsenha e pegue o texto
    //construir objeto do tipo login
    Login login = new Login(usuario,senha);

    return login;

}

}
