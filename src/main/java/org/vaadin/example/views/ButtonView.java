package org.vaadin.example.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.example.MainView;

@PageTitle("Button")
@Route(value = "button", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
public class ButtonView extends VerticalLayout {

    public ButtonView() {
        Button primaryButton = new Button("Primary");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button secondaryButton = new Button("Secondary");

        Button contrastButton = new Button("Contrast");
        contrastButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        Button destructiveButton = new Button(" Destructive");
        destructiveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);

        HorizontalLayout appearanceLayout = new HorizontalLayout(
                primaryButton, secondaryButton, contrastButton, destructiveButton
        );
        add(appearanceLayout);
    }
}
