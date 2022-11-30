package org.vaadin.example.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Text Field")
@Route(value = "text-field", layout = MainView.class)
public class TextFieldView extends VerticalLayout {
    public TextFieldView() {

        labeling();
        prefixSuffix();
        readonly();
        diabled();
        clearable();
        helperText();
    }

    public Void labeling() {
        H5 groupHeading = new H5("Label and placeholder");

        TextField basic = new TextField();

        TextField placeholder = new TextField();
        placeholder.setPlaceholder("Placeholder");

        TextField label = new TextField();
        label.setLabel("Label");

        TextField lp = new TextField();
        lp.setLabel("Label & placeholder");
        lp.setPlaceholder("Placeholder");

        HorizontalLayout labeling = new HorizontalLayout(basic, placeholder, label, lp);
        add(groupHeading, labeling);

        return null;
    }

    public Void prefixSuffix() {
        H5 groupHeading = new H5("Prefix and Suffix");

        TextField prefixWithLabel = new TextField();
        prefixWithLabel.setLabel("Label");
        prefixWithLabel.addThemeName("leading-icon"); // used when field has a prefix icon component
        prefixWithLabel.setPlaceholder("Search");
        prefixWithLabel.setPrefixComponent(VaadinIcon.SEARCH.create());

        TextField textPrefixWithLabel = new TextField();
        textPrefixWithLabel.setLabel("Label");
        textPrefixWithLabel.addThemeName("has-text-prefix"); // used when field has a prefix icon component
        textPrefixWithLabel.setPlaceholder("Search");
        Div prefixItem = new Div(new Text("$"));
        textPrefixWithLabel.setPrefixComponent(prefixItem);

        TextField prefixlp = new TextField();
        prefixlp.setLabel("Label");
        prefixlp.addThemeName("leading-icon"); // used when field has a prefix icon component
        prefixlp.setPlaceholder("Search");
        prefixlp.setPrefixComponent(VaadinIcon.SEARCH.create());

        TextField prefix = new TextField();
        prefix.setPlaceholder("Search");
        prefix.setPrefixComponent(VaadinIcon.SEARCH.create());

        TextField prefixWithoutPlaceholder = new TextField();
        prefixWithoutPlaceholder.setLabel("Label");
        prefixWithoutPlaceholder.addThemeName("leading-icon"); // used when field has a prefix icon component
        prefixWithoutPlaceholder.setPrefixComponent(VaadinIcon.SEARCH.create());

        TextField prefixBasic = new TextField();
        prefixBasic.setPrefixComponent(VaadinIcon.SEARCH.create());

        TextField suffix = new TextField();
        suffix.setLabel("Length");
        suffix.setPlaceholder("123");
        suffix.setSuffixComponent(new Div(new Text("cm")));

        TextField suffixWithoutLabel = new TextField();
        suffixWithoutLabel.setPlaceholder("123");
        suffixWithoutLabel.setSuffixComponent(new Div(new Text("cm")));

        TextField suffixWithoutPlaceholder = new TextField();
        suffixWithoutPlaceholder.setLabel("Length");
        suffixWithoutPlaceholder.setSuffixComponent(new Div(new Text("cm")));

        TextField suffixBasic = new TextField();
        suffixBasic.setSuffixComponent(new Div(new Text("cm")));

        HorizontalLayout prefixLayout = new HorizontalLayout(
                prefixWithLabel, textPrefixWithLabel, prefixlp, prefix, prefixWithoutPlaceholder, prefixBasic);
        HorizontalLayout suffixLayout = new HorizontalLayout(
                suffix, suffixWithoutLabel, suffixWithoutPlaceholder, suffixBasic);
        add(groupHeading, prefixLayout, suffixLayout);

        return null;
    }

    public Void clearable() {
        H5 groupHeading = new H5("Clear button");

        TextField withlp = new TextField();
        withlp.setLabel("Label");
        withlp.setPlaceholder("Placeholder");
        withlp.setClearButtonVisible(true);

        TextField withPlaceholder = new TextField();
        withPlaceholder.setPlaceholder("Placeholder");
        withPlaceholder.setClearButtonVisible(true);

        TextField withLabel = new TextField();
        withLabel.setLabel("Label");
        withLabel.setClearButtonVisible(true);

        TextField basic = new TextField();
        basic.setClearButtonVisible(true);
        basic.setValue("Value");

        HorizontalLayout layout = new HorizontalLayout(withlp, withPlaceholder, withLabel, basic);
        add(groupHeading, layout);

        return null;
    }

    public Void helperText() {
        H5 groupHeading = new H5("Helper Text");

        TextField basic = new TextField();
        basic.setPattern("^[+]?[(]?[0-9]{3}[)]?[-s.]?[0-9]{3}[-s.]?[0-9]{4,6}$");
        basic.setHelperText("Format: +(123)456-7890");
        basic.setLabel("Label");

        add(groupHeading, basic);

        return null;
    }

    public Void readonly() {
        H5 groupHeading = new H5("Read-only");

        TextField readOnly = new TextField();
        readOnly.setReadOnly(true);
        readOnly.setLabel("Read-only");
        readOnly.setValue("Value");

        add(groupHeading, readOnly);

        return null;
    }

    public Void diabled() {
        H5 groupHeading = new H5("Disabled");

        TextField textField = new TextField();
        textField.setEnabled(false);
        textField.setLabel("Disabled");
        textField.setValue("value");

        add(groupHeading, textField);

        return null;
    }
}