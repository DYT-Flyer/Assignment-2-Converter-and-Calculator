/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Arik
 */
public class Calculator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //creates file
        File calculations = new File("calculations.txt");
        //checks for file, if does not exists, creates a new one
        if(!calculations.exists()){
            calculations.createNewFile();
        }
        PrintWriter print = new PrintWriter(calculations);
        BufferedWriter bw = new BufferedWriter(print);
        //clears file
        bw.write("");
        //launch application
        launch(args);
        
        bw.close();
        print.close();
        
    }
    
}
