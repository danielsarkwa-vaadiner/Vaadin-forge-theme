package org.vaadin.example.views;

import com.vaadin.flow.component.crud.*;
import com.vaadin.flow.component.html.H5;
import org.vaadin.domain.Person;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

import java.util.Arrays;
import java.util.List;

@PageTitle("CRUD")
@Route(value = "crud", layout = MainView.class)
public class CrudView extends VerticalLayout {

    private Crud<Person> crud;

    private String FIRST_NAME = "firstName";
    private String LAST_NAME = "lastName";
    private String EMAIL = "email";
    private String PROFESSION = "profession";
    private String EDIT_COLUMN = "vaadin-crud-edit-column";

    public CrudView() {
        crud = new Crud<>(
                Person.class,
                createEditor()
        );
        crud.setEditorPosition(CrudEditorPosition.ASIDE);
        crud.addThemeVariants(
                CrudVariant.NO_BORDER
        );

        setupGrid();
        setupDataProvider();

        H5 heading = new H5("CRUD Aside");
        add(heading, crud);
    }

    private CrudEditor<Person> createEditor() {
        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        EmailField email = new EmailField("Email");
        TextField profession = new TextField("Profession");
        FormLayout form = new FormLayout(firstName, lastName, email, profession);

        Binder<Person> binder = new Binder<>(Person.class);
        binder.forField(firstName).asRequired().bind(Person::getFirstName, Person::setFirstName);
        binder.forField(lastName).asRequired().bind(Person::getLastName, Person::setLastName);
        binder.forField(email).asRequired().bind(Person::getEmail, Person::setEmail);
        binder.forField(profession).asRequired().bind(Person::getProfession, Person::setProfession);

        return new BinderCrudEditor<>(binder, form);
    }

    private void setupGrid() {
        Grid<Person> grid = crud.getGrid();

        // Only show these columns (all columns shown by default):
        List<String> visibleColumns = Arrays.asList(
                FIRST_NAME,
                LAST_NAME,
                EMAIL,
                PROFESSION,
                EDIT_COLUMN
        );
        grid.getColumns().forEach(column -> {
            String key = column.getKey();
            if (!visibleColumns.contains(key)) {
                grid.removeColumn(column);
            }
        });

        // Reorder the columns (alphabetical by default)
        grid.setColumnOrder(
                grid.getColumnByKey(FIRST_NAME),
                grid.getColumnByKey(LAST_NAME),
                grid.getColumnByKey(EMAIL),
                grid.getColumnByKey(PROFESSION),
                grid.getColumnByKey(EDIT_COLUMN)
        );
    }

    private void setupDataProvider() {
        PersonDataProvider dataProvider = new PersonDataProvider();
        crud.setDataProvider(dataProvider);
        crud.addDeleteListener(deleteEvent ->
                dataProvider.delete(deleteEvent.getItem())
        );
        crud.addSaveListener(saveEvent ->
                dataProvider.persist(saveEvent.getItem())
        );
    }
}
