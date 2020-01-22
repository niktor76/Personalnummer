package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public Button btnPruefen;
    public TextField txtEingabe;
    public Label lblAusgabe;

    public void actPruefen(javafx.event.ActionEvent actionEvent) {
        String eingabe = txtEingabe.getText();
        if (eingabe.length()<6){
            lblAusgabe.setText("Eingabe zu kurz.");
            return;
        } else if (eingabe.length()>6){
            lblAusgabe.setText("Eingabe zu lang.");
            return;
        }

        int jahr = Integer.parseInt(eingabe.substring(0, 2));
        int monat = Integer.parseInt(eingabe.substring(2, 4));
        String lfdNummer = eingabe.substring(4, 6);
        char[] ziffern = eingabe.toCharArray();
        int gewichtung[] = {7, 6, 5, 4, 3, 2};
        char pruefzeichenListe[] = "ABCDEFGHJKLMNPQRSTUWXYZ".toCharArray();
        String monatsNamen[] = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli",
                "August", "September", "Oktober", "November", "Dezember"};
        int summe = 0;
        for (int i = 0; i < 6; i++) {
            summe += Character.getNumericValue(ziffern[i]) * gewichtung[i];
        }
        char pruefzeichen = pruefzeichenListe[23 - summe % 23];
        lblAusgabe.setText(monatsNamen[monat] + ", " + jahr + ", lfd. Nr.  "
                + lfdNummer + ", Prüfzeichen: " + pruefzeichen);
    }
}
