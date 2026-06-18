package runners.matakuliah;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
// Langsung arahkan ke file kelola_matkul.feature di dalam folder matakuliah
@SelectClasspathResource("matakuliah/kelola_matkul.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDef.mataKuliah")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/MataKuliahReport.html")
public class TestRunnerMataKuliah {
    // Class dibiarkan kosong
}