package org.vaadin.example.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import org.vaadin.domain.Person;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridMultiSelectionModel;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@PageTitle("Components")
@Route(value = "components", layout = MainView.class)
@CssImport(value="themes/forge-tech/views/components-view.css")
public class ComponentsView extends FlexLayout {

    public ComponentsView() {
        setSizeFull();
        addClassNames("components-view", "gap-l");
        FlexLayout col1 = new FlexLayout();
        col1.setFlexDirection(FlexDirection.COLUMN);
        col1.addClassNames("gap-l");
        col1.setWidthFull();
        col1.add(createButtonExamples());
        col1.add(createFieldExamples());

        FlexLayout col2 = new FlexLayout();
        col2.setFlexDirection(FlexDirection.COLUMN);
        col2.addClassNames("gap-l");
        col2.setWidthFull();
        col2.add(createGridExample());
        col2.add(createTabsExample());
        col2.add(createMessagesExample());

        add(col1, col2);
    }

    private Component createButtonExamples() {
        VerticalLayout layout = new VerticalLayout();
        layout.addClassName("card");
        layout.addClassNames("gap-s");

        layout.add(generateButtonVariants());
        layout.add(generateButtonVariants(ButtonVariant.LUMO_ERROR));
        layout.add(generateButtonVariants(ButtonVariant.LUMO_SUCCESS));
        layout.add(generateButtonVariants(ButtonVariant.LUMO_CONTRAST));

        return layout;
    }

    private HorizontalLayout generateButtonVariants() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addClassNames("flex-wrap");

        Button primaryButton = new Button("Primary");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button secondaryButton = new Button("Secondary");

        Button tertiaryButton = new Button("Tertiary");
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Button primaryIconButton = new Button();
        primaryIconButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        primaryIconButton.setIcon(VaadinIcon.SEARCH.create());

        Button secondaryIconButton = new Button();
        secondaryIconButton.setIcon(VaadinIcon.SEARCH.create());

        Button tertiaryIconButton = new Button();
        tertiaryIconButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        tertiaryIconButton.setIcon(VaadinIcon.SEARCH.create());

        buttons.add(new HorizontalLayout(primaryButton, secondaryButton, tertiaryButton), new HorizontalLayout(primaryIconButton, secondaryIconButton, tertiaryIconButton));
        return buttons;
    }
    private HorizontalLayout generateButtonVariants(ButtonVariant variant) {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addClassNames("flex-wrap");

        Button primaryButton = new Button("Primary");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        primaryButton.addThemeVariants(variant);

        Button secondaryButton = new Button("Secondary");
        secondaryButton.addThemeVariants(variant);

        Button tertiaryButton = new Button("Tertiary");
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        tertiaryButton.addThemeVariants(variant);

        Button primaryIconButton = new Button();
        primaryIconButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        primaryIconButton.setIcon(VaadinIcon.SEARCH.create());
        primaryIconButton.addThemeVariants(variant);

        Button secondaryIconButton = new Button();
        secondaryIconButton.setIcon(VaadinIcon.SEARCH.create());
        secondaryIconButton.addThemeVariants(variant);

        Button tertiaryIconButton = new Button();
        tertiaryIconButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        tertiaryIconButton.setIcon(VaadinIcon.SEARCH.create());
        tertiaryIconButton.addThemeVariants(variant);

        buttons.add(new HorizontalLayout(primaryButton, secondaryButton, tertiaryButton), new HorizontalLayout(primaryIconButton, secondaryIconButton, tertiaryIconButton));
        return buttons;
    }

    private Component createFieldExamples() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.addClassName("card");
        layout.addClassName("gap-l");

        VerticalLayout left = new VerticalLayout();
        left.setPadding(false);
        left.addClassName("gap-s");
        VerticalLayout right = new VerticalLayout();
        right.setPadding(false);
        right.addClassName("gap-s");

        TextField basic = new TextField("Field");
        basic.setWidthFull();

        TextField trailingContent = new TextField("Read-only");
        trailingContent.setSuffixComponent(new Div(new Text("EUR €")));
        trailingContent.setValue("500.00");
        trailingContent.setReadOnly(true);
        trailingContent.setWidthFull();

        TextField leadingIcon = new TextField("Invalid");
        leadingIcon.setPlaceholder("Leading icon");
        leadingIcon.setPrefixComponent(VaadinIcon.PHONE.create());
        leadingIcon.setValue("12345678");
        leadingIcon.setErrorMessage("Invalid phone number");
        leadingIcon.addThemeName("leading-icon"); // used when field has a prefix icon component
        leadingIcon.setInvalid(true);
        leadingIcon.setWidthFull();

        TextField supportiveText = new TextField("Focus");
        supportiveText.setHelperText("Helper text");
        supportiveText.setPlaceholder("Placeholder");
        supportiveText.getElement().setAttribute("focus-ring", "");
        supportiveText.setWidthFull();

        TextField disabledField = new TextField("Disabled");
        disabledField.setValue("Value");
        disabledField.setEnabled(false);
        disabledField.setWidthFull();

        ComboBox<String> comboBox = new ComboBox<>("Combo Box");
        comboBox.setAllowCustomValue(true);
        comboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        comboBox.setPlaceholder("Select an option");
        comboBox.setWidthFull();

        /*MultiSelectComboBox<String> multiSelectComboBox = new MultiSelectComboBox<>("Multiselect");
        multiSelectComboBox.setWidth("300px");
        multiSelectComboBox.setAllowCustomValue(true);
        multiSelectComboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10");
        multiSelectComboBox.setValue("Item 2", "Item 5", "Item 6");
        multiSelectComboBox.setPlaceholder("Select an options");
        multiSelectComboBox.setWidthFull();*/

        DatePicker datePicker = new DatePicker("Date Picker");
        datePicker.setPlaceholder("Dd/Mm/Yy");
        datePicker.setLocale(Locale.US);
        datePicker.setWidthFull();

        RadioButtonGroup<String> radioGroupVertical = new RadioButtonGroup<>();
        radioGroupVertical.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        radioGroupVertical.setLabel("Radio Buttons");
        radioGroupVertical.setItems("Item 1", "Item 2", "Item 3");
        radioGroupVertical.setValue("Item 1");

        CheckboxGroup<String> checkboxGroupVertical = new CheckboxGroup<>();
        checkboxGroupVertical.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        checkboxGroupVertical.setLabel("Checkboxes");
        checkboxGroupVertical.setItems("Item 1", "Item 2", "Item 3");
        checkboxGroupVertical.select("Item 1");


        left.add(basic, trailingContent, leadingIcon, supportiveText, disabledField);
        right.add(comboBox, datePicker, radioGroupVertical, checkboxGroupVertical); // multiSelectComboBox
        layout.add(left, right);
        return layout;
    }

    private Component createGridExample() {
        Div layout = new Div();
        layout.addClassName("card");

        List<Person> people = getPeople();

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        ((GridMultiSelectionModel<?>) grid
                .setSelectionMode(Grid.SelectionMode.MULTI))
                .setSelectionColumnFrozen(true);
        grid.addColumn(Person::getFirstName).setHeader("First name").setAutoWidth(true).setFrozen(true);
        grid.addColumn(Person::getLastName).setHeader("Last name").setAutoWidth(true);
        grid.addColumn(Person::getEmail).setHeader("Email").setAutoWidth(true);
        grid.addColumn(Person::getProfession).setHeader("Profession").setAutoWidth(true);
        grid.setItems(people);
        grid.select(people.get(2));
        grid.setHeight("320px");

        layout.add(grid);
        return layout;
    }

    private Component createTabsExample() {
        FlexLayout layout = new FlexLayout();
        layout.addClassName("card");
        layout.setFlexDirection(FlexDirection.COLUMN);
        layout.addClassNames("gap-l");

        Tab tab1 = new Tab("First tab");
        Tab tab2 = new Tab("Second tab");
        Tab tab3 = new Tab("Third tab");
        Tab tab4 = new Tab("Fourth tab");
        tab4.setEnabled(false);

        Tabs tabs = new Tabs(tab1, tab2, tab3, tab4);
        tabs.setSelectedTab(tab1);

        layout.add(tabs, createBadgesExample());
        return layout;
    }

    private Component createBadgesExample() {
        FlexLayout layout = new FlexLayout();
        layout.addClassNames("gap-s", "flex-wrap");

        FlexLayout normalBadges = new FlexLayout();
        normalBadges.addClassNames("gap-s");
        FlexLayout primaryBadges = new FlexLayout();
        primaryBadges.addClassNames("gap-s");

        Span none = new Span("Default");
        none.getElement().getThemeList().add("badge");

        Span success = new Span("Success");
        success.getElement().getThemeList().add("badge success");

        Span error = new Span("Error");
        error.getElement().getThemeList().add("badge error");

        Span contrast = new Span("Contrast");
        contrast.getElement().getThemeList().add("badge contrast");

        Span nonePrimary = new Span("Default");
        nonePrimary.getElement().getThemeList().add("badge primary");

        Span successPrimary = new Span("Success");
        successPrimary.getElement().getThemeList().add("badge success primary");

        Span errorPrimary = new Span("Error");
        errorPrimary.getElement().getThemeList().add("badge error primary");

        Span contrastPrimary = new Span("Contrast");
        contrastPrimary.getElement().getThemeList().add("badge contrast primary");


        normalBadges.add(none, success, error, contrast);
        primaryBadges.add(nonePrimary, successPrimary, errorPrimary, contrastPrimary);
        layout.add(normalBadges, primaryBadges);
        return layout;
    }

    private Component createMessagesExample() {
        Div layout = new Div();
        layout.addClassName("card");

        List<Person> people = getPeople();
        MessageList list = new MessageList();
        Instant yesterday = LocalDateTime.now().minusDays(1)
                .toInstant(ZoneOffset.UTC);
        Instant fiftyMinsAgo = LocalDateTime.now().minusMinutes(50)
                .toInstant(ZoneOffset.UTC);
        MessageListItem message1 = new MessageListItem(
                "Linsey, did you know these apps can be fully styled?",
                yesterday, "Matt Mambo");
        message1.setUserColorIndex(1);
        MessageListItem message2 = new MessageListItem("Yup. Lumo is always there as the base and modifications can be applied on top.",
                fiftyMinsAgo, "Linsey Listy");
        message2.setUserColorIndex(2);
        MessageListItem message3 = new MessageListItem(
                "Cool!",
                yesterday, "Matt Mambo");
        message3.setUserColorIndex(1);
        list.setItems(Arrays.asList(message1, message2, message3));

        layout.add(list);
        return layout;
    }

    public List<Person> getPeople(){
        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Person person = new Person();
            person.setFirstName("Firstname" + i);
            person.setLastName("Lastname" + i);
            person.setEmail("firstname" + i +"@company.com");
            person.setId(i);
            person.setProfession("Developer");

            people.add(person);
        }
        return people;
    }

}