package org.vaadin.example.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Confirm Dialog")
@Route(value = "confirm-dialog", layout = MainView.class)
public class ConfirmDialogView extends VerticalLayout {
    private Span status;

    public ConfirmDialogView() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        status = new Span();
        status.setVisible(false);

        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setHeader("Unsaved changes");
        dialog.setText("There are unsaved changes. Do you want to discard or save them?");

        dialog.setCancelable(true);
        dialog.addCancelListener(event -> setStatus("Canceled"));

        dialog.setRejectable(true);
        dialog.setRejectText("Discard");
        dialog.addRejectListener(event -> setStatus("Discarded"));

        dialog.setConfirmText("Save");
        dialog.addConfirmListener(event -> setStatus("Saved"));

        Button button = new Button("Open confirm dialog");
        button.addClickListener(event -> {
            dialog.open();
            status.setVisible(false);
        });

        layout.add(button, status);
        add(layout);
    }

    private void setStatus(String value) {
        status.setText("Status: " + value);
        status.setVisible(true);
    }
}
