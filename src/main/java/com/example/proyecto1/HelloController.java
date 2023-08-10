package com.example.proyecto1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Button Button0;

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    private Button Button7;

    @FXML
    private Button Button8;

    @FXML
    private Button Button9;

    @FXML
    private Button ButtonAns;

    @FXML
    private Button ButtonClean;

    @FXML
    private Button ButtonDelete;

    @FXML
    private Button ButtonDivision;

    @FXML
    private Button ButtonIgual;

    @FXML
    private Button ButtonMultiplicacion;

    @FXML
    private Button ButtonPorcentaje;

    @FXML
    private Button ButtonResta;

    @FXML
    private Button ButtonSuma;

    @FXML
    private TextField textfieldnumeros;

    @FXML
    private TextArea textarearesultadohistorial;

    private Boolean operationOn = true;
    private double lastoperation = 0;

    @FXML
    void addValue(ActionEvent event) {
   textfieldnumeros.setText(textfieldnumeros.getText()+((Button)event.getSource()).getText());
   operationOn= true;
    }
    @FXML
    void addOperacion(ActionEvent event) {
        if(operationOn){
            textfieldnumeros.setText(textfieldnumeros.getText()+((Button)event.getSource()).getText());
            operationOn = false;
        }

    }

    public void cleanScreen(){
  textfieldnumeros.setText("");
  operationOn = true;
}
public void deleteValue(){
  if(!(textfieldnumeros.getText().length() == 0)){
      textfieldnumeros.setText(textfieldnumeros.getText().substring(0,textfieldnumeros.getText().length()-1));
    }

}
public void makeOperation(){
        String operation5= textfieldnumeros.getText();
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByname(shortName,"js");
        try{
            object operation = engine.eval (textfieldnumeros.getText().replaceAll ("X", "*"));
            textfieldnumeros.setText(""+operation);
            textarearesultadohistorial.setText(operation5 + "=" + textfieldnumeros.getText()+ "/n" + textarearesultadohistorial.getText());
            lastoperation = Double.parseDouble(textfieldnumeros.getText());
        }catch (ScriptException|ParserException e) {
            textfieldnumeros.setText("");

        }

}
public void getLastResultado(){
if (!(lastoperation==0)){
    textfieldnumeros.setText(textfieldnumeros.getText()+ lastoperation);
    }
}
}