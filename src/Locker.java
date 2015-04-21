/**
 * Created by jeril on 2015/04/21.
 */
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "locker")
public class Locker
{
    @DatabaseField(id = true)
    private String name;
    public Locker() {
        // ORMLite needs a no-arg constructor
    }
    public Locker(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
