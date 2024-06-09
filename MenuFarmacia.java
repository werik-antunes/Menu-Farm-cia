package login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MenuFarmacia extends JFrame{
	public MenuFarmacia() {
        setTitle("Sistema de Farmácia");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Adiciona a barra de menu ao frame principal
        setJMenuBar(createMenuBar());
    }

    // Método para criar a barra de menu
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu cadastrosMenu = new JMenu("Cadastros");
        menuBar.add(cadastrosMenu);
        
        JMenuItem clientesItem = new JMenuItem("Clientes");
        cadastrosMenu.add(clientesItem);
        clientesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirFormulario("Cadastro de Clientes", new String[]{"Nome:", "Email:", "Telefone"});
            }
        });
        
        JMenuItem produtosItem = new JMenuItem("Produtos");
        cadastrosMenu.add(produtosItem);
        produtosItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirFormulario("Cadastro de Produtos", new String[]{"Nome do Produto:", "Preço:", "Quantidade"});
            }
        });

        JMenuItem fornecedoresItem = new JMenuItem("Fornecedores");
        cadastrosMenu.add(fornecedoresItem);
        fornecedoresItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirFormulario("Cadastro de Fornecedores", new String[]{"Nome do Fornecedor:", "Email:", "Telefone"});
            }
        });

        JMenuItem funcionariosItem = new JMenuItem("Funcionários");
        cadastrosMenu.add(funcionariosItem);
        funcionariosItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirFormulario("Cadastro de Funcionários", new String[]{"Nome do Funcionário:", "Cargo:", "Salário"});
            }
        });

        JMenuItem sairItem = new JMenuItem("Sair");
        sairItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(Box.createHorizontalGlue()); // Para alinhar o item "Sair" à direita
        menuBar.add(sairItem);

        return menuBar;
    }

    private void exibirFormulario(String titulo, String[] labels) {
        JFrame frame = new JFrame(titulo);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de cadastro

        // Adiciona a barra de menu à nova janela
        frame.setJMenuBar(createMenuBar());

        JPanel panel = new JPanel(new GridLayout(labels.length + 1, 2, 10, 10));
        JTextField[] textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            textFields[i] = new JTextField();
            panel.add(label);
            panel.add(textFields[i]);
        }

        JButton buttonSalvar = new JButton("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar a lógica para salvar os dados
                StringBuilder dados = new StringBuilder();
                for (int i = 0; i < labels.length; i++) {
                    dados.append(labels[i]).append(" ").append(textFields[i].getText()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, "Dados salvos com sucesso!\n" + dados.toString());
                frame.dispose(); // Fecha a janela de cadastro após salvar
            }
        });

        panel.add(buttonSalvar);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuFarmacia().setVisible(true);
            }
        });
    }
}
