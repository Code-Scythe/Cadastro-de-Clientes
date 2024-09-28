package dao;

import conexao.Conexao;
import modelos.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    public static int salvar(Cliente cliente) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = Conexao.getConexao().prepareStatement("INSERT INTO CLIENTES (TIPO_PESSOA, CPF_CNPJ, NOME, LIMITE_CREDITO) VALUES (?, ?, ?, ?)");
        ps.setString(1, cliente.getTIPO_PESSOA());
        ps.setString(2, cliente.getCPF_CNPJ());
        ps.setString(3, cliente.getNOME());
        ps.setDouble(4, cliente.getLIMITE_CREDITO());
        return ps.executeUpdate();
    }

    public static int atualizar(Cliente cliente) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = Conexao.getConexao().prepareStatement("UPDATE CLIENTES SET TIPO_PESSOA = ?, CPF_CNPJ = ?, NOME = ?, LIMITE_CREDITO = ? WHERE ID = ?");
        ps.setString(1, cliente.getTIPO_PESSOA());
        ps.setString(2, cliente.getCPF_CNPJ());
        ps.setString(3, cliente.getNOME());
        ps.setDouble(4, cliente.getLIMITE_CREDITO());
        ps.setInt(5, cliente.getID());
        return ps.executeUpdate();
    }

    public static int excluir(int ID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = Conexao.getConexao().prepareStatement("DELETE FROM CLIENTES WHERE ID = ?");
        ps.setInt(1, ID);
        return ps.executeUpdate();
    }

    public static List<Cliente> listar() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = Conexao.getConexao().prepareStatement("SELECT * FROM CLIENTES");
        ResultSet rs = ps.executeQuery();
        List<Cliente> clientes = new ArrayList<>();
        while (rs.next()) {
            Cliente cliente = new Cliente(rs.getInt("ID"), rs.getString("TIPO_PESSOA"), rs.getString("CPF_CNPJ"), rs.getString("NOME"), rs.getDouble("LIMITE_CREDITO"));
            clientes.add(cliente);
        }
        return clientes;
    }

    public static int obterUltimoCodigo() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = Conexao.getConexao().prepareStatement("SELECT MAX(ID) FROM CLIENTES");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public static Cliente buscarPorId(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = Conexao.getConexao().prepareStatement("SELECT * FROM CLIENTES WHERE ID = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Cliente(rs.getInt("ID"), rs.getString("TIPO_PESSOA"), rs.getString("CPF_CNPJ"), rs.getString("NOME"), rs.getDouble("LIMITE_CREDITO"));
        }
        return null;
    }
}
