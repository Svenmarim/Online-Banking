package Client.Controllers;

import Client.ClientMain;
import Client.IControllers;
import Client.ScreensController;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;

/**
 * InternetBankieren Created by Sven de Vries on 20-12-2017
 */
public class CreateBankController implements IControllers {
    private ScreensController myController;

    //FXML fields
    public TextField tbBankName;
    public TextField tbShortcut;

    public void createBank() {
        String name = tbBankName.getText();
        String shortcut = tbShortcut.getText();
        if (!name.equals("") && shortcut.length() == 4) {
            try {
                if (myController.getClient().createBank(name, shortcut)) {
                    myController.setScreen(ClientMain.screenManageBanksId);
                } else {
                    myController.showErrorMessage("Bank name or shortcut already excist.");
                }
            } catch (RemoteException e) {
                myController.showErrorMessage(e.getMessage());
            }
        } else {
            myController.showErrorMessage("Fields can not be empty and shortcut must be 4 characters.");
        }
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}
