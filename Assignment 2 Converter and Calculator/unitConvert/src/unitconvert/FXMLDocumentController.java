/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitconvert;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Arik
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label1;
    
    @FXML
    private Label label2;
    
    @FXML
    private Label label3;
    
    @FXML
    private Label label4;
    
    @FXML
    private Label label5;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private TextField txtNum1;
    
    @FXML
    private TextField txtNum2;
    
    @FXML
    private TextField txtNum3;
    
    @FXML
    private void handleButtonClearAction(ActionEvent event){
        //all clear
        txtNum1.setText("");
        txtNum2.setText("");
        txtNum3.setText("");
    }
    
    @FXML
    private void handleButtonConvertAction(ActionEvent event) {
        //temperature is selected
        if(rbTemp.isSelected()){
            //can't convert if all fields are filled
            if(!txtNum1.getText().isEmpty() && !txtNum2.getText().isEmpty()){
                return;
            }
            //checking for fahrenheit
            if(!txtNum1.getText().isEmpty()){
                //fahrenheit -> celsius
                double fahr = Double.parseDouble(txtNum1.getText());
                double cels = (fahr - 32.0)*(5.0/9.0);
                String conv = String.valueOf(cels);
                txtNum2.setText(conv);
                return;
            }
            //checking for celsius
            if(!txtNum2.getText().isEmpty()){
                //celsius -> fahrenheit
                double cels = Double.parseDouble(txtNum2.getText());
                double fahr = (cels*(9.0/5.0)) + 32.0;
                String conv = String.valueOf(fahr);
                txtNum1.setText(conv);
                return;
            }
        }
        //height is selected
        if(rbHeight.isSelected()){
            //can't convert if all fields are filled
            if((!txtNum1.getText().isEmpty() || !txtNum3.getText().isEmpty()) && !txtNum2.getText().isEmpty()){
                return;
            }
            
            //checking for feet and inches
            if(!txtNum1.getText().isEmpty() || !txtNum3.getText().isEmpty()){
                //filling in the blanks
                if(txtNum1.getText().isEmpty()){
                    txtNum1.setText("0");
                }
                
                if(txtNum3.getText().isEmpty()){
                    txtNum3.setText("0");
                }
                //inches -> feet, feet -> meters
                double feet = Double.parseDouble(txtNum1.getText()) + Double.parseDouble(txtNum3.getText())/12.0;
                double meters = feet*.3048;
                String conv = String.valueOf(meters);
                txtNum2.setText(conv);
                return;
                
            }
            
            //checking for meters
            if(!(txtNum2.getText().isEmpty())){
                //meters -> feet, feet -> inches
                double meters = Double.parseDouble(txtNum2.getText());
                double feet1 = meters/.3048;
                double feet2 = Math.floor(feet1);
                double inches = (feet1 - feet2)*12.0;
                String conv1 = String.valueOf(feet2);
                String conv2 = String.valueOf(inches);
                txtNum1.setText(conv1);
                txtNum3.setText(conv2);
                return;
            }
        }
        
        //weight is selected
        if(rbWeight.isSelected()){
            //can't convert if both are filled
            if((!txtNum1.getText().isEmpty() || !txtNum3.getText().isEmpty()) && !txtNum2.getText().isEmpty()){
                return;
            }
            
            //converting lbs and ozs to kg
            if(!txtNum1.getText().isEmpty() || !txtNum3.getText().isEmpty()){
                //filling in the blanks
                if(txtNum1.getText().isEmpty()){
                    txtNum1.setText("0");
                }
                
                if(txtNum3.getText().isEmpty()){
                    txtNum3.setText("0");
                }
                
                //ozs -> lbs, lbs -> to kg
                double lbs = Double.parseDouble(txtNum1.getText()) + Double.parseDouble(txtNum3.getText())/16.0;
                double kg = lbs*.45359237;
                String conv = String.valueOf(kg);
                txtNum2.setText(conv);
            }
            
            //converting kg to lbs and ozs
            if(!(txtNum2.getText().isEmpty())){
                //kg -> lbs, lbs -> ozs
                double kg = Double.parseDouble(txtNum2.getText());
                double lbs1 = kg/.45359237;
                double lbs2 = Math.floor(lbs1);
                double oz = (lbs1-lbs2)*16.0;
                String conv1 = String.valueOf(lbs2);
                String conv2 = String.valueOf(oz);
                txtNum1.setText(conv1);
                txtNum3.setText(conv2);
            }
        }
        
    }
    
    @FXML
    private RadioButton rbTemp;
    
    @FXML
    private RadioButton rbHeight;
    
    @FXML
    private RadioButton rbWeight;
    
    @FXML
    private void tempSelected(ActionEvent event) {
        
        //rearranging scene
        
        label5.setVisible(false);
        txtNum3.setVisible(false);
        
        txtNum1.setPrefWidth(342);
        txtNum1.setPrefHeight(25);
        txtNum1.setLayoutX(132);
        txtNum1.setLayoutY(91);
        
        txtNum2.setPrefWidth(342);
        txtNum2.setPrefHeight(25);
        txtNum2.setLayoutX(132);
        txtNum2.setLayoutY(150);
        
        txtNum3.setPrefWidth(150);
        txtNum3.setPrefHeight(25);
        txtNum3.setLayoutX(0);
        txtNum3.setLayoutY(416);
        
        label1.setLayoutX(42);
        label1.setLayoutY(95);
        
        label2.setLayoutX(42);
        label2.setLayoutY(154);
        
        label3.setLayoutX(475);
        label3.setLayoutY(95);
        
        label4.setLayoutX(475);
        label4.setLayoutY(154);
        
        label5.setLayoutX(0);
        label5.setLayoutY(0);
        
        label1.setText("Fahrenheit");
        label2.setText("Celsius");
        label3.setText("°F");
        label4.setText("°C");
        
        txtNum1.setText("");
        txtNum2.setText("");
        
        txtNum1.setPromptText("Ex: 64");
        txtNum2.setPromptText("Ex: 17.78");
    }
    
    @FXML
    private void heightSelected(ActionEvent event) {
        
        //rearranging scene
        
        label5.setVisible(true);
        txtNum3.setVisible(true);
        
        txtNum1.setPrefWidth(150);
        txtNum1.setPrefHeight(25);
        txtNum1.setLayoutX(132);
        txtNum1.setLayoutY(91);
        
        txtNum2.setPrefWidth(342);
        txtNum2.setPrefHeight(25);
        txtNum2.setLayoutX(132);
        txtNum2.setLayoutY(150);
        
        txtNum3.setPrefWidth(150);
        txtNum3.setPrefHeight(25);
        txtNum3.setLayoutX(323);
        txtNum3.setLayoutY(91);
        
        label1.setLayoutX(42);
        label1.setLayoutY(95);
        
        label2.setLayoutX(42);
        label2.setLayoutY(154);
        
        label3.setLayoutX(475);
        label3.setLayoutY(95);
        
        label4.setLayoutX(475);
        label4.setLayoutY(154);
        
        label5.setLayoutX(284);
        label5.setLayoutY(95);
        
        label1.setText("Feet");
        label2.setText("Meters");
        label3.setText("in");
        label4.setText("m");
        label5.setText("ft");
        
        txtNum1.setText("");
        txtNum2.setText("");
        txtNum3.setText("");
        
        txtNum1.setPromptText("Ex: 2");
        txtNum2.setPromptText("Ex: 0.762");
        txtNum3.setPromptText("Ex: 6");
    }
    
    @FXML
    private void weightSelected(ActionEvent event) {
        
        //rearranging scene
        
        label5.setVisible(true);
        txtNum3.setVisible(true);
        
        txtNum1.setPrefWidth(150);
        txtNum1.setPrefHeight(25);
        txtNum1.setLayoutX(132);
        txtNum1.setLayoutY(91);
        
        txtNum2.setPrefWidth(342);
        txtNum2.setPrefHeight(25);
        txtNum2.setLayoutX(132);
        txtNum2.setLayoutY(150);
        
        txtNum3.setPrefWidth(150);
        txtNum3.setPrefHeight(25);
        txtNum3.setLayoutX(323);
        txtNum3.setLayoutY(91);
        
        label1.setLayoutX(42);
        label1.setLayoutY(95);
        
        label2.setLayoutX(42);
        label2.setLayoutY(154);
        
        label3.setLayoutX(475);
        label3.setLayoutY(95);
        
        label4.setLayoutX(475);
        label4.setLayoutY(154);
        
        label5.setLayoutX(284);
        label5.setLayoutY(95);
        
        label1.setText("Lbs");
        label2.setText("Kg");
        label3.setText("oz");
        label4.setText("kg");
        label5.setText("lb");
        
        txtNum1.setText("");
        txtNum2.setText("");
        txtNum3.setText("");
        
        txtNum1.setPromptText("Ex: 20");
        txtNum2.setPromptText("Ex: 9.16");
        txtNum3.setPromptText("Ex: 3");
    }
    
    
    
}
