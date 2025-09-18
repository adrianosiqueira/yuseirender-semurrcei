package controller;


import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Unidade;
import view.TelaCadastroUnidade;
import view.TelaPrincipal;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.DAO.UnidadeDAO;


public class CadastroUnidadeController
{
    public Unidade obterModeloSemID()
    {

        String unidadenome = view.getTxtUnidade().getText();//String unidadenome recebe view pegue o texto

        //construir objeto do tipo unidade
        Unidade unidade = new Unidade(unidadenome);

        return unidade;

    }

    //metodo obter modelo com id
    public Unidade obterModeloComId()
    {

        Integer id = Integer.parseInt(view.getTxtId().getText());//Integer id recebe convert para int view gettxtid pegue o texto
        String unidadenome = view.getTxtUnidade().getText();//String unidadenome recebe view pegue o texto

        //construir objeto do tipo unidade
        Unidade unidade = new Unidade(id,unidadenome);

        return unidade;

    }

    //metodo para setar modelo


    //metodo para limpar os campos
    public void limparTela()
    {

        view.getTxtUnidade().setText("");

    }

    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        view.getTxtUnidade().setEnabled(false);

        view.btnEditar.setEnabled(false);
        view.btnSalvar.setEnabled(false);
        view.btnExcluir.setEnabled(true);
        view.btnPesquisar.setEnabled(false);
    }
    //cria arraylist do tipo Unidade chamado unidades
    ArrayList<Unidade> unidades = new ArrayList<Unidade>();

    //cria variavel do tipo telacadastrounidade e CadastroUnidadeHelper e chamando-as de view e helper
    private TelaCadastroUnidade view;


    //cria variavel tipo TelaPrincipal chamada telaprincipal
    public TelaPrincipal TelaPrincipal;

    //metodo construtor
    public CadastroUnidadeController(TelaCadastroUnidade view) {
        this.view = view;

    }

    //metodo construtor tela principal
    public CadastroUnidadeController(TelaPrincipal viewprincipal) {
        this.TelaPrincipal  = viewprincipal;
    }

    //metodo salvar unidade
    public void salvarUnidade()
    {

        //comparações logicas
        if(view.getTxtUnidade().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }

            //pega uma unidade da view
            Unidade unidade = obterModeloSemID();

                try
                {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo UnidadeDAO chamado unidadeDAO passando novo UnidadeDAO recebendo conexao
                    UnidadeDAO unidadeDAO = new UnidadeDAO(conexao);
                    //objeto do tipo unidade chamado unidades recebe unidadeDAO.inserir
                    unidadeDAO.inserir(unidade);

                    //helper chama o metodo bloquear campos
                    bloquearCampos();

                    //helper chama metodo limpar tela(Campos)
                    limparTela();

                    //chama tabela unidades;
                    tabelaUnidades();

                    JOptionPane.showMessageDialog(null, "Unidade inserida com sucesso!");

                    //pegue exceção sql
                }
                catch (SQLException ex)
                {

                    JOptionPane.showMessageDialog(null, "Error ao inserir unidade no banco de dados! /nError:"+ex);

                }

    }

    //metodo atualizar unidade
    public void updateUnidade()
    {

        //comparações logicas
        if(view.getTxtUnidade().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }

            //pega uma unidade da view
            Unidade unidade = new Unidade();

            //chama helper metodo obterModeloComId passando unidade como parametro
            unidade = obterModeloComId();

                try {
                    //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                    Connection conexao = new Conexao().Conectar();
                    //cria objeto do tipo UnidadeDAO chamado unidadeDAO passando novo UnidadeDAO recebendo conexao
                    UnidadeDAO unidadeDAO = new UnidadeDAO(conexao);
                    //objeto do tipo unidade chamado unidades recebe unidadeDAO.atualizar
                    unidadeDAO.atualizar(unidade);

                    //helper chama o metodo bloquear campos
                    bloquearCampos();

                    //helper chama metodo limpar tela(Campos)
                    limparTela();

                    //chama tabelaUnidades;
                    tabelaUnidades();

                    JOptionPane.showMessageDialog(null, "Unidade atualizada com sucesso!");

                    //pegue exceção sql
                } catch (SQLException ex)
                {

                    JOptionPane.showMessageDialog(null, "Error ao atualizar unidade no banco de dados! /nError:"+ex);

                }

    }

    //metodo deletar
    public void deletar()
    {

        //comparações logicas
        if(view.getTxtUnidade().getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Campos obrigatorios vazios, preencha-os!!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);

        }

        //pega uma unidade da view
        Unidade unidade = new Unidade();

        //chama helper metodo obtermodelo com id passando unidade como parametro
        unidade = obterModeloComId();

            try
            {

                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                //cria objeto do tipo UnidadeDAO chamado unidadeDAO passando novo UnidadeDAO recebendo conexao
                UnidadeDAO unidadeDAO = new UnidadeDAO(conexao);
                //objeto do tipo unidade chamado unidades recebe unidadeDAO.deletar
                unidadeDAO.deletar(unidade);


                //helper chama o metodo bloquear campos
                bloquearCampos();

                //helper chama metodo limpar tela(Campos)
                limparTela();

                //chama tabelaUnidades;
                tabelaUnidades();

                JOptionPane.showMessageDialog(null, "Unidade deletado com sucesso!");

            }
            catch(SQLException ex)
            {

                JOptionPane.showMessageDialog(null, "Error ao deletar unidade no banco de dados! /nError:"+ex);

            }

    }

    //metodo para selecionar todas Unidades
    public void selecionarAllUnidades()
    {

        try
        {

                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                //cria objeto do tipo UnidadeDAO chamado unidadeDAO passando novo UnidadeDAO recebendo conexao
                UnidadeDAO unidadeDAO = new UnidadeDAO(conexao);

                //arraylist unidades recebe unidadeDAO chamando metodo selecioneAllUnidade
                ArrayList unidades = unidadeDAO.selecioneAllUnidade();

                //helper chama o metodo bloquear campos
                bloquearCampos();

                //helper chama metodo limpar tela(Campos)
                limparTela();

                //chama tabelaUnidades;
                tabelaUnidades();

        }
        catch(SQLException ex)
        {

            JOptionPane.showMessageDialog(null, "Error ao pesquisar todas unidades!" + ex);

        }

    }

    //metodo tabelaUnidades
    public void tabelaUnidades()
    {

        //se a view a tabela for diferente de nulo
        if(view.jTabelaCadUnidade != null)
        {

            //modelo do tipo defaultablemodel recebe convertendo para defaulttablemodel a view passando a tabela e pegando seu modelo
            DefaultTableModel modelo = (DefaultTableModel) view.jTabelaCadUnidade.getModel();

            //se as linhas do modelo for maior que zero
            if(modelo.getRowCount() > 0)
            {

                //sete as linhas como 0
                modelo.setRowCount(0);

            }

            try
            {

                //cria objeto do tipo connection conexao passando novo Conexao(conexao.java) chamando metodo conectar
                Connection conexao = new Conexao().Conectar();
                //cria objeto do tipo UnidadeDAO chamado unidadeDAO passando novo UnidadeDAO recebendo conexao
                UnidadeDAO unidadeDAO = new UnidadeDAO(conexao);

                //arraylist unidades recebe unidadeDAO chamando metodo selecioneAllUnidade
                ArrayList<Unidade> unidades = unidadeDAO.selecioneAllUnidade();

                //para cada unidade no arraylist unidades
                for(Unidade unidade : unidades)
                {

                    //quantidade de linhas que o objeto vai ter
                    Object[] linha = new Object[2];

                    //pegue as respectivas linhas de cada unidade e as sete
                    linha[0] = unidade.getId();
                    linha[1] = unidade.getUnidadenome();
                    //adicione as linhas ao modelo
                    modelo.addRow(linha);

                }

            }

            catch(SQLException ex)
            {

                JOptionPane.showMessageDialog(null, "Error ao preencher tabela!" + ex);

            }

        }

    }

}
