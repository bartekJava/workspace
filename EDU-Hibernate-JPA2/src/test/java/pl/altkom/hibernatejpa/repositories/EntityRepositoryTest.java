package pl.altkom.hibernatejpa.repositories;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

import pl.altkom.hibernatejpa.model.Borrower;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public abstract class EntityRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
    DataSource dataSource;
	
	@BeforeMethod
    public void setUp() throws Exception {
        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(
                dataSource);
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
    }
     
    protected abstract IDataSet getDataSet() throws Exception;
    
    public Borrower getSampleBorrower() {
		Borrower borrower = new Borrower();
		borrower.setFirstName("Name");
		borrower.setLastName("Lastname");
		borrower.setSsn("90030300333");
				
		return borrower;
	}
 
}
