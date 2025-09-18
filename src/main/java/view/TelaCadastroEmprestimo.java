package view;

import com.toedter.calendar.JDateChooser;
import controller.CadastroEmprestimoController;
import model.Emprestimo;
import model.Equipamento;
import model.Nome;
import model.TipoEquipamento;
import model.Unidade;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TelaCadastroEmprestimo extends javax.swing.JFrame {



    public Emprestimo obterModeloSemID()
    {


        Unidade unidade = (Unidade) getTxtUnidade().getSelectedItem();//Unidade unidade recebe passado para unidade a view gettextunidade e pegue o texto
        TipoEquipamento tipoequip = (TipoEquipamento) getTxtTipoEquip().getSelectedItem();//TipoEquipamento tipoequipamento recebe passado para unidade a view getTxtTipoEquip e pegue o texto
        Equipamento equipamento = (Equipamento) getTxtEquipamento().getSelectedItem();//Equipamento equipamento recebe passando para equipamento a view getTxtEquipamento e pegue o texto
        Unidade destino = (Unidade) getTxtDestino().getSelectedItem();//Unidade unidade recebe passado para unidade a view getTxtDestino e pegue o texto
        Nome nome = (Nome) getTxtNome().getSelectedItem();//Nome nome recebe passado para nome a view getTxtNome e pegue o texto
        Date dataSaida = (Date) getTxtDataSaida().getDate();//Date dataSaida recebe passado para Date a view getTxtDataSaida e pegue o texto
        Date dataDevolucao = (Date) getTxtDataDevolucao().getDate();//Date dataDevolucao recebe passado para Date a view getTxtDataDevolucao e pegue o texto
        String status = getTxtStatus().getSelectedItem().toString();//String status recebe view pegue o getselecteditem para string
        String tipo = getTxtTipo().getSelectedItem().toString();//String tipo recebe view pegue o getselecteditem para string
        String observacao = getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto
        String tombo = getTxtTombo().getSelectedItem().toString();//String tombo recebe view pegue o getTextTombo e pegue o texto
        String serie = getTxtSerie().getSelectedItem().toString();//String serie recebe view pegue o getTextSerie e pegue o texto

        if(getTxtObservacao().getText() == null)
        {

            observacao = "NULL";

        }
        else
        {

            observacao = getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto

        }

        //construir objeto do tipo emprestimo
        Emprestimo emprestimo = new Emprestimo(unidade,tipoequip,equipamento,destino,nome,dataSaida,dataDevolucao,status,tipo,observacao,tombo,serie);

        return emprestimo;

    }



    public Emprestimo obterModelo()
    {
        Integer id = Integer.parseInt(getTxtId().getText());
        Unidade unidade = (Unidade) getTxtUnidade().getSelectedItem();//Unidade unidade recebe passado para unidade a view gettextunidade e pegue o texto
        TipoEquipamento tipoequip = (TipoEquipamento) getTxtTipoEquip().getSelectedItem();//TipoEquipamento tipoequipamento recebe passado para unidade a view getTxtTipoEquip e pegue o texto
        Equipamento equipamento = (Equipamento) getTxtEquipamento().getSelectedItem();//Equipamento equipamento recebe passando para equipamento a view getTxtEquipamento e pegue o texto
        Unidade destino = (Unidade) getTxtDestino().getSelectedItem();//Unidade unidade recebe passado para unidade a view getTxtDestino e pegue o texto
        Nome nome = (Nome) getTxtNome().getSelectedItem();//Nome nome recebe passado para nome a view getTxtNome e pegue o texto
        Date dataSaida = (Date) getTxtDataSaida().getDate();//Date dataSaida recebe passado para Date a view getTxtDataSaida e pegue o texto
        Date dataDevolucao = (Date) getTxtDataDevolucao().getDate();//Date dataDevolucao recebe passado para Date a view getTxtDataDevolucao e pegue o texto
        String status = getTxtStatus().getSelectedItem().toString();//String status recebe view pegue o getselecteditem para string
        String tipo = getTxtTipo().getSelectedItem().toString();//String tipo recebe view pegue o getselecteditem para string
        String observacao = getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto
        String tombo = getTxtTombo().getSelectedItem().toString();//String tombo recebe view pegue o getTextTombo e pegue o texto
        String serie = getTxtSerie().getSelectedItem().toString();//String serie recebe view pegue o getTextSerie e pegue o texto

        if(getTxtObservacao().getText() == null)
        {

            observacao = "NULL";

        }
        else
        {

            observacao = getTxtObservacao().getText();//String observacao recebe view pegue o getTextObservacao e pegue o texto

        }

        //construir objeto do tipo emprestimo
        Emprestimo emprestimo = new Emprestimo(id,unidade,tipoequip,equipamento,destino,nome,dataSaida,dataDevolucao,status,tipo,observacao,tombo,serie);

        return emprestimo;

    }

    //metodo para setar modelo
    public void setModelo()
    {

        int setar = jTabelaCadEmprestimo.getSelectedRow();

        txtId.setText(jTabelaCadEmprestimo.getModel().getValueAt(setar, 0).toString());
        txtUnidade.setSelectedItem(jTabelaCadEmprestimo.getModel().getValueAt(setar, 1).toString());
        txtTipoEquip.setSelectedItem(jTabelaCadEmprestimo.getModel().getValueAt(setar, 2).toString());
        txtEquipamento.setSelectedItem(jTabelaCadEmprestimo.getModel().getValueAt(setar, 3).toString());
        txtDestino.setSelectedItem(jTabelaCadEmprestimo.getModel().getValueAt(setar, 4).toString());
        txtNome.setSelectedItem(jTabelaCadEmprestimo.getModel().getValueAt(setar, 5).toString());

        try
        {
            Date data = new SimpleDateFormat("dd-MM-yyyy").parse((String)jTabelaCadEmprestimo.getModel().getValueAt(setar, 6));

            txtDataSaida.setDate(data);
        } catch (ParseException ex)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

        try
        {
            Date data = new SimpleDateFormat("dd-MM-yyyy").parse((String)jTabelaCadEmprestimo.getModel().getValueAt(setar, 7));

            txtDataDevolucao.setDate(data);
        } catch (ParseException ex)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

        txtStatus.setSelectedItem(jTabelaCadEmprestimo.getModel().getValueAt(setar, 8).toString());

        txtTipo.setSelectedItem(jTabelaCadEmprestimo.getModel().getValueAt(setar, 9).toString());

        if(jTabelaCadEmprestimo.getModel().getValueAt(setar, 10).toString() != null)
        {

            txtObservacao.setText(jTabelaCadEmprestimo.getModel().getValueAt(setar, 10).toString());

        }
        else
        {

            txtObservacao.setText("NULO");

        }

        txtTombo.setSelectedItem(jTabelaCadEmprestimo.getModel().getValueAt(setar, 11).toString());
        txtSerie.setSelectedItem(jTabelaCadEmprestimo.getModel().getValueAt(setar, 12).toString());

    }

    //metodo para limpar os campos
    public void limparTela()
    {

        getTxtObservacao().setText("");
        getjTabelaCadEmprestimo().clearSelection();

    }

    //metodo para bloquear os campos
    public void bloquearCampos()
    {
        getTxtUnidade().setEnabled(false);
        getTxtTipoEquip().setEnabled(false);
        getTxtEquipamento().setEnabled(false);
        getTxtDestino().setEnabled(false);
        getTxtNome().setEnabled(false);
        getTxtDataSaida().setEnabled(false);
        getTxtDataDevolucao().setEnabled(false);
        getTxtStatus().setEnabled(false);
        getTxtObservacao().setEnabled(false);
        getTxtTombo().setEnabled(false);
        getTxtSerie().setEnabled(false);

        btnEditar.setEnabled(false);
        btnEmprestar.setEnabled(false);
        btnExcluir.setEnabled(true);
        btnPesquisar.setEnabled(false);
    }

    //metodo para desbloquear campos
    public void desbloquearCampos()
    {

        getTxtUnidade().setEnabled(true);
        getTxtTipoEquip().setEnabled(true);
        getTxtEquipamento().setEnabled(true);
        getTxtDestino().setEnabled(true);
        getTxtNome().setEnabled(true);
        getTxtDataSaida().setEnabled(true);
        getTxtDataDevolucao().setEnabled(true);
        getTxtStatus().setEnabled(true);
        getTxtObservacao().setEnabled(true);
        getTxtTombo().setEnabled(true);
        getTxtSerie().setEnabled(true);

        btnEditar.setEnabled(true);
        btnEmprestar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnPesquisar.setEnabled(true);

    }
    //criando campo controller
    private final CadastroEmprestimoController controller;


    public TelaCadastroEmprestimo() {
        initComponents();

        //controller esta passando view como parametro
        controller = new CadastroEmprestimoController(this);

        //inicia essa tela no centro
        this.setLocationRelativeTo(null);

        //chama o metodo iniciar
        this.iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTabelaCadEmprestimo = new JTable();
        lblTitulo = new javax.swing.JLabel();
        lblUnidade = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtDestino = new JComboBox<>();
        txtEquipamento = new JComboBox<>();
        lblEquipamento = new javax.swing.JLabel();
        txtUnidade = new JComboBox<>();
        lblTipoEquip = new javax.swing.JLabel();
        txtNome = new JComboBox<>();
        txtDataSaida = new com.toedter.calendar.JDateChooser();
        txtDataDevolucao = new com.toedter.calendar.JDateChooser();
        JButtonNome = new JButton();
        lblDataDevolucao = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        txtStatus = new JComboBox<>();
        lblDataSaida = new javax.swing.JLabel();
        lblObservacao = new javax.swing.JLabel();
        btnPesquisar = new JButton();
        btnEditar = new JButton();
        btnExcluir = new JButton();
        btnVoltar = new JButton();
        btnNovo = new JButton();
        txtTipoEquip = new JComboBox<>();
        btnEmprestar = new JButton();
        lblTombo = new javax.swing.JLabel();
        txtTombo = new JComboBox();
        lblSerie = new javax.swing.JLabel();
        txtSerie = new JComboBox();
        jScrollPane2 = new JScrollPane();
        txtObservacao = new JTextArea();
        txtId = new JTextField();
        lblfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabelaCadEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "unidade", "tipoequip", "equipamento", "destino", "nome", "datasaida", "datadevolucao", "status", "tipo", "observacao", "tombo", "serie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaCadEmprestimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaCadEmprestimoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaCadEmprestimo);
        if (jTabelaCadEmprestimo.getColumnModel().getColumnCount() > 0) {
            jTabelaCadEmprestimo.getColumnModel().getColumn(0).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(1).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(2).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(3).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(4).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(5).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(6).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(7).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(8).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(9).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(10).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(11).setResizable(false);
            jTabelaCadEmprestimo.getColumnModel().getColumn(12).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 370, 1250, 280));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("CADASTRO EMPRESTIMO");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 390, -1));

        lblUnidade.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUnidade.setForeground(new java.awt.Color(255, 255, 255));
        lblUnidade.setText("UNIDADE:");
        lblUnidade.setMaximumSize(new java.awt.Dimension(39, 29));
        lblUnidade.setMinimumSize(new java.awt.Dimension(39, 29));
        lblUnidade.setPreferredSize(new java.awt.Dimension(39, 29));
        getContentPane().add(lblUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 30));

        lblID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID:");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        lblDestino.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDestino.setForeground(new java.awt.Color(255, 255, 255));
        lblDestino.setText("DESTINO:");
        getContentPane().add(lblDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 30));

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("NOME:");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 30));

        txtDestino.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });
        getContentPane().add(txtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 220, 30));

        txtEquipamento.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtEquipamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtEquipamentoItemStateChanged(evt);
            }
        });
        txtEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipamentoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 320, 30));

        lblEquipamento.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblEquipamento.setForeground(new java.awt.Color(255, 255, 255));
        lblEquipamento.setText("EQUIPAMENTO:");
        getContentPane().add(lblEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 30));

        txtUnidade.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadeActionPerformed(evt);
            }
        });
        getContentPane().add(txtUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 220, 30));

        lblTipoEquip.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTipoEquip.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoEquip.setText("TIPOEQUIP:");
        getContentPane().add(lblTipoEquip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        txtNome.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 380, 30));

        txtDataSaida.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(txtDataSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 280, 30));

        txtDataDevolucao.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(txtDataDevolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 280, 30));

        JButtonNome.setBackground(new java.awt.Color(30, 129, 176));
        JButtonNome.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        JButtonNome.setForeground(new java.awt.Color(255, 255, 255));
        JButtonNome.setText("+");
        JButtonNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonNomeActionPerformed(evt);
            }
        });
        getContentPane().add(JButtonNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 50, 30));

        lblDataDevolucao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDataDevolucao.setForeground(new java.awt.Color(255, 255, 255));
        lblDataDevolucao.setText("DATA DEVOLUÇÃO:");
        getContentPane().add(lblDataDevolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 30));

        lblTipo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("TIPO:");
        lblTipo.setMaximumSize(new java.awt.Dimension(39, 29));
        lblTipo.setMinimumSize(new java.awt.Dimension(39, 29));
        lblTipo.setPreferredSize(new java.awt.Dimension(39, 29));
        getContentPane().add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 70, 30));

        txtTipo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPRESTIMO", "CESSAO" }));
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 220, 30));

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("STATUS:");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, 30));

        txtStatus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE UM STATUS", "EMPRESTADO", "DISPONIVEL", "INDISPONIVEL", "MANUTENÇÃO" }));
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });
        getContentPane().add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 290, 30));

        lblDataSaida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDataSaida.setForeground(new java.awt.Color(255, 255, 255));
        lblDataSaida.setText("DATA SAIDA:");
        getContentPane().add(lblDataSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        lblObservacao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblObservacao.setForeground(new java.awt.Color(255, 255, 255));
        lblObservacao.setText("OBSERVAÇÃO:");
        getContentPane().add(lblObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, 30));

        btnPesquisar.setBackground(new java.awt.Color(30, 129, 176));
        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 280, 110, 40));

        btnEditar.setBackground(new java.awt.Color(30, 129, 176));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, 110, 40));

        btnExcluir.setBackground(new java.awt.Color(30, 129, 176));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 330, 110, 40));

        btnVoltar.setBackground(new java.awt.Color(30, 129, 176));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 330, 110, 40));

        btnNovo.setBackground(new java.awt.Color(30, 129, 176));
        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 280, 110, 40));

        txtTipoEquip.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtTipoEquip.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtTipoEquipItemStateChanged(evt);
            }
        });
        getContentPane().add(txtTipoEquip, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 320, 30));

        btnEmprestar.setBackground(new java.awt.Color(30, 129, 176));
        btnEmprestar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmprestar.setForeground(new java.awt.Color(255, 255, 255));
        btnEmprestar.setText("EMPRESTAR");
        btnEmprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmprestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 330, 110, 40));

        lblTombo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTombo.setForeground(new java.awt.Color(255, 255, 255));
        lblTombo.setText("TOMBO:");
        getContentPane().add(lblTombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, -1, 30));

        txtTombo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtTombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtTomboItemStateChanged(evt);
            }
        });
        getContentPane().add(txtTombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 170, 30));

        lblSerie.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSerie.setForeground(new java.awt.Color(255, 255, 255));
        lblSerie.setText("SERIE:");
        getContentPane().add(lblSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, 30));

        txtSerie.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 170, 30));

        txtObservacao.setColumns(20);
        txtObservacao.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtObservacao.setRows(5);
        jScrollPane2.setViewportView(txtObservacao);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 490, 80));

        txtId.setBackground(new java.awt.Color(60, 63, 65));
        txtId.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtId.setEnabled(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 100, -1));

        lblfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/PARTE INTERNA2.png"))); // NOI18N
        getContentPane().add(lblfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestarActionPerformed
        //controller chama metodo emprestar

        //chama o metodo iniciar
        iniciar();
    }//GEN-LAST:event_btnEmprestarActionPerformed

    private void txtUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadeActionPerformed

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtTomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtTomboItemStateChanged

    }//GEN-LAST:event_txtTomboItemStateChanged

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        //tente chamar a tela principal
        try
        {


            this.dispose();

            TelaPrincipal telaprincip = new TelaPrincipal();
            telaprincip.setVisible(true);

        }
        //se não conseguir pegue a excesão e mostre a mensagem na tela junto com a excesão
        catch(Exception ex)
        {

            JOptionPane.showMessageDialog(null, "Error ao chamar a tela principal!" + ex);

        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //controller chama metodo devolver

        //chama o metodo iniciar
        iniciar();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        //controller chama metodo update emprestimo

        //chama o metodo iniciar;
        iniciar();

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        //ao clickar chama o helper em novo seta todos os campos como true
        desbloquearCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void jTabelaCadEmprestimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaCadEmprestimoMouseClicked
        //Chama o helper metodo obter modelo;
        obterModelo();
    }//GEN-LAST:event_jTabelaCadEmprestimoMouseClicked

    private void JButtonNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonNomeActionPerformed
        //Chama tela cadastro nome
        this.dispose();

        TelaCadastroPessoa telacadnome = new TelaCadastroPessoa();
        telacadnome.setVisible(true);
    }//GEN-LAST:event_JButtonNomeActionPerformed

    private void txtEquipamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtEquipamentoItemStateChanged

    }//GEN-LAST:event_txtEquipamentoItemStateChanged

    private void txtTipoEquipItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtTipoEquipItemStateChanged
        String tipoequipamentonome = txtTipoEquip.getSelectedItem().toString();

        if(!txtTipoEquip.getSelectedItem().equals(tipoequipamentonome))
        {

            //chama este metodo do controller
            controller.atualizaEquipamentoModelo(tipoequipamentonome);

            String equip = txtEquipamento.getSelectedItem().toString();

            if(txtEquipamento.getSelectedItem().equals(equip))
            {

                //chama este metodo do controller
                controller.atualizaComboTombo(equip);
                controller.atualizaComboSerie(equip);

            }

        }

    }//GEN-LAST:event_txtTipoEquipItemStateChanged

    private void txtEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipamentoActionPerformed



    }//GEN-LAST:event_txtEquipamentoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroEmprestimo().setVisible(true);
            }
        });
    }

    //Getters e setters do campo

    public static JButton getBtnEditar() {
        return btnEditar;
    }

    public static void setBtnEditar(JButton btnEditar) {
        TelaCadastroEmprestimo.btnEditar = btnEditar;
    }

    public JButton getBtnEmprestar() {
        return btnEmprestar;
    }

    public void setBtnEmprestar(JButton btnEmprestar) {
        this.btnEmprestar = btnEmprestar;
    }

    public static JButton getBtnExcluir() {
        return btnExcluir;
    }

    public static void setBtnExcluir(JButton btnExcluir) {
        TelaCadastroEmprestimo.btnExcluir = btnExcluir;
    }

    public static JButton getBtnNovo() {
        return btnNovo;
    }

    public static void setBtnNovo(JButton btnNovo) {
        TelaCadastroEmprestimo.btnNovo = btnNovo;
    }

    public static JButton getBtnPesquisar() {
        return btnPesquisar;
    }

    public static void setBtnPesquisar(JButton btnPesquisar) {
        TelaCadastroEmprestimo.btnPesquisar = btnPesquisar;
    }

    public static JButton getBtnVoltar1() {
        return btnVoltar;
    }

    public static void setBtnVoltar1(JButton btnVoltar1) {
        TelaCadastroEmprestimo.btnVoltar = btnVoltar1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getjTabelaCadEmprestimo() {
        return jTabelaCadEmprestimo;
    }

    public void setjTabelaCadEmprestimo(JTable jTabelaCadEmprestimo) {
        this.jTabelaCadEmprestimo = jTabelaCadEmprestimo;
    }

    public static JDateChooser getTxtDataDevolucao() {
        return txtDataDevolucao;
    }

    public static void setTxtDataDevolucao(JDateChooser txtDataDevolucao) {
        TelaCadastroEmprestimo.txtDataDevolucao = txtDataDevolucao;
    }

    public static JDateChooser getTxtDataSaida() {
        return txtDataSaida;
    }

    public static void setTxtDataSaida(JDateChooser txtDataSaida) {
        TelaCadastroEmprestimo.txtDataSaida = txtDataSaida;
    }

    public static JComboBox<String> getTxtDestino() {
        return txtDestino;
    }

    public static void setTxtDestino(JComboBox<String> txtDestino) {
        TelaCadastroEmprestimo.txtDestino = txtDestino;
    }

    public static JComboBox<String> getTxtEquipamento() {
        return txtEquipamento;
    }

    public static void setTxtEquipamento(JComboBox<String> txtEquipamento) {
        TelaCadastroEmprestimo.txtEquipamento = txtEquipamento;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JComboBox<String> getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(JComboBox<String> txtNome) {
        this.txtNome = txtNome;
    }

    public static JTextArea getTxtObservacao() {
        return txtObservacao;
    }

    public static void setTxtObservacao(JTextArea txtObservacao) {
        TelaCadastroEmprestimo.txtObservacao = txtObservacao;
    }

    public static JComboBox getTxtSerie() {
        return txtSerie;
    }

    public static void setTxtSerie(JComboBox txtSerie) {
        TelaCadastroEmprestimo.txtSerie = txtSerie;
    }

    public static JComboBox<String> getTxtStatus() {
        return txtStatus;
    }

    public static void setTxtStatus(JComboBox<String> txtStatus) {
        TelaCadastroEmprestimo.txtStatus = txtStatus;
    }

    public static JComboBox<String> getTxtTipo() {
        return txtTipo;
    }

    public static void setTxtTipo(JComboBox<String> txtTipo) {
        TelaCadastroEmprestimo.txtTipo = txtTipo;
    }

    public static JComboBox<String> getTxtTipoEquip() {
        return txtTipoEquip;
    }

    public static void setTxtTipoEquip(JComboBox<String> txtTipoEquip) {
        TelaCadastroEmprestimo.txtTipoEquip = txtTipoEquip;
    }

    public static JComboBox getTxtTombo() {
        return txtTombo;
    }

    public static void setTxtTombo(JComboBox txtTombo) {
        TelaCadastroEmprestimo.txtTombo = txtTombo;
    }

    public static JComboBox<String> getTxtUnidade() {
        return txtUnidade;
    }

    public static void setTxtUnidade(JComboBox<String> txtUnidade) {
        TelaCadastroEmprestimo.txtUnidade = txtUnidade;
    }


    //metodo para iniciar elementos ao iniciar o frame
    public void iniciar()
    {

        //impedir o usuario de mover as colunas para reoodena-las
        jTabelaCadEmprestimo.getTableHeader().setReorderingAllowed(false);

            //inicia combobox atualiza unidade
            controller.atualizaUnidade();

            //inicia combobox atualizarTipoEquip
            controller.atualizarTipoEquip();

            //inicia combobox atualizaEquipamento
            controller.atualizaEquipamento();

            //inicia combobox atualizaDestino
            controller.atualizardestino();

            //inicia combobox nome
            controller.atualizaNome();

            //incia combobox tombo
            controller.atualizaTombo();

            //inicia combobo serie
            controller.atualizaSerie();

            //as linhas abaixo define o tamanho das colunas da tabela
            //tabela pegue o modelo de coluna, pegue a coluna zero e sete a largura
            jTabelaCadEmprestimo.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTabelaCadEmprestimo.getColumnModel().getColumn(1).setPreferredWidth(88);
            jTabelaCadEmprestimo.getColumnModel().getColumn(2).setPreferredWidth(102);
            jTabelaCadEmprestimo.getColumnModel().getColumn(3).setPreferredWidth(102);
            jTabelaCadEmprestimo.getColumnModel().getColumn(4).setPreferredWidth(87);
            jTabelaCadEmprestimo.getColumnModel().getColumn(5).setPreferredWidth(160);
            jTabelaCadEmprestimo.getColumnModel().getColumn(6).setPreferredWidth(110);
            jTabelaCadEmprestimo.getColumnModel().getColumn(7).setPreferredWidth(110);
            jTabelaCadEmprestimo.getColumnModel().getColumn(8).setPreferredWidth(105);
            jTabelaCadEmprestimo.getColumnModel().getColumn(9).setPreferredWidth(125);
            jTabelaCadEmprestimo.getColumnModel().getColumn(10).setPreferredWidth(160);
            jTabelaCadEmprestimo.getColumnModel().getColumn(11).setPreferredWidth(90);
            jTabelaCadEmprestimo.getColumnModel().getColumn(12).setPreferredWidth(90);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static JButton JButtonNome;
    public static JButton btnEditar;
    public static JButton btnEmprestar;
    public static JButton btnExcluir;
    public static JButton btnNovo;
    public static JButton btnPesquisar;
    public static JButton btnVoltar;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    public static JTable jTabelaCadEmprestimo;
    private javax.swing.JLabel lblDataDevolucao;
    private javax.swing.JLabel lblDataSaida;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblEquipamento;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipoEquip;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTombo;
    private javax.swing.JLabel lblUnidade;
    private javax.swing.JLabel lblfundo;
    public static com.toedter.calendar.JDateChooser txtDataDevolucao;
    public static com.toedter.calendar.JDateChooser txtDataSaida;
    public static JComboBox<String> txtDestino;
    public static JComboBox<String> txtEquipamento;
    public static JTextField txtId;
    public static JComboBox<String> txtNome;
    public static JTextArea txtObservacao;
    public static JComboBox txtSerie;
    public static JComboBox<String> txtStatus;
    public static JComboBox<String> txtTipo;
    public static JComboBox<String> txtTipoEquip;
    public static JComboBox txtTombo;
    public static JComboBox<String> txtUnidade;
    // End of variables declaration//GEN-END:variables
}
