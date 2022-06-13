/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODELO.Usuario;
import MODELO.UsuarioPK;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Fortunato José
 */
public class UsuarioController extends CRUDController {

    public UsuarioController() {
        super("usuario", "IdUsuario");
        super.setInserirQuery(String.format("INSERT INTO %s (Nome, Sobrenome, Email, Senha,DataNascimento, Nivel) values (?,?,?,?,?,?)", this.tabela));
        super.setAtualizarQuery(String.format("UPDATE %s SET Nome = ?, Sobrenome = ?, Email = ?,"
                + " Senha = ?, DataNascimento = ?, Nivel = ? WHERE IdUsuario = ?", this.tabela));
        super.setDeletarQuery(String.format("DELETE FROM %s WHERE %s = ?", this.tabela, this.idTabela));
        super.setSelecionarQuery(String.format("SELECT * FROM %s", this.tabela));
    }

    @Override
    protected void setValoresQuery(PreparedStatement stmt, Object object, boolean update) throws SQLException {
        Usuario user = (Usuario) object;
        if (update) {
            stmt.setString(1, user.getUsuarioPK().getNome());
            stmt.setString(2, user.getSobrenome());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getSenha());
            stmt.setString(5, user.getDataNascimento().toString());
            stmt.setString(6, user.getNivel());
            stmt.setInt(7, user.getUsuarioPK().getIdUsuario());
        } else {
            stmt.setString(1, user.getUsuarioPK().getNome());
            stmt.setString(2, user.getSobrenome());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getSenha());
            stmt.setString(5, user.getDataNascimento().toString());
            stmt.setString(7, user.getNivel());
        }
    }

    @Override
    protected ArrayList<Usuario> criarObjecto(ResultSet rs, boolean all) throws SQLException {
        ArrayList<Usuario> ulista = new ArrayList<>();
        if (all) {
            while (rs.next()) {
                Usuario us = new Usuario();
                UsuarioPK usuarioPK = new UsuarioPK();
                us.setDataNascimento(rs.getString("DataNascimento"));
                us.setEmail(rs.getString("Email"));
                us.setNivel(rs.getString("Nivel"));
                us.setSenha(rs.getString("Senha"));
                us.setSobrenome(rs.getString("Sobrenome"));
                usuarioPK.setNome(rs.getString("Nome"));
                usuarioPK.setIdUsuario(rs.getInt("IdUsuario"));
                us.setUsuarioPK(usuarioPK);
                ulista.add(us);
            }
            return ulista;
        } else {
            rs.next();
            Usuario us = new Usuario();
            UsuarioPK usuarioPK = new UsuarioPK();
            us.setDataNascimento(rs.getString("DataNascimento"));
            us.setEmail(rs.getString("Email"));
            us.setNivel(rs.getString("Nivel"));
            us.setSenha(rs.getString("Senha"));
            us.setSobrenome(rs.getString("Sobrenome"));
            usuarioPK.setNome(rs.getString("Nome"));
            usuarioPK.setIdUsuario(rs.getInt("IdUsuario"));
            us.setUsuarioPK(usuarioPK);
            ulista.add(us);
            return ulista;
        }
    }

    @Override
    protected Object convertObjecto(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setValoresQueryPersonalizado(PreparedStatement stmt, Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ArrayList criarObjectoPersonalizado(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Inserir(Object object) {
        Usuario user = (Usuario) object;
        super.Inserir(user); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Actualizar(Object object) {
        Usuario user = (Usuario) object;
        super.Actualizar(user); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(int id) {
        super.Delete(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> Find(int id) {
        return super.Find(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> findAll() {
        return (ArrayList<Usuario>) super.getObjectos(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static void main(String[] args) {
        UsuarioController uController = new UsuarioController();
        Usuario user = new Usuario();
        UsuarioPK userPK = new UsuarioPK();
        
        user.setDataNascimento("1999-07-19");
        user.setEmail("komba@evento.co");
        user.setNivel("Administrador");
        user.setSenha("k22k");
        user.setSobrenome("Komba");
        userPK.setNome("Josefino");
        userPK.setIdUsuario(6);
        user.setUsuarioPK(userPK);
        
        uController.Actualizar(user);
        System.out.println("Actualizar com sucesso");
    }

    

}
