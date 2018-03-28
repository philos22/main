package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.GEORGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.cell.Cell;

/**
 * A utility class containing a list of {@code Cell} objects to be used in tests.
 */
public class TypicalCells {
    public static final Cell EMPTY_CELL = new CellBuilder().build();
    public static final Cell CELL_WITH_PRISONER = new CellBuilder().withCellAddress("1-2").withPrisoner(ALICE).build();
    public static final Cell FULL_CELL = new CellBuilder().withCellAddress("1-3").withPrisoner(ALICE)
            .withPrisoner(GEORGE).build();
    public static final Cell LAST_CELL_OF_ROW = new CellBuilder().withCellAddress("1-5").withIsLast(true).build();


    public static List<Cell> getTypicalCells() {
        return new ArrayList<>(Arrays.asList(EMPTY_CELL, LAST_CELL_OF_ROW, CELL_WITH_PRISONER, FULL_CELL));
    }
}
