package view;

import com.toedter.calendar.JDateChooser;
import controller.CadastroEmprestimoController;
import lombok.Getter;
import model.Emprestimo;
import model.Equipamento;
import model.Nome;
import model.TipoEquipamento;
import model.Unidade;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class TelaCadastroEmprestimo extends JFrame {

    private JTable tblEmprestimo;

    private JButton btnNome;
    private JButton btnEditar;
    private JButton btnEmprestar;
    private JButton btnExcluir;
    private JButton btnNovo;
    private JButton btnPesquisar;
    private JButton btnVoltar;

    private JDateChooser txtDataDevolucao;
    private JDateChooser txtDataSaida;

    private JComboBox<String> cbxDestino;
    private JComboBox<String> cbxEquipamento;
    private JComboBox<String> cbxNome;
    private JComboBox<String> cbxSerie;
    private JComboBox<String> cbxStatus;
    private JComboBox<String> cbxTipo;
    private JComboBox<String> cbxTipoEquip;
    private JComboBox<String> cbxTombo;
    private JComboBox<String> cbxUnidade;

    private JTextField txtId;
    private JTextArea txtObservacao;

    private JScrollPane pnl1;
    private JScrollPane pnl2;

    private JLabel lblDataDevolucao;
    private JLabel lblDataSaida;
    private JLabel lblDestino;
    private JLabel lblEquipamento;
    private JLabel lblID;
    private JLabel lblNome;
    private JLabel lblObservacao;
    private JLabel lblSerie;
    private JLabel lblStatus;
    private JLabel lblTipo;
    private JLabel lblTipoEquip;
    private JLabel lblTitulo;
    private JLabel lblTombo;
    private JLabel lblUnidade;
    private JLabel lblfundo;

    private CadastroEmprestimoController controller;

    public TelaCadastroEmprestimo() {
        this.controller = new CadastroEmprestimoController(this);

        initComponents();
        executarConfiguracaoInicial();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("DataFlowIssue")
    public Emprestimo obterModeloSemID() {
        String observacao = txtObservacao.getText().isBlank()
            ? "NULL"
            : txtObservacao.getText();

        return new Emprestimo(
            (Unidade) cbxUnidade.getSelectedItem(),
            (TipoEquipamento) cbxTipoEquip.getSelectedItem(),
            (Equipamento) cbxEquipamento.getSelectedItem(),
            (Unidade) cbxDestino.getSelectedItem(),
            (Nome) cbxNome.getSelectedItem(),
            txtDataSaida.getDate(),
            txtDataDevolucao.getDate(),
            cbxStatus.getSelectedItem().toString(),
            cbxTipo.getSelectedItem().toString(),
            observacao,
            cbxTombo.getSelectedItem().toString(),
            cbxSerie.getSelectedItem().toString()
        );
    }

    @SuppressWarnings("UnusedReturnValue")
    public Emprestimo obterModelo() {
        Integer id = Integer.parseInt(txtId.getText());

        Emprestimo emprestimo = obterModeloSemID();
        emprestimo.setId(id);

        return emprestimo;
    }

    public void setModelo() {
        int setar = tblEmprestimo.getSelectedRow();

        txtId.setText(tblEmprestimo.getModel().getValueAt(setar, 0).toString());
        cbxUnidade.setSelectedItem(tblEmprestimo.getModel().getValueAt(setar, 1).toString());
        cbxTipoEquip.setSelectedItem(tblEmprestimo.getModel().getValueAt(setar, 2).toString());
        cbxEquipamento.setSelectedItem(tblEmprestimo.getModel().getValueAt(setar, 3).toString());
        cbxDestino.setSelectedItem(tblEmprestimo.getModel().getValueAt(setar, 4).toString());
        cbxNome.setSelectedItem(tblEmprestimo.getModel().getValueAt(setar, 5).toString());

        try {
            Date data = new SimpleDateFormat("dd-MM-yyyy").parse((String) tblEmprestimo.getModel().getValueAt(setar, 6));

            txtDataSaida.setDate(data);
        } catch (ParseException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Date data = new SimpleDateFormat("dd-MM-yyyy").parse((String) tblEmprestimo.getModel().getValueAt(setar, 7));

            txtDataDevolucao.setDate(data);
        } catch (ParseException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

        cbxStatus.setSelectedItem(tblEmprestimo.getModel().getValueAt(setar, 8).toString());

        cbxTipo.setSelectedItem(tblEmprestimo.getModel().getValueAt(setar, 9).toString());

        if (tblEmprestimo.getModel().getValueAt(setar, 10).toString() != null) {

            txtObservacao.setText(tblEmprestimo.getModel().getValueAt(setar, 10).toString());
        } else {

            txtObservacao.setText("NULO");
        }

        cbxTombo.setSelectedItem(tblEmprestimo.getModel().getValueAt(setar, 11).toString());
        cbxSerie.setSelectedItem(tblEmprestimo.getModel().getValueAt(setar, 12).toString());
    }

    public void limparTela() {
        getTxtObservacao().setText("");
        getTblEmprestimo().clearSelection();
    }

    public void bloquearCampos() {
        getCbxUnidade().setEnabled(false);
        getCbxTipoEquip().setEnabled(false);
        getCbxEquipamento().setEnabled(false);
        getCbxDestino().setEnabled(false);
        getCbxNome().setEnabled(false);
        getTxtDataSaida().setEnabled(false);
        getTxtDataDevolucao().setEnabled(false);
        getCbxStatus().setEnabled(false);
        getTxtObservacao().setEnabled(false);
        getCbxTombo().setEnabled(false);
        getCbxSerie().setEnabled(false);

        btnEditar.setEnabled(false);
        btnEmprestar.setEnabled(false);
        btnExcluir.setEnabled(true);
        btnPesquisar.setEnabled(false);
    }

    public void desbloquearCampos() {

        getCbxUnidade().setEnabled(true);
        getCbxTipoEquip().setEnabled(true);
        getCbxEquipamento().setEnabled(true);
        getCbxDestino().setEnabled(true);
        getCbxNome().setEnabled(true);
        getTxtDataSaida().setEnabled(true);
        getTxtDataDevolucao().setEnabled(true);
        getCbxStatus().setEnabled(true);
        getTxtObservacao().setEnabled(true);
        getCbxTombo().setEnabled(true);
        getCbxSerie().setEnabled(true);

        btnEditar.setEnabled(true);
        btnEmprestar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnPesquisar.setEnabled(true);
    }

    private void initComponents() {
        pnl1 = new JScrollPane();
        tblEmprestimo = new JTable();
        lblTitulo = new JLabel();
        lblUnidade = new JLabel();
        lblID = new JLabel();
        lblDestino = new JLabel();
        lblNome = new JLabel();
        cbxDestino = new JComboBox<>();
        cbxEquipamento = new JComboBox<>();
        lblEquipamento = new JLabel();
        cbxUnidade = new JComboBox<>();
        lblTipoEquip = new JLabel();
        cbxNome = new JComboBox<>();
        txtDataSaida = new JDateChooser();
        txtDataDevolucao = new JDateChooser();
        btnNome = new JButton();
        lblDataDevolucao = new JLabel();
        lblTipo = new JLabel();
        cbxTipo = new JComboBox<>();
        lblStatus = new JLabel();
        cbxStatus = new JComboBox<>();
        lblDataSaida = new JLabel();
        lblObservacao = new JLabel();
        btnPesquisar = new JButton();
        btnEditar = new JButton();
        btnExcluir = new JButton();
        btnVoltar = new JButton();
        btnNovo = new JButton();
        cbxTipoEquip = new JComboBox<>();
        btnEmprestar = new JButton();
        lblTombo = new JLabel();
        cbxTombo = new JComboBox<>();
        lblSerie = new JLabel();
        cbxSerie = new JComboBox<>();
        pnl2 = new JScrollPane();
        txtObservacao = new JTextArea();
        txtId = new JTextField();
        lblfundo = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());

        tblEmprestimo.setModel(new DefaultTableModel(
            new Object[][]{

            },
            new String[]{
                "id", "unidade", "tipoequip", "equipamento", "destino", "nome", "datasaida", "datadevolucao", "status", "tipo", "observacao", "tombo", "serie"
            }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblEmprestimo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTabelaCadEmprestimoMouseClicked(evt);
            }
        });
        pnl1.setViewportView(tblEmprestimo);
        if (tblEmprestimo.getColumnModel().getColumnCount() > 0) {
            tblEmprestimo.getColumnModel().getColumn(0).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(1).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(2).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(3).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(4).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(5).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(6).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(7).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(8).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(9).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(10).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(11).setResizable(false);
            tblEmprestimo.getColumnModel().getColumn(12).setResizable(false);
        }

        getContentPane().add(pnl1, new AbsoluteConstraints(2, 370, 1250, 280));

        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setText("CADASTRO EMPRESTIMO");
        getContentPane().add(lblTitulo, new AbsoluteConstraints(420, 0, 390, -1));

        lblUnidade.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblUnidade.setForeground(new Color(255, 255, 255));
        lblUnidade.setText("UNIDADE:");
        lblUnidade.setMaximumSize(new Dimension(39, 29));
        lblUnidade.setMinimumSize(new Dimension(39, 29));
        lblUnidade.setPreferredSize(new Dimension(39, 29));
        getContentPane().add(lblUnidade, new AbsoluteConstraints(10, 60, 130, 30));

        lblID.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblID.setForeground(new Color(255, 255, 255));
        lblID.setText("ID:");
        getContentPane().add(lblID, new AbsoluteConstraints(10, 20, -1, 30));

        lblDestino.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblDestino.setForeground(new Color(255, 255, 255));
        lblDestino.setText("DESTINO:");
        getContentPane().add(lblDestino, new AbsoluteConstraints(10, 180, -1, 30));

        lblNome.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNome.setForeground(new Color(255, 255, 255));
        lblNome.setText("NOME:");
        getContentPane().add(lblNome, new AbsoluteConstraints(10, 220, -1, 30));

        cbxDestino.setFont(new Font("Tahoma", Font.BOLD, 20));
        cbxDestino.addActionListener(_ -> {});
        getContentPane().add(cbxDestino, new AbsoluteConstraints(140, 180, 220, 30));

        cbxEquipamento.setFont(new Font("Tahoma", Font.BOLD, 20));
        cbxEquipamento.addItemListener(_ -> {});
        cbxEquipamento.addActionListener(_ -> {});
        getContentPane().add(cbxEquipamento, new AbsoluteConstraints(210, 140, 320, 30));

        lblEquipamento.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblEquipamento.setForeground(new Color(255, 255, 255));
        lblEquipamento.setText("EQUIPAMENTO:");
        getContentPane().add(lblEquipamento, new AbsoluteConstraints(10, 140, -1, 30));

        cbxUnidade.setFont(new Font("Tahoma", Font.BOLD, 20));
        cbxUnidade.addActionListener(_ -> {});
        getContentPane().add(cbxUnidade, new AbsoluteConstraints(140, 60, 220, 30));

        lblTipoEquip.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTipoEquip.setForeground(new Color(255, 255, 255));
        lblTipoEquip.setText("TIPOEQUIP:");
        getContentPane().add(lblTipoEquip, new AbsoluteConstraints(10, 100, -1, 30));

        cbxNome.setFont(new Font("Tahoma", Font.BOLD, 20));
        getContentPane().add(cbxNome, new AbsoluteConstraints(100, 220, 380, 30));

        txtDataSaida.setFont(new Font("Tahoma", Font.BOLD, 20));
        getContentPane().add(txtDataSaida, new AbsoluteConstraints(180, 260, 280, 30));

        txtDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 20));
        getContentPane().add(txtDataDevolucao, new AbsoluteConstraints(250, 300, 280, 30));

        btnNome.setBackground(new Color(30, 129, 176));
        btnNome.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNome.setForeground(new Color(255, 255, 255));
        btnNome.setText("+");
        btnNome.addActionListener(this::JButtonNomeActionPerformed);
        getContentPane().add(btnNome, new AbsoluteConstraints(480, 220, 50, 30));

        lblDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblDataDevolucao.setForeground(new Color(255, 255, 255));
        lblDataDevolucao.setText("DATA DEVOLUÇÃO:");
        getContentPane().add(lblDataDevolucao, new AbsoluteConstraints(10, 300, -1, 30));

        lblTipo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTipo.setForeground(new Color(255, 255, 255));
        lblTipo.setText("TIPO:");
        lblTipo.setMaximumSize(new Dimension(39, 29));
        lblTipo.setMinimumSize(new Dimension(39, 29));
        lblTipo.setPreferredSize(new Dimension(39, 29));
        getContentPane().add(lblTipo, new AbsoluteConstraints(550, 60, 70, 30));

        cbxTipo.setFont(new Font("Tahoma", Font.BOLD, 20));
        cbxTipo.setModel(new DefaultComboBoxModel<>(new String[]{"EMPRESTIMO", "CESSAO"}));
        cbxTipo.addActionListener(_ -> {});
        getContentPane().add(cbxTipo, new AbsoluteConstraints(630, 60, 220, 30));

        lblStatus.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblStatus.setForeground(new Color(255, 255, 255));
        lblStatus.setText("STATUS:");
        getContentPane().add(lblStatus, new AbsoluteConstraints(10, 340, -1, 30));

        cbxStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
        cbxStatus.setModel(new DefaultComboBoxModel<>(new String[]{"SELECIONE UM STATUS", "EMPRESTADO", "DISPONIVEL", "INDISPONIVEL", "MANUTENÇÃO"}));
        cbxStatus.addActionListener(_ -> {});
        getContentPane().add(cbxStatus, new AbsoluteConstraints(120, 340, 290, 30));

        lblDataSaida.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblDataSaida.setForeground(new Color(255, 255, 255));
        lblDataSaida.setText("DATA SAIDA:");
        getContentPane().add(lblDataSaida, new AbsoluteConstraints(10, 260, -1, 30));

        lblObservacao.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblObservacao.setForeground(new Color(255, 255, 255));
        lblObservacao.setText("OBSERVAÇÃO:");
        getContentPane().add(lblObservacao, new AbsoluteConstraints(550, 100, -1, 30));

        btnPesquisar.setBackground(new Color(30, 129, 176));
        btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnPesquisar.setForeground(new Color(255, 255, 255));
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.addActionListener(_ -> {});
        getContentPane().add(btnPesquisar, new AbsoluteConstraints(900, 280, 110, 40));

        btnEditar.setBackground(new Color(30, 129, 176));
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnEditar.setForeground(new Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(this::btnEditarActionPerformed);
        getContentPane().add(btnEditar, new AbsoluteConstraints(1020, 280, 110, 40));

        btnExcluir.setBackground(new Color(30, 129, 176));
        btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnExcluir.setForeground(new Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);
        getContentPane().add(btnExcluir, new AbsoluteConstraints(1020, 330, 110, 40));

        btnVoltar.setBackground(new Color(30, 129, 176));
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnVoltar.setForeground(new Color(255, 255, 255));
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        getContentPane().add(btnVoltar, new AbsoluteConstraints(900, 330, 110, 40));

        btnNovo.setBackground(new Color(30, 129, 176));
        btnNovo.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNovo.setForeground(new Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(this::btnNovoActionPerformed);
        getContentPane().add(btnNovo, new AbsoluteConstraints(1140, 280, 110, 40));

        cbxTipoEquip.setFont(new Font("Tahoma", Font.BOLD, 20));
        cbxTipoEquip.addItemListener(this::txtTipoEquipItemStateChanged);
        getContentPane().add(cbxTipoEquip, new AbsoluteConstraints(160, 100, 320, 30));

        btnEmprestar.setBackground(new Color(30, 129, 176));
        btnEmprestar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnEmprestar.setForeground(new Color(255, 255, 255));
        btnEmprestar.setText("EMPRESTAR");
        btnEmprestar.addActionListener(this::btnEmprestarActionPerformed);
        getContentPane().add(btnEmprestar, new AbsoluteConstraints(1140, 330, 110, 40));

        lblTombo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTombo.setForeground(new Color(255, 255, 255));
        lblTombo.setText("TOMBO:");
        getContentPane().add(lblTombo, new AbsoluteConstraints(550, 220, -1, 30));

        cbxTombo.setFont(new Font("Tahoma", Font.BOLD, 20));
        cbxTombo.addItemListener(_ -> {});
        getContentPane().add(cbxTombo, new AbsoluteConstraints(650, 220, 170, 30));

        lblSerie.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblSerie.setForeground(new Color(255, 255, 255));
        lblSerie.setText("SERIE:");
        getContentPane().add(lblSerie, new AbsoluteConstraints(560, 260, -1, 30));

        cbxSerie.setFont(new Font("Tahoma", Font.BOLD, 20));
        getContentPane().add(cbxSerie, new AbsoluteConstraints(650, 260, 170, 30));

        txtObservacao.setColumns(20);
        txtObservacao.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtObservacao.setRows(5);
        pnl2.setViewportView(txtObservacao);

        getContentPane().add(pnl2, new AbsoluteConstraints(550, 130, 490, 80));

        txtId.setBackground(new Color(60, 63, 65));
        txtId.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtId.setEnabled(false);
        getContentPane().add(txtId, new AbsoluteConstraints(50, 20, 100, -1));

        // noinspection DataFlowIssue
        lblfundo.setIcon(new ImageIcon(getClass().getResource("/view/imagens/PARTE INTERNA2.png")));
        getContentPane().add(lblfundo, new AbsoluteConstraints(0, 0, 1250, 650));

        pack();
    }

    private void btnEmprestarActionPerformed(ActionEvent evt) {
        executarConfiguracaoInicial();
    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        try {
            this.dispose();

            TelaPrincipal telaprincip = new TelaPrincipal();
            telaprincip.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error ao chamar a tela principal!" + ex);
        }
    }

    private void btnExcluirActionPerformed(ActionEvent evt) {
        executarConfiguracaoInicial();
    }

    private void btnEditarActionPerformed(ActionEvent evt) {
        executarConfiguracaoInicial();
    }

    private void btnNovoActionPerformed(ActionEvent evt) {
        desbloquearCampos();
    }

    private void jTabelaCadEmprestimoMouseClicked(MouseEvent evt) {
        obterModelo();
    }

    private void JButtonNomeActionPerformed(ActionEvent evt) {
        this.dispose();

        TelaCadastroPessoa telacadnome = new TelaCadastroPessoa();
        telacadnome.setVisible(true);
    }

    @SuppressWarnings("DataFlowIssue")
    private void txtTipoEquipItemStateChanged(ItemEvent evt) {
        String tipoequipamentonome = cbxTipoEquip.getSelectedItem().toString();

        if (!cbxTipoEquip.getSelectedItem().equals(tipoequipamentonome)) {
            controller.atualizarComboBoxEquipamento(tipoequipamentonome);
            String equip = cbxEquipamento.getSelectedItem().toString();

            if (cbxEquipamento.getSelectedItem().equals(equip)) {
                controller.atualizarComboBoxTombo(equip);
                controller.atualizarComboBoxSerie(equip);
            }
        }
    }

    public void executarConfiguracaoInicial() {
        tblEmprestimo
            .getTableHeader()
            .setReorderingAllowed(false);

        controller.atualizarComboBoxUnidade();
        controller.atualizarComboBoxTipoEquipamento();
        controller.atualizarComboBoxEquipamento();
        controller.atualizarComboBoxDestino();
        controller.atualizarComboBoxNome();
        controller.atualizarComboBoxTombo();
        controller.atualizarComboBoxSerie();

        tblEmprestimo.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblEmprestimo.getColumnModel().getColumn(1).setPreferredWidth(88);
        tblEmprestimo.getColumnModel().getColumn(2).setPreferredWidth(102);
        tblEmprestimo.getColumnModel().getColumn(3).setPreferredWidth(102);
        tblEmprestimo.getColumnModel().getColumn(4).setPreferredWidth(87);
        tblEmprestimo.getColumnModel().getColumn(5).setPreferredWidth(160);
        tblEmprestimo.getColumnModel().getColumn(6).setPreferredWidth(110);
        tblEmprestimo.getColumnModel().getColumn(7).setPreferredWidth(110);
        tblEmprestimo.getColumnModel().getColumn(8).setPreferredWidth(105);
        tblEmprestimo.getColumnModel().getColumn(9).setPreferredWidth(125);
        tblEmprestimo.getColumnModel().getColumn(10).setPreferredWidth(160);
        tblEmprestimo.getColumnModel().getColumn(11).setPreferredWidth(90);
        tblEmprestimo.getColumnModel().getColumn(12).setPreferredWidth(90);
    }
}
