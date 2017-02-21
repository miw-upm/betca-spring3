package persistence.daos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    UnidirectionalOneToOneEmbeddedIT.class,
    UnidirectionalOneToOneJoinColumnIT.class,
    UnRelatedIT.class,
    UnidirectionalManyToOneJoinColumnIT.class,
    UnidirectionalOneToManyEmbeddedIT.class,
    UnidirectionalOneToManyIT.class,
    UnidirectionalManyToManyIT.class
})
public class AllPersistenceDaosIntegrationTests {

}
