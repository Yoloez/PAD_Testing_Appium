package runners.pengumuman;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
// Langsung arahkan ke folder pengumuman di dalam resources
@SelectClasspathResource("pengumuman")
public class TestRunnerPengumuman {
    // Kosongkan saja, pengaturan 'glue' (stepDef) otomatis dibaca dari cucumber.properties
}