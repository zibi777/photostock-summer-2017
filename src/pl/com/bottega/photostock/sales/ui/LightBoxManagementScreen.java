package pl.com.bottega.photostock.sales.ui;

import pl.com.bottega.photostock.sales.application.LightBoxManagement;
import pl.com.bottega.photostock.sales.model.LightBox;

import java.util.List;
import java.util.Scanner;

public class LightBoxManagementScreen {

    private Scanner scanner;
    private LightBoxManagement lightBoxManagement;
    private AuthenticationManager authenticationManager;

    public LightBoxManagementScreen(Scanner scanner, LightBoxManagement lightBoxManagement,
                                    AuthenticationManager authenticationManager) {
        this.scanner = scanner;
        this.lightBoxManagement = lightBoxManagement;
        this.authenticationManager = authenticationManager;
    }

    public void show() {
        System.out.println("Twoje lajt boksy:");
        List<LightBox> lightBoxes = lightBoxManagement.getLightBoxes(authenticationManager.getClientNumber());
        if(lightBoxes.isEmpty())
            System.out.println("Nie masz aktualnie żadnych lajt boksów");
        else {
            int index = 1;
            for (LightBox lightBox : lightBoxes)
                System.out.println(String.format("%d. %s", index++, lightBox.getName()));
        }
    }

}
