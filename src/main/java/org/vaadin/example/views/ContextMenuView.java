package org.vaadin.example.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.grid.contextmenu.GridMenuItem;
import com.vaadin.flow.component.grid.contextmenu.GridSubMenu;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

import static org.apache.commons.io.FileUtils.byteCountToDisplaySize;

@PageTitle("Context Menu")
@Route(value = "context-menu", layout = MainView.class)
public class ContextMenuView extends VerticalLayout {

    public ContextMenuView() {
        Grid<File> grid = new Grid();
        grid.setAllRowsVisible(true);
        grid.setItems(getFiles());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        grid.addColumn(File::getName)
                .setHeader("Name");
        grid.addColumn(File::getDisplaySize)
                .setHeader("Size");

        GridContextMenu<File> menu = grid.addContextMenu();
        menu.addItem("Preview", event -> {});
        menu.addItem("Edit", event -> {});
        menu.add(new Hr());

        GridMenuItem<File> export = menu.addItem("Export");
        GridSubMenu<File> exportSubMenu = export.getSubMenu();
        exportSubMenu.addItem("Portable Document Format (.pdf)", event -> {});
        exportSubMenu.addItem("Rich Text Format (.rtf)", event -> {});
        exportSubMenu.addItem("Plain text (.txt)", event -> {});

        GridMenuItem<File> share = menu.addItem("Share");
        GridSubMenu<File> shareSubMenu = share.getSubMenu();
        shareSubMenu.addItem("Copy link", event -> {});
        shareSubMenu.addItem("Email", event -> {});
        menu.add(new Hr());

        menu.addItem("Delete", event -> {});

        add(grid);
    }

    private File[] getFiles() {
        return new File[] {
                new File("Annual Report.docx", 25165824),
                new File("Financials.xlsx", 44040192)
        };
    }

    private class File {

        private String name;
        private long size;

        File(String name, long size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public long getSize() {
            return size;
        }

        public String getDisplaySize() {
            return byteCountToDisplaySize(size);
        }
    }
}
