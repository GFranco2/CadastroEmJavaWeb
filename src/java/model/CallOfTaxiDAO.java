/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Barriolo
 */
public class CallOfTaxiDAO {
    private Connection conexao; 
     private PreparedStatement preparar; 
     private ResultSet rs;
     
     public CallOfTaxiDAO(){
         conexao = new Conexao().getConexao();
     }
    

     public void Adicionar(CallOfTaxi usuario){
         String sql = "insert into usuario"+
                 "(nome,email,login,senha,confSenha,dddCelular,celular,dddTelefone,telefone,estado,cidade,bairro,logradouro,complemento)"+
                 "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         try{
             preparar = conexao.prepareStatement(sql);
             preparar.setString(1, usuario.getNome());
             preparar.setString(2, usuario.getEmail());
             preparar.setString(3, usuario.getLogin());
             preparar.setString(4, usuario.getSenha());
             preparar.setString(5, usuario.getConfSenha());
             preparar.setInt(6, usuario.getDddCelular());   
             preparar.setInt(7, usuario.getCelular());
             preparar.setInt(8, usuario.getDddTelefone());
             preparar.setInt(9, usuario.getTelefone());
             preparar.setString(10, usuario.getEstado());
             preparar.setString(11, usuario.getCidade());
             preparar.setString(12, usuario.getBairro());
             preparar.setString(13, usuario.getLogradouro());
             preparar.setString(14, usuario.getComplemento());
             preparar.execute();
             preparar.close();
         }catch(SQLException e){
             e.printStackTrace();
         }catch(NullPointerException e){
             e.printStackTrace();
         }
     }

     public void alterar(CallOfTaxi usuario){
         String sql = "update usuario set"
                 +"nome = ?"
                 +"email = ?"
                 +"login = ?"
                 +"senha = ?"
                 +"confSenha = ?"
                 +"dddCelular = ?"
                 +"celular = ?"
                 +"dddTelefone = ?"
                 +"telefone = ?"
                 +"estado = ?"
                 +"cidade = ?"
                 +"bairro = ?"
                 +"logradouro = ?"
                 +"complemento = ?";
        try {
            preparar = conexao.prepareStatement(sql);
            
            preparar.setString(1, usuario.getNome());
            preparar.setString(2, usuario.getEmail());
            preparar.setString(3, usuario.getLogin());
            preparar.setString(4, usuario.getSenha());
            preparar.setString(5, usuario.getConfSenha());
            preparar.setInt(6, usuario.getDddCelular());
            preparar.setInt(7, usuario.getDddTelefone());
            preparar.setInt(8, usuario.getCelular());
            preparar.setInt(9, usuario.getTelefone());
            preparar.setString(10, usuario.getEstado());
            preparar.setString(11, usuario.getCidade());
            preparar.setString(12, usuario.getBairro());
            preparar.setString(13, usuario.getLogradouro());
            preparar.setString(14, usuario.getComplemento());
            preparar.execute();
            preparar.close();
        } catch (SQLException ex) {
            Logger.getLogger(CallOfTaxiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void excluir(CallOfTaxi usuario){
         String sql = "dele from usuario"
                 +"where login =?";
         
        try {
            preparar = conexao.prepareStatement(sql);
            
            preparar.setString(3, usuario.getLogin());
            preparar.execute();
            preparar.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CallOfTaxiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
   public DefaultTableModel criarTabela() throws SQLException{
       DefaultTableModel dtm = new DefaultTableModel(){
          public boolean isCellEditable(int row, int column){
           return false;   
          }
           
       };
       String sql ="select nome,email,login,senha,confSenha,dddCelular,celular,dddTelefone,telefone,estado,cidade,bairro,logradouro,complemento from usuario ";
       preparar = conexao.prepareStatement(sql);
       rs = preparar.executeQuery();
       dtm.addColumn("nome");
       dtm.addColumn("email");
       dtm.addColumn("login");
       dtm.addColumn("senha");
       dtm.addColumn("confSenha");
       dtm.addColumn("dddCelular");
       dtm.addColumn("celular");
       dtm.addColumn("dddTelefone");
       dtm.addColumn("telefone");
       dtm.addColumn("estado");
       dtm.addColumn("cidade");
       dtm.addColumn("bairro");
       dtm.addColumn("logradouro");
       dtm.addColumn("complemento");
       
       String tituloColunas[] = {"nome","email","login","senha",
           "confSenha","dddCelular",
           "celular","dddTelefone","telefone","estado","cidade","bairro",
           "logradouro","complemento"
       };
       dtm.addRow(tituloColunas);
       
       while (rs.next()) {
           dtm.addRow(new String[]{
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("confSenha"),
                        rs.getString("dddCelular"),
                        rs.getString("celular"),
                        rs.getString("dddTelefone"),
                        rs.getString("telefone"),
                        rs.getString("estado"),
                        rs.getString("cidade"),
                        rs.getString("bairro"),
                        rs.getString("logradouro"),
                        rs.getString("complemento")
                        
           });          
       }
        return dtm;
   }     

    public List<CallOfTaxi> getLista(){
        try{
            
            List<CallOfTaxi> usuarios = new ArrayList<CallOfTaxi>();
             preparar = this.conexao.prepareStatement("select * from usuario");
             rs = preparar.executeQuery();

             while (rs.next()) {
                 // criando o objeto ComputadorRede
                CallOfTaxi usuario = new CallOfTaxi();
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setConfSenha(rs.getString("confSenha"));
                usuario.setDddCelular(rs.getInt("dddCelular"));
                usuario.setCelular(rs.getInt("celular"));
                usuario.setDddTelefone(rs.getInt("dddTelefone"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setLogradouro(rs.getString("logradouro"));
                usuario.setComplemento(rs.getString("complemento"));
                usuarios.add(usuario);
             }
             rs.close();
             preparar.close();
             return usuarios;
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
        }
    
            public void buscar (CallOfTaxi usuario, String valor){
                String sql="select * from usuario where login ='"+valor+"'";
                
        try {
            preparar =this.conexao.prepareStatement(sql);
            
            rs = preparar.executeQuery();
            rs.next();
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setConfSenha(rs.getString("confSenha"));
            usuario.setDddCelular(rs.getInt("dddCelular"));
            usuario.setCelular(rs.getInt("celular"));
            usuario.setDddTelefone(rs.getInt("dddTelefone"));
            usuario.setTelefone(rs.getInt("telefone"));
            usuario.setEstado(rs.getString("estado"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setBairro(rs.getString("bairro"));
            usuario.setLogradouro(rs.getString("logradouro"));
            usuario.setComplemento(rs.getString("complemento"));
            rs.close();
            preparar.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CallOfTaxiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
            }
    }
    
   

