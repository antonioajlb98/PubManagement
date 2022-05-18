module AntonioJesus.PubManagement {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;
	requires java.sql;
	requires javafx.base;
	requires org.apache.commons.codec;
	requires java.desktop;
	requires javafx.graphics;

    opens AntonioJesus.PubManagement to javafx.fxml;
    opens utils to java.xml.bind;
    exports AntonioJesus.PubManagement;
}
