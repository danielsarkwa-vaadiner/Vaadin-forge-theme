package org.vaadin.example.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Email Field")
@Route(value = "email-field", layout = MainView.class)
public class EmailFieldView extends VerticalLayout {

    public EmailFieldView() {
        EmailField validEmailField = new EmailField();
        validEmailField.setLabel("Email address");
        validEmailField.getElement().setAttribute("name", "email");
        validEmailField.setClearButtonVisible(true);

        EmailField invalidEmailField = new EmailField();
        invalidEmailField.setLabel("Email address");
        invalidEmailField.getElement().setAttribute("name", "email");
        invalidEmailField.setValue("This is not an email");
        invalidEmailField.setErrorMessage("Please enter a valid email address");
        invalidEmailField.setClearButtonVisible(true);
        invalidEmailField.setInvalid(true);

        add(validEmailField, invalidEmailField);
    }
}
