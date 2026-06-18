package runners.matakuliah;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("edit_subject.feature") // <--- Tinggal arahkan ke file edit-mu
public class TestRunnerEdit {
}