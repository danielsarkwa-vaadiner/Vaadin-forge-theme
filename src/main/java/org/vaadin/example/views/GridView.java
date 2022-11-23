package org.vaadin.example.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.vaadin.domain.Person;
import org.vaadin.domain.DataService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

import java.util.List;
import java.util.function.Consumer;

@PageTitle("Grid")
@Route(value = "grid", layout = MainView.class)
public class GridView extends VerticalLayout {

    public GridView() {

        basic();
        gridPro();
        multiSelect();
        columnFreezing();
        headerFooter();
        sorting();
        filtering();
        striping();

    }

    public Void basic() {
        H5 groupHeading = new H5("Single Selection Mode");

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setWidth("1000px");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.addColumn(Person::getFirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");
        grid.addColumn(Person::getEmail).setHeader("Email");
        grid.addColumn(Person::getProfession).setHeader("Profession");

        List<Person> people = DataService.getPeople(10);
        grid.setItems(people);

        add(groupHeading, grid);

        return null;
    }

    public Void multiSelect() {
        H5 groupHeading = new H5("Multi-Select Mode");

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setWidth("1000px");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(Person::getFirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");
        grid.addColumn(Person::getEmail).setHeader("Email");

        List<Person> people = DataService.getPeople(10);
        grid.setItems(people);

        grid.addSelectionListener(selection -> {
            // System.out.printf("Number of selected people: %s%n", selection.getAllSelectedItems().size());
        });

        add(groupHeading, grid);

        return null;
    }

    public Void columnFreezing() {
        H5 groupHeading = new H5("Column Freezing");

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setWidth("1000px");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.addColumn(createPersonRenderer()).setHeader("Name").setFrozen(true)
                .setAutoWidth(true).setFlexGrow(0);
        grid.addColumn(Person::getEmail).setHeader("Email").setAutoWidth(true);
        grid.addColumn(person -> person.getAddress().getPhone())
                .setHeader("Phone").setAutoWidth(true);
        grid.addColumn(Person::getProfession).setHeader("Profession")
                .setAutoWidth(true);
        grid.addColumn(person -> person.getAddress().getStreet())
                .setHeader("Street").setAutoWidth(true);

        List<Person> people = DataService.getPeople(10);
        grid.setItems(people);

        add(groupHeading, grid);

        return null;
    }

    public Void headerFooter() {
        H5 groupHeading = new H5("Column Headers & Footers");

        List<Person> people = DataService.getPeople(10);

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setWidth("1000px");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.addColumn(Person::getFullName).setHeader("Name")
                .setFooter(String.format("%s total members", people.size()));
        grid.addColumn(person -> person.isSubscriber() ? "Yes" : "No")
                .setHeader(createSubscriberHeader())
                .setFooter(createSubscriberFooterText(people));
        grid.addColumn(Person::getMembership)
                .setHeader(createMembershipHeader())
                .setFooter(createMembershipFooterText(people));

        grid.setItems(people);

        add(groupHeading, grid);

        return null;
    }

    public Void sorting() {
        H5 groupHeading = new H5("Sorting");

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setWidth("1000px");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.addColumn(Person::getId).setHeader("Id").setSortable(true);
        grid.addColumn(Person::getFullName).setHeader("Name").setSortable(true);
        grid.addColumn(Person::getEmail).setHeader("Email").setSortable(true);
        grid.addColumn(Person::getProfession).setHeader("Profession")
                .setSortable(true);

        List<Person> people = DataService.getPeople(10);
        grid.setItems(people);


        add(groupHeading, grid);

        return null;
    }

    public Void filtering() {
        H5 groupHeading = new H5("Filtering");

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setWidth("1000px");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER); // should this style be in the css
        Grid.Column<Person> nameColumn = grid.addColumn(createPersonRenderer())
                .setWidth("230px").setFlexGrow(0);
        Grid.Column<Person> emailColumn = grid.addColumn(Person::getEmail);
        Grid.Column<Person> professionColumn = grid
                .addColumn(Person::getProfession);

        List<Person> people = DataService.getPeople(10);
        GridListDataView<Person> dataView = grid.setItems(people);
        PersonFilter personFilter = new PersonFilter(dataView);

        grid.getHeaderRows().clear();
        HeaderRow headerRow = grid.appendHeaderRow();

        headerRow.getCell(nameColumn).setComponent(
                createFilterHeader("Name", "Filter name...", personFilter::setFullName));
        headerRow.getCell(emailColumn).setComponent(
                createFilterHeader("Email", "Filter email...", personFilter::setEmail));
        headerRow.getCell(professionColumn).setComponent(
                createFilterHeader("Profession", "Filter profession...", personFilter::setProfession));

        add(groupHeading, grid);

        return null;
    }

    public Void striping() {
        H5 groupHeading = new H5("Row Stripes");

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.setWidth("1000px");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.addColumn(createAvatarRenderer()).setHeader("Image")
                .setAutoWidth(true).setFlexGrow(0);
        grid.addColumn(Person::getFirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");
        grid.addColumn(Person::getEmail).setHeader("Email");

        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

        List<Person> people = DataService.getPeople();
        grid.setItems(people);

        add(groupHeading, grid);

        return null;
    }

    public Void gridPro() {
        H3 groupHeading = new H3("Grid Pro");

        GridPro<Person> grid = new GridPro<>();
        grid.setWidth("1000px");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        grid.addEditColumn(Person::getFirstName)
                .text(Person::setFirstName)
                .setHeader("First name");

        grid.addEditColumn(Person::getLastName)
                .text(Person::setLastName)
                .setHeader("Last name");

        grid.addEditColumn(Person::getEmail)
                .text(Person::setEmail)
                .setHeader("Email");

        grid.addEditColumn(Person::getProfession)
                .text(Person::setProfession)
                .setHeader("Profession");

        List<Person> people = DataService.getPeople();
        grid.setItems(people);

        add(groupHeading, grid);

        return null;
    }

    private static Renderer<Person> createPersonRenderer() {
        return LitRenderer.<Person>of(
                        "<vaadin-horizontal-layout style=\"align-items: center;\" theme=\"spacing\">"
                                + "  <vaadin-avatar style=\"height: var(--lumo-size-m)\" img=\"${item.pictureUrl}\" name=\"${item.fullName}\" alt=\"User avatar\"></vaadin-avatar>"
                                + "  <span> ${item.fullName} </span>"
                                + "</vaadin-horizontal-layout>")
                .withProperty("pictureUrl", Person::getPictureUrl)
                .withProperty("fullName", Person::getFullName);
    }

    private static Renderer<Person> createAvatarRenderer() {
        return LitRenderer.<Person>of(
                        "<vaadin-avatar img=\"${item.pictureUrl}\" name=\"${item.fullName}\" alt=\"User avatar\"></vaadin-avatar>")
                .withProperty("pictureUrl", Person::getPictureUrl);
    }

    private static Component createSubscriberHeader() {
        Span span = new Span("Subscriber");
        Icon icon = VaadinIcon.INFO_CIRCLE.create();
        icon.getElement()
                .setAttribute("title", "Subscribers are paying customers");
        icon.getStyle().set("height", "var(--lumo-font-size-m)")
                .set("color", "var(--lumo-contrast-70pct)");

        HorizontalLayout layout = new HorizontalLayout(span, icon);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setSpacing(false);

        return layout;
    }

    private static String createSubscriberFooterText(List<Person> people) {
        long subscriberCount = people.stream().filter(Person::isSubscriber)
                .count();

        return String.format("%s subscribers", subscriberCount);
    }

    private static Component createMembershipHeader() {
        Span span = new Span("Membership");
        Icon icon = VaadinIcon.INFO_CIRCLE.create();
        icon.getElement().setAttribute("title",
                "Membership levels determines which features a client has access to");
        icon.getStyle().set("height", "var(--lumo-font-size-m)")
                .set("color", "var(--lumo-contrast-70pct)");

        HorizontalLayout layout = new HorizontalLayout(span, icon);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setSpacing(false);

        return layout;
    }

    private static String createMembershipFooterText(List<Person> people) {
        long regularCount = people.stream()
                .filter(person -> "Regular".equals(person.getMembership()))
                .count();
        long premiumCount = people.stream()
                .filter(person -> "Premium".equals(person.getMembership()))
                .count();
        long vipCount = people.stream()
                .filter(person -> "VIP".equals(person.getMembership())).count();

        return String.format("%s regular, %s premium, %s VIP", regularCount,
                premiumCount, vipCount);
    }

    private static Component createFilterHeader(String labelText, String placeholder,
                                                Consumer<String> filterChangeConsumer) {
        Label label = new Label(labelText);
        label.getStyle().set("padding-top", "var(--lumo-space-m)")
                .set("font-size", "var(--lumo-font-size-xs)");
        TextField textField = new TextField();
        textField.setPlaceholder(placeholder);
        textField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
        textField.setValueChangeMode(ValueChangeMode.EAGER);
        textField.setClearButtonVisible(true);
        textField.setWidthFull();
        textField.getStyle().set("max-width", "100%");
        textField.addValueChangeListener(
                e -> filterChangeConsumer.accept(e.getValue()));
        VerticalLayout layout = new VerticalLayout(label, textField);
        layout.getThemeList().clear();
        layout.getThemeList().add("spacing-xs");

        return layout;
    }

    private static class PersonFilter {
        private final GridListDataView<Person> dataView;

        private String fullName;
        private String email;
        private String profession;

        public PersonFilter(GridListDataView<Person> dataView) {
            this.dataView = dataView;
            this.dataView.addFilter(this::test);
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
            this.dataView.refreshAll();
        }

        public void setEmail(String email) {
            this.email = email;
            this.dataView.refreshAll();
        }

        public void setProfession(String profession) {
            this.profession = profession;
            this.dataView.refreshAll();
        }

        public boolean test(Person person) {
            boolean matchesFullName = matches(person.getFullName(), fullName);
            boolean matchesEmail = matches(person.getEmail(), email);
            boolean matchesProfession = matches(person.getProfession(),
                    profession);

            return matchesFullName && matchesEmail && matchesProfession;
        }

        private boolean matches(String value, String searchTerm) {
            return searchTerm == null || searchTerm.isEmpty() || value
                    .toLowerCase().contains(searchTerm.toLowerCase());
        }
    }
}
