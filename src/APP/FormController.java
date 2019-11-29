/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import DAO.UsuarioDao;
import MODEL.Usuario;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Ariel
 */
public class FormController implements Initializable {
    
     @FXML
    private Button inserir;

    @FXML
    private Label label;

    @FXML
    private TextField curso;

    @FXML
    private TextField nome;

    @FXML
    private Label label1;

    @FXML
    void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       inserir.setOnMouseClicked((MouseEvent e) -> {
           cadastrar();
       });
    }
    
    private void cadastrar(){
//        Usuario u = new Usuario();
//        UsuarioDao dao = new UsuarioDao();
//        
//        u.setNome(nome.getText());
//        u.setCurso(curso.getText());
//        
//        //NAO CONSIGO DEIXAR SOMENTE O DAO.CREATE
//        try {
//            dao.create(u);
//        } catch (SQLException ex) {
//            System.out.println("Erro aki");
//        }
        String alunoName = nome.getText(), 
               alunoCurso = curso.getText();
        
        Usuario u = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        
        u.setNome(alunoName);
        u.setCurso(alunoCurso);
         try {
             dao.create(u);
             Alert al = new Alert(AlertType.CONFIRMATION);
             al.setHeaderText("Aluno Cadastrado");
         } catch (SQLException ex) {
             Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
