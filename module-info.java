module com.dashboard.autodashboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    opens com.dashboard.autodashboard to javafx.fxml;
    exports com.dashboard.autodashboard;
    opens javax.lang.model.util;
    opens javax.swing.event;
}