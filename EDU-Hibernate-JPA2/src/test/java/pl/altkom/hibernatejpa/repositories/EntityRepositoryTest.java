package pl.altkom.hibernatejpa.repositories;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@RunWith(SpringRunner.class)
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
 
}
