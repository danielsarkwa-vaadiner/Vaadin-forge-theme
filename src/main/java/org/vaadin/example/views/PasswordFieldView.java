package org.vaadin.example.views;

import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Password Field")
@Route(value = "password-field", layout = MainView.class)
public class PasswordFieldView extends VerticalLayout {
    public PasswordFieldView() {

        basic();
        helperText();
    }

    public Void basic() {
        H5 groupHeading = new H5("Basic field");

        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setValue("Ex@mple");

        add(groupHeading, passwordField);

        return null;
    }

    public Void helperText() {
        H5 groupHeading = new H5("Helper Text");

        PasswordField helperText = new PasswordField();
        helperText.setLabel("Password");
        helperText.setValue("Ex@mple");
        helperText.setHelperText("A password must be at least 8 characters.");

        add(groupHeading, helperText);

        return null;
    }
}