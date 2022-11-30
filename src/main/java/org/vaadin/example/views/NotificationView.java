package org.vaadin.example.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_TERTIARY_INLINE;

@PageTitle("Notification")
@Route(value = "notification", layout = MainView.class)
public class NotificationView extends VerticalLayout {

    public NotificationView() {

        positioning();
        withButton();
        withButtonPrimary();
        withButtonSuccess();
        withButtonError();
        withButtonContrast();
    }

    public Void positioning() {
        H5 groupHeading = new H5("Positions");

        add(
                groupHeading,
                createButton(Position.TOP_STRETCH),
                createButton(Position.TOP_START),
                createButton(Position.TOP_CENTER),
                createButton(Position.TOP_END),
                createButton(Position.MIDDLE),
                createButton(Position.BOTTOM_START),
                createButton(Position.BOTTOM_CENTER),
                createButton(Position.BOTTOM_END),
                createButton(Position.BOTTOM_STRETCH)
        );

        return null;
    }

    public Void withButton() {
        H5 groupHeading = new H5("Notification with button example");

        Button button = new Button("With button");
        button.addClickListener(clickEvent -> {
            button.setEnabled(false);

            Notification notification = show();
            notification.addDetachListener(detachEvent -> button.setEnabled(true));
        });

        add(groupHeading, button);

        return null;
    }

    public Void withButtonPrimary() {

        Button button = new Button("With button Primary");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(clickEvent -> {
            button.setEnabled(false);

            Notification notification = showPrimary();
            notification.addDetachListener(detachEvent -> button.setEnabled(true));
        });

        add(button);

        return null;
    }

    public Void withButtonSuccess() {

        Button button = new Button("With button Success");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        button.addClickListener(clickEvent -> {
            button.setEnabled(false);

            Notification notification = showSuccess();
            notification.addDetachListener(detachEvent -> button.setEnabled(true));
        });

        add(button);

        return null;
    }

    public Void withButtonError() {

        Button button = new Button("With button Error");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        button.addClickListener(clickEvent -> {
            button.setEnabled(false);

            Notification notification = showError();
            notification.addDetachListener(detachEvent -> button.setEnabled(true));
        });

        add(button);

        return null;
    }

    public Void withButtonContrast() {

        Button button = new Button("With button Contrast");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        button.addClickListener(clickEvent -> {
            button.setEnabled(false);

            Notification notification = showContrast();
            notification.addDetachListener(detachEvent -> button.setEnabled(true));
        });

        add(button);

        return null;
    }

    private Button createButton(Position position) {
        Button button = new Button(position.getClientName());
        button.addClickListener(event -> show(position));
        return button;
    }

    private void show(Position position) {
        Notification.show(position.getClientName(), 0, position);
    }

    public Notification show() {
        Notification notification = new Notification();
        notification.setDuration(10000);
        notification.addThemeName("with-trailing");

        Div statusText = new Div(new Text("5 tasks deleted"));
        statusText.getElement().getStyle().set("margin-right", "var(--lumo-space-xl)");

        Button undoButton = new Button("Undo");
        undoButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        undoButton.addClickListener(event -> {
            notification.close();
        });

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(event -> {
            notification.close();
        });

        HorizontalLayout layout = new HorizontalLayout(statusText, undoButton, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();

        notification.setPosition(Position.BOTTOM_CENTER);
        notification.setDuration(0);

        return notification;
    }

    public Notification showPrimary() {
        Notification notification = new Notification();
        notification.setDuration(10000);
        notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);
        notification.addThemeName("with-trailing");

        Div statusText = new Div(new Text("5 tasks deleted"));
        statusText.getElement().getStyle().set("margin-right", "var(--lumo-space-xl)");

        Button undoButton = new Button("Undo");
        undoButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        undoButton.addClickListener(event -> {
            notification.close();
        });

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(event -> {
            notification.close();
        });

        HorizontalLayout layout = new HorizontalLayout(statusText, undoButton, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();

        notification.setPosition(Position.BOTTOM_CENTER);
        notification.setDuration(0);

        return notification;
    }

    public Notification showSuccess() {
        Notification notification = new Notification();
        notification.setDuration(10000);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.addThemeName("with-trailing");

        Div statusText = new Div(new Text("5 tasks deleted"));
        statusText.getElement().getStyle().set("color", "var(--lumo-tint)"); // add this for better contrast and accessibility when using this variant for the notification
        statusText.getElement().getStyle().set("margin-right", "var(--lumo-space-xl)");

        Button undoButton = new Button("Undo");
        undoButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        undoButton.addClickListener(event -> {
            notification.close();
        });

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(event -> {
            notification.close();
        });

        HorizontalLayout layout = new HorizontalLayout(statusText, undoButton, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();

        notification.setPosition(Position.BOTTOM_CENTER);
        notification.setDuration(0);

        return notification;
    }

    public Notification showError() {
        Notification notification = new Notification();
        notification.setDuration(10000);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.addThemeName("with-trailing");

        Div statusText = new Div(new Text("5 tasks deleted"));
        statusText.getElement().getStyle().set("color", "var(--lumo-tint)"); // add this for better contrast and accessibility when using this variant for the notification
        statusText.getElement().getStyle().set("margin-right", "var(--lumo-space-xl)");

        Button undoButton = new Button("Undo");
        undoButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        undoButton.addClickListener(event -> {
            notification.close();
        });

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(event -> {
            notification.close();
        });

        HorizontalLayout layout = new HorizontalLayout(statusText, undoButton, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();

        notification.setPosition(Position.BOTTOM_CENTER);
        notification.setDuration(0);

        return notification;
    }

    public Notification showContrast() {
        Notification notification = new Notification();
        notification.setDuration(10000);
        notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
        notification.addThemeName("with-trailing");

        Div statusText = new Div(new Text("5 tasks deleted"));
        statusText.getElement().getStyle().set("margin-right", "var(--lumo-space-xl)");

        Button undoButton = new Button("Undo");
        undoButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        undoButton.addClickListener(event -> {
            notification.close();
        });

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(event -> {
            notification.close();
        });

        HorizontalLayout layout = new HorizontalLayout(statusText, undoButton, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();

        notification.setPosition(Position.BOTTOM_CENTER);
        notification.setDuration(0);

        return notification;
    }

    /*public NotificationRich() {
        Button uploadSuccessBtn = new Button(
                "Try it",
                createClickHandler(NotificationRich::createUploadSuccess));
        uploadSuccessBtn.addThemeVariants(LUMO_SUCCESS);

        setJustifyContentMode(JustifyContentMode.CENTER);
        add(uploadSuccessBtn);
    }*/

    public static Notification createUploadSuccess() {
        Notification notification = new Notification();

        Icon icon = VaadinIcon.CHECK_CIRCLE.create();
        icon.setColor("var(--lumo-success-color)");

        Div uploadSuccessful = new Div(new Text("Upload successful"));
        uploadSuccessful
                .getStyle()
                .set("font-weight", "600")
                .set("color", "var(--lumo-success-text-color)");

        Span fileName = new Span("Financials.xlsx");
        fileName.getStyle()
                .set("font-size", "var(--lumo-font-size-s)")
                .set("font-weight", "600");

        Div info = new Div(uploadSuccessful, new Div(
                fileName,
                new Text(" is now available in "),
                new Anchor("#", "Documents")
        ));
        info.getStyle()
                .set("font-size", "var(--lumo-font-size-s)")
                .set("color", "var(--lumo-secondary-text-color)");

        HorizontalLayout layout = new HorizontalLayout(
                icon, info,
                createCloseBtn(notification));
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        notification.add(layout);

        return notification;
    }

    public static Button createCloseBtn(Notification notification) {
        Button closeBtn = new Button(
                VaadinIcon.CLOSE_SMALL.create(),
                clickEvent -> notification.close());
        closeBtn.addThemeVariants(LUMO_TERTIARY_INLINE);

        return closeBtn;
    }
}