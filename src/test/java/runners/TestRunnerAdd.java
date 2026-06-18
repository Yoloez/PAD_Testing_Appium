package runners;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
//import org.junit.runner.RunWith;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("add_matkul.features") // Otomatis menjalankan semua file .feature di folder tersebut
public class TestRunnerAdd {
}