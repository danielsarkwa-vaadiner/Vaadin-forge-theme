package org.vaadin.example.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
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
        basic();
        danger();
        success();
        contrast();
        disabled();
        icons();
    }

    public Void basic() {
        H5 groupHeading = new H5("Basic Variants");

        Button primaryButton = new Button("Button");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button secondaryButton = new Button("Button");

        Button tertiaryButton = new Button("Button");
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        HorizontalLayout layout = new HorizontalLayout(primaryButton, secondaryButton, tertiaryButton);
        add(groupHeading, layout);

        return null;
    }
    public Void danger() {
        H5 groupHeading = new H5("Danger / Error Variants");

        Button primaryButton = new Button("Button");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);

        Button secondaryButton = new Button("Button");
        secondaryButton.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button tertiaryButton = new Button("Button");
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_ERROR);

        HorizontalLayout layout = new HorizontalLayout(primaryButton, secondaryButton, tertiaryButton);
        add(groupHeading, layout);

        return null;
    }

    public Void success() {
        H5 groupHeading = new H5("Success Variants");

        Button primaryButton = new Button("Button");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        Button secondaryButton = new Button("Button");
        secondaryButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        Button tertiaryButton = new Button("Button");
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SUCCESS);

        HorizontalLayout layout = new HorizontalLayout(primaryButton, secondaryButton, tertiaryButton);
        add(groupHeading, layout);

        return null;
    }

    public Void contrast() {
        H5 groupHeading = new H5("Contrast Variants");

        Button primaryButton = new Button("Button");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

        Button secondaryButton = new Button("Button");
        secondaryButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        Button tertiaryButton = new Button("Button (avoid)");
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_CONTRAST);

        HorizontalLayout layout = new HorizontalLayout(primaryButton, secondaryButton, tertiaryButton);
        add(groupHeading, layout);

        return null;
    }

    public Void icons() {
        H5 groupHeading = new H5("Buttons With Icons");

        Button plusButton = new Button(new Icon(VaadinIcon.PLUS));
        plusButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        plusButton.getElement().setAttribute("aria-label", "Add item");

        Button arrowLeftButton = new Button("Left", new Icon(VaadinIcon.PAPERPLANE));
        arrowLeftButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button arrowRightButton = new Button("Right", new Icon(VaadinIcon.ARROW_RIGHT));
        arrowRightButton.setIconAfterText(true);

        HorizontalLayout layout = new HorizontalLayout(plusButton, arrowLeftButton, arrowRightButton);
        add(groupHeading, layout);

        return null;
    }

    public Void disabled() {
        H5 groupHeading = new H5("Disabled Variants");

        Button primaryButton = new Button("Button");
        primaryButton.setEnabled(false);
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button secondaryButton = new Button("Button");
        secondaryButton.setEnabled(false);

        Button tertiaryButton = new Button("Button");
        tertiaryButton.setEnabled(false);
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        HorizontalLayout layout = new HorizontalLayout(primaryButton, secondaryButton, tertiaryButton);
        add(groupHeading, layout);

        return null;
    }
}
