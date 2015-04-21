import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by jeril on 2015/03/25.
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:h2:mem:account";
        // create a connection source to our database
        ConnectionSource connectionSource =
                new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Account, String> accountDao =
                DaoManager.createDao(connectionSource, Account.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTable(connectionSource, Account.class);
//        Once we have configured our database objects, we can use them to persist an Account to the database and query for it from the database by its ID:


        // create an instance of Account
        Account account = new Account();
        account.setName("Jim Coakley");
        account.setLocker(new Locker("LOCKER 1"));

        // persist the account object to the database
        accountDao.create(account);

        // retrieve the account from the database by its id field (name)
        Account account2 = accountDao.queryForId("Jim Coakley");
        System.out.println("Account: " + account2.getName());
        System.out.println("Password: " + account2.getPassword());
        System.out.println("Locker: " + account2.getLocker().getName());


        // close the connection source
        connectionSource.close();

    }
}
