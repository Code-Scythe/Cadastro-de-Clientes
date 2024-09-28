package formularios;

import dao.ClienteDao;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClienteFormulario extends JDialog {
    private JPanel contentPane;
    private JTextField cCodigo;
    private JTextField cNome;
    private JTextField cLimite;
    private JButton bntSalvar;
    private JButton bntRemover;
    private JTable tabela;
    private JComboBox<String> bTipoPessoa;
    private JFormattedTextField fCpfCnpj;
    private JButton bntCancelar;
    private JButton bntEditar;
    private boolean editando = false;
    private Cliente clienteSelecionado;

    public ClienteFormulario() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Cadastro de clientes");

        try {
            MaskFormatter maskFormatterCPF = new MaskFormatter("###.###.###-##");
            fCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(maskFormatterCPF));

            bTipoPessoa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String tipoPessoaSelecionado = (String) bTipoPessoa.getSelectedItem();
                    try {
                        if (tipoPessoaSelecionado.equals("Jurídica")) {
                            MaskFormatter maskFormatterCNPJ = new MaskFormatter("##.###.###/####-##");
                            fCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(maskFormatterCNPJ));
                        } else {
                            MaskFormatter maskFormatterCPF = new MaskFormatter("###.###.###-##");
                            fCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(maskFormatterCPF));
                        }
                        fCpfCnpj.setValue(null);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        carregarTabela();
        atualizarCodigo();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        bntCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
                editando = false;
                atualizarCodigo();
            }
        });

        bntSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarOuAtualizarCliente();
            }
        });

        bntRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    int idCliente = (int) tabela.getValueAt(linhaSelecionada, 0);
                    try {
                        ClienteDao.excluir(idCliente);
                        ((DefaultTableModel) tabela.getModel()).removeRow(linhaSelecionada);
                        JOptionPane.showMessageDialog(null, "Removido com sucesso!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        bntEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    int idCliente = (int) tabela.getValueAt(linhaSelecionada, 0);
                    try {
                        clienteSelecionado = ClienteDao.buscarPorId(idCliente);
                        if (clienteSelecionado != null) {
                            carregarClienteParaEdicao(clienteSelecionado);
                            editando = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao buscar cliente. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente para editar.", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void carregarTabela() {
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel.addColumn("Código");
        defaultTableModel.addColumn("Nome");
        defaultTableModel.addColumn("Tipo de pessoa");
        defaultTableModel.addColumn("CPF/CNPJ");
        defaultTableModel.addColumn("Limite de crédito");

        try {
            List<Cliente> clientes = ClienteDao.listar();
            for (Cliente cliente : clientes) {
                defaultTableModel.addRow(new Object[]{
                        cliente.getID(),
                        cliente.getNOME(),
                        cliente.getTIPO_PESSOA(),
                        cliente.getCPF_CNPJ(),
                        cliente.getLIMITE_CREDITO()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        tabela.setModel(defaultTableModel);
    }

    private void atualizarCodigo() {
        try {
            int ultimoCodigo = ClienteDao.obterUltimoCodigo();
            int codigo = (ultimoCodigo == 0) ? 1 : ultimoCodigo + 1;
            cCodigo.setText(String.valueOf(codigo));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            cCodigo.setText("1");
        }
    }

    private void carregarClienteParaEdicao(Cliente cliente) {
        cCodigo.setText(String.valueOf(cliente.getID()));
        cNome.setText(cliente.getNOME());
        cLimite.setText(String.valueOf(cliente.getLIMITE_CREDITO()));

        if (cliente.getTIPO_PESSOA().equals("J")) {
            bTipoPessoa.setSelectedItem("Jurídica");
            try {
                MaskFormatter maskFormatterCNPJ = new MaskFormatter("##.###.###/####-##");
                fCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(maskFormatterCNPJ));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            bTipoPessoa.setSelectedItem("Física");
            try {
                MaskFormatter maskFormatterCPF = new MaskFormatter("###.###.###-##");
                fCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(maskFormatterCPF));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        fCpfCnpj.setValue(cliente.getCPF_CNPJ());
    }

    private void salvarOuAtualizarCliente() {
        String tipoPessoaSelecionado = (String) bTipoPessoa.getSelectedItem();
        String tipoPessoa = tipoPessoaSelecionado.equals("Jurídica") ? "J" : "F";
        String cpfCnpj = fCpfCnpj.getText();
        String nome = cNome.getText();
        double limiteCredito = Double.parseDouble(cLimite.getText());
        int id = Integer.parseInt(cCodigo.getText());

        Cliente cliente = new Cliente(id, tipoPessoa, cpfCnpj, nome, limiteCredito);
        try {
            if (editando) {
                cliente.setID(clienteSelecionado.getID());
                ClienteDao.atualizar(cliente);
                editando = false;
            } else {
                ClienteDao.salvar(cliente);
                atualizarCodigo();
            }
            carregarTabela();

            limparCampos();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        fCpfCnpj.setValue(null);
        cNome.setText("");
        cLimite.setText("");
        atualizarCodigo();
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClienteFormulario dialog = new ClienteFormulario();
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }
}
