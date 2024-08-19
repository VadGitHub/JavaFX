package org.example.tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {

    private char curSymbol = 'x';
    private char gameField[][] = new char[3][3];
    private boolean isGame = true;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void btnClick(ActionEvent event) {

        Button btn = (Button)event.getSource();

        if (!isGame || btn.getText() != "") return; // Game is over OR button was pressed

        Integer rowIndex = GridPane.getRowIndex(btn);
        rowIndex = rowIndex == null ? 0 : rowIndex;
        Integer colIndex = GridPane.getColumnIndex(btn);
        colIndex = colIndex == null ? 0 : colIndex;

        gameField[rowIndex][colIndex] = curSymbol;

        btn.setText(String.valueOf(curSymbol));

        if ((gameField[0][0] == gameField[0][1] && gameField[0][0] == gameField[0][2] && (gameField[0][0] == 'x' || gameField[0][0] == 'o')) ||
           (gameField[1][0] == gameField[1][1] && gameField[1][0] == gameField[1][2] && (gameField[1][0] == 'x' || gameField[1][0] == 'o')) ||
           (gameField[2][0] == gameField[2][1] && gameField[2][0] == gameField[2][2] && (gameField[2][0] == 'x' || gameField[2][0] == 'o')) ||

           (gameField[0][0] == gameField[1][0] && gameField[0][0] == gameField[2][0] && (gameField[0][0] == 'x' || gameField[0][0] == 'o')) ||
           (gameField[0][1] == gameField[1][1] && gameField[0][1] == gameField[2][1] && (gameField[0][1] == 'x' || gameField[0][1] == 'o')) ||
           (gameField[0][2] == gameField[1][2] && gameField[0][2] == gameField[2][2] && (gameField[0][2] == 'x' || gameField[0][2] == 'o')) ||

           (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2] && (gameField[0][0] == 'x' || gameField[0][0] == 'o')) ||
           (gameField[0][2] == gameField[1][1] && gameField[0][2] == gameField[2][0] && (gameField[0][2] == 'x' || gameField[0][2] == 'o'))
        )
        {
            isGame = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Game Over. Winner is '" + btn.getText() + "'", ButtonType.OK );
            alert.showAndWait();
        }
        curSymbol = (curSymbol == 'x') ? 'o' : 'x';


    }

    @FXML
    void initialize() {

    }

}
