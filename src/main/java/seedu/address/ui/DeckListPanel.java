package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.deck.Deck;


/**
 * Panel containing the list of entries.
 */
public class DeckListPanel extends UiPart<Region> {
    private static final String FXML = "DeckListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(DeckListPanel.class);

    @FXML
    private ListView<Deck> deckListView;

    /**
     * Creates a {@code EntryListPanel} with the given {@code ObservableList}.
     */
    public DeckListPanel(ObservableList<Deck> deckList) {
        super(FXML);
        deckListView.setItems(deckList);
        deckListView.setCellFactory(listView -> new deckListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Entry} using a {@code EntryCard}.
     */
    class deckListViewCell extends ListCell<Deck> {
        @Override
        protected void updateItem(Deck deck, boolean empty) {
            super.updateItem(deck, empty);

            if (empty || deck == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new DeckCard(deck, getIndex() + 1).getRoot());
            }
        }
    }

}