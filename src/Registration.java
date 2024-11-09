import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class Registration implements Initializable{
    @FXML
    private Button cancel_button;

    @FXML
    private TextField id_number;

    @FXML
    private TextField name;

    @FXML
    private TextField phone_number;

    @FXML
    private TextField reg_number;

    @FXML
    private TextField serial_number;

    @FXML
    private Button submit_button;

    @FXML
    private Button upload_button;
    @FXML
    private ImageView photo;


    private FileChooser fileChooser;
    private File filePath;

    public void Register(ActionEvent event) {
        String Name = this.name.getText();
        String RegistrationNumber = this.reg_number.getText();
        String PhoneNumber = this.phone_number.getText();
        String SerialNumber = this.serial_number.getText();
        String IdNumber = this.id_number.getText();
        
        if (event.getSource() == this.submit_button) {
            System.out.println("Name entered is: " + Name);
            System.out.println("Rgistartion number provided is: " + reg_number);
        }

        
    }

    public void uploadImageButtonPushed(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        
        //set to user's directory or go to default C drive if cannot access
        String userDirectoryString = System.getProperty("user.home");

        File userDirectroy = new File(userDirectoryString);

        if(userDirectroy.canRead())
            userDirectroy = new File("C:/");
        fileChooser.setInitialDirectory(userDirectroy);

        filePath = fileChooser.showOpenDialog(stage);

        if (filePath != null) {
            Image userImage = new Image(filePath.toURI().toString());
            photo.setImage(userImage);

        }
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    


}
