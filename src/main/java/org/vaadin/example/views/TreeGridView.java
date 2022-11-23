package org.vaadin.example.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H5;
import org.vaadin.domain.DataService;
import org.vaadin.domain.Person;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

import java.util.List;

@PageTitle("Tree Grid")
@Route(value = "tree-grid", layout = MainView.class)
public class TreeGridView extends VerticalLayout {
    private List<Person> managers = DataService.getManagers();

    public TreeGridView() {
        basic();
    }

    public Void basic() {
        H5 groupHeading = new H5("Basic");

        TreeGrid<Person> treeGrid = new TreeGrid<>();
        treeGrid.setWidth("1000px");
        treeGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        treeGrid.setItems(managers, this::getStaff);
        treeGrid.addHierarchyColumn(Person::getFirstName).setHeader("First name");
        treeGrid.addColumn(Person::getLastName).setHeader("Last name");
        treeGrid.addColumn(Person::getEmail).setHeader("Email");
        add(treeGrid);

        add(groupHeading, treeGrid);

        return null;
    }

    public List<Person> getStaff(Person manager) {
        return DataService.getPeople(manager.getId());
    }
}
