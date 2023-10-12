import java.util.Comparator;

public class OrderByIDNotebook implements Comparator<NoteBook> {


    @Override
    public int compare(NoteBook o1, NoteBook o2) {
        return o1.getId() - o2.getId();
    }
}
