package org.vaadin.example.views;

import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Text Area")
@Route(value = "text-area", layout = MainView.class)
public class TextAreaView extends VerticalLayout {
    public TextAreaView() {

        basic();
        placeholder();
        value();

    }

    public Void basic() {
        H5 groupHeading = new H5("Basic");

        int charLimit = 600;

        TextArea textArea = new TextArea();
        textArea.setWidth("400px");
        textArea.setLabel("Label");
        textArea.setMaxLength(charLimit);
        textArea.setValueChangeMode(ValueChangeMode.EAGER);
        textArea.setHelperText(0 + "/" + charLimit);
        textArea.addValueChangeListener(e -> {
            e.getSource().setHelperText(e.getValue().length() + "/" + charLimit);
        });

        add(groupHeading, textArea);

        return null;
    }

    public Void placeholder() {
        H5 groupHeading = new H5("Placeholder");

        int charLimit = 600;

        TextArea textArea = new TextArea();
        textArea.setWidth("400px");
        textArea.setLabel("Label");
        textArea.setMaxLength(charLimit);
        textArea.setPlaceholder("Placeholder");
        textArea.setValueChangeMode(ValueChangeMode.EAGER);
        textArea.setHelperText(0 + "/" + charLimit);
        textArea.addValueChangeListener(e -> {
            e.getSource().setHelperText(e.getValue().length() + "/" + charLimit);
        });

        add(groupHeading, textArea);

        return null;
    }

    public Void value() {
        H5 groupHeading = new H5("value");

        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel semper libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae.";
        int charLimit = 600;

        TextArea textArea = new TextArea();
        textArea.setWidth("400px");
        textArea.setLabel("Label");
        textArea.setMaxLength(charLimit);
        textArea.setValue(loremIpsum);
        textArea.setValueChangeMode(ValueChangeMode.EAGER);
        textArea.setHelperText(0 + "/" + charLimit);
        textArea.addValueChangeListener(e -> {
            e.getSource().setHelperText(e.getValue().length() + "/" + charLimit);
        });

        add(groupHeading, textArea);

        return null;
    }
}
