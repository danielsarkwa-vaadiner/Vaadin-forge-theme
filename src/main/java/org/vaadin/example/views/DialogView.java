package org.vaadin.example.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Dialog")
@Route(value = "dialog", layout = MainView.class)
public class DialogView extends VerticalLayout {

    public DialogView() {
        Dialog dialog = new Dialog();
        dialog.getElement().setAttribute("aria-label", "Create new employee");

        VerticalLayout dialogLayout = createDialogLayout(dialog);
        dialog.add(dialogLayout);

        Button button = new Button("Show dialog", e -> dialog.open());
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(dialog, button);
    }

    private static VerticalLayout createDialogLayout(Dialog dialog) {
        H4 title = new H4("Discard draft?");
        Paragraph message = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Morbi aliquam, neque non varius egestas, nisi urna venenatis lacus, sit amet malesuada mauris urna et ex.");

        Footer footer = createFooter(dialog);

        VerticalLayout dialogLayout = new VerticalLayout(title, message, footer);
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "500px").set("max-width", "100%");

        return dialogLayout;
    }

    private static Footer createFooter(Dialog dialog) {
        Button cancelButton = new Button("Cancel", e -> dialog.close());

        Button saveButton = new Button("Discard", e -> dialog.close());
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, saveButton);
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        return new Footer(buttonLayout);
    }

}
