package seedu.address.logic.parser.deck;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.deck.NewDeckCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.DeckName;

/**
 * Parses input arguments and creates a NewDeckCommand object
 */
public class NewDeckCommandParser implements Parser<NewDeckCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the NewDeckCommand
     * and returns a NewDeckCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public NewDeckCommand parse(String args) throws ParseException {
        try {
            DeckName name = ParserUtil.parseDeckName(args);
            Deck deck = new Deck(name);
            return new NewDeckCommand(deck);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, NewDeckCommand.MESSAGE_USAGE), pe);
        }
    }
}
