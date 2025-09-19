package controller;

import lombok.RequiredArgsConstructor;
import model.DAO.EmprestimoDAO;
import model.DAO.EquipamentoDAO;
import model.DAO.NomeDAO;
import model.DAO.TipoEquipamentoDAO;
import model.DAO.UnidadeDAO;
import model.Emprestimo;
import model.Equipamento;
import model.Nome;
import model.TipoEquipamento;
import model.Unidade;
import view.TelaCadastroEmprestimo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor
public class CadastroEmprestimoController {

    private final TelaCadastroEmprestimo view;

    /**
     * Não sei o que isso deveria fazer, porque isso não é usado.
     */
    public void atualizarTabelaEmprestimo() {
        DefaultTableModel modelo = (DefaultTableModel) view
            .getTblEmprestimo()
            .getModel();

        modelo.setRowCount(0);

        try (Connection conexao = new Conexao().Conectar()) {
            EmprestimoDAO dao = new EmprestimoDAO(conexao);
            List<Emprestimo> emprestimos = dao.selecioneAllEmprestimos();

            for (Emprestimo emprestimo : emprestimos) {
                // Armazena os dados das colunas
                Object[] colunas = new Object[12];
                colunas[0] = emprestimo.getId();
                colunas[1] = emprestimo.getUnidade().getUnidadenome();
                colunas[2] = emprestimo.getTipoequip().getTipoequipamento();
                colunas[3] = emprestimo.getEquipamento().getModelo();
                colunas[4] = emprestimo.getDestino().getUnidadenome();
                colunas[5] = emprestimo.getDataSaida();
                colunas[6] = emprestimo.getDataDevolucao();
                colunas[7] = emprestimo.getStatus();
                colunas[8] = emprestimo.getTipo();
                colunas[9] = emprestimo.getObservacao();
                colunas[10] = emprestimo.getTombo();
                colunas[11] = emprestimo.getSerie();

                modelo.addRow(colunas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao preencher tabela!" + e);
            throw new RuntimeException(e);
        }
    }

    public void atualizarComboBoxUnidade() {
        try (Connection conexao = new Conexao().Conectar()) {
            UnidadeDAO dao = new UnidadeDAO(conexao);
            List<Unidade> unidades = dao.selecioneAllUnidade();

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxUnidade()
                .getModel();

            modelo.removeAllElements();

            for (Unidade unidade : unidades) {
                modelo.addElement(unidade.getUnidadenome());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error a preencher combobox unidade:" + e);
            throw new RuntimeException(e);
        }
    }

    public void atualizarComboBoxTipoEquipamento() {
        try (Connection conexao = new Conexao().Conectar()) {
            TipoEquipamentoDAO dao = new TipoEquipamentoDAO(conexao);
            List<TipoEquipamento> tipoEquipamentos = dao.selecioneAllTipoEquipamento();

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxTipoEquip()
                .getModel();

            modelo.removeAllElements();

            for (TipoEquipamento tipoEquipamento : tipoEquipamentos) {
                modelo.addElement(tipoEquipamento.getTipoequipamento());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao preencher o combobox:" + e);
            throw new RuntimeException(e);
        }
    }

    public void atualizarComboBoxEquipamento() {
        try (Connection conexao = new Conexao().Conectar()) {
            EquipamentoDAO dao = new EquipamentoDAO(conexao);
            List<Equipamento> equipamentos = dao.selecioneAllEquipamento();

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxEquipamento()
                .getModel();

            modelo.removeAllElements();

            for (Equipamento equipamento : equipamentos) {
                modelo.addElement(equipamento.EquiptoString());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox equipamento!" + e);
            throw new RuntimeException(e);
        }
    }

    public void atualizarComboBoxDestino() {
        try (Connection conexao = new Conexao().Conectar()) {
            UnidadeDAO dao = new UnidadeDAO(conexao);
            List<Unidade> unidades = dao.selecioneAllUnidade();

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxDestino()
                .getModel();

            modelo.removeAllElements();

            for (Unidade unidade : unidades) {
                modelo.addElement(unidade.getUnidadenome());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error a preencher combobox destino:" + e);
            throw new RuntimeException(e);
        }
    }

    public void atualizarComboBoxNome() {
        try (Connection conexao = new Conexao().Conectar()) {
            NomeDAO dao = new NomeDAO(conexao);
            List<Nome> nomes = dao.selecioneAllNome();

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxNome()
                .getModel();

            modelo.removeAllElements();

            for (Nome nome : nomes) {
                modelo.addElement(nome.getNomepessoa());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox nome!" + e);
            throw new RuntimeException(e);
        }
    }

    public void atualizarComboBoxTombo() {
        try (Connection conexao = new Conexao().Conectar()) {
            EquipamentoDAO dao = new EquipamentoDAO(conexao);
            List<Equipamento> equipamentos = dao.selecioneAllEquipamento();

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxTombo()
                .getModel();

            modelo.removeAllElements();

            for (Equipamento equipamento : equipamentos) {
                modelo.addElement(equipamento.getTombo());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox tombo por equipamento!" + e);
            throw new RuntimeException(e);
        }
    }

    public void atualizarComboBoxEquipamento(String tipoEquipamento) {
        try (Connection conexao = new Conexao().Conectar()) {
            EquipamentoDAO dao = new EquipamentoDAO(conexao);
            List<Equipamento> equipamentos = dao.selecionarAllModeloPorTipoEquip(tipoEquipamento);

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxEquipamento()
                .getModel();

            modelo.removeAllElements();

            for (Equipamento equipamento : equipamentos) {
                modelo.addElement(equipamento.getEquipamento());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox equipamento por tipo equipamento!" + e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Não sei para que serve esse método.
     */
    public void atualizarComboBoxTombo(String equip) {
        try (Connection conexao = new Conexao().Conectar()) {
            EquipamentoDAO dao = new EquipamentoDAO(conexao);
            List<Equipamento> equipamentos = dao.selecioneAllEquipamentoTomboStringEquip(equip);

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxTombo()
                .getModel();

            modelo.removeAllElements();

            for (Equipamento equipamento : equipamentos) {
                modelo.addElement(equipamento.getTombo());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox tombo por equipamento!" + e);
            throw new RuntimeException(e);
        }
    }

    public void atualizarComboBoxSerie(String equip) {
        try (Connection conexao = new Conexao().Conectar()) {
            EquipamentoDAO dao = new EquipamentoDAO(conexao);
            List<Equipamento> equipamentos = dao.selecioneAllEquipamentoSerieStringEquip(equip);

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxSerie()
                .getModel();

            modelo.removeAllElements();

            for (Equipamento equipamento : equipamentos) {
                modelo.addElement(equipamento.getSerie());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox serie por equipamento!" + e);
            throw new RuntimeException(e);
        }
    }

    public void atualizarComboBoxSerie() {
        try (Connection conexao = new Conexao().Conectar()) {
            EquipamentoDAO dao = new EquipamentoDAO(conexao);
            List<Equipamento> equipamentos = dao.selecioneAllEquipamentoSerie();

            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) view
                .getCbxSerie()
                .getModel();

            modelo.removeAllElements();

            for (Equipamento equipamento : equipamentos) {
                modelo.addElement(equipamento.getSerie());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao preencher combobox serie por equipamento!" + e);
            throw new RuntimeException(e);
        }
    }
}
