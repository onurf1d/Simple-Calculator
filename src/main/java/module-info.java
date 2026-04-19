module simple.calculator {
    // 1. Kullanacağın JavaFX modüllerini ekle
    requires javafx.controls;
    requires javafx.fxml;

    // 2. Senin paketlerini JavaFX'in görebilmesi için "aç" (Open)
    // FXML kullanıyorsan 'opens' kritik önemdedir.
    opens com.onur.simplecalculator to javafx.fxml;
    opens com.onur.simplecalculator.ui to javafx.fxml;

    // 3. Dış dünyaya hangi paketlerin erişilebilir olduğunu belirt
    exports com.onur.simplecalculator;
}
