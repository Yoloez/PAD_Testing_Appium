package utils;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Cucumber Console Plugin
 * Menampilkan output test yang lebih terstruktur dan mudah dibaca.
 */
public class PrettyConsolePlugin implements EventListener {

    private static final String PASS    = "✅ PASSED";
    private static final String FAIL    = "❌ FAILED";
    private static final String SKIP    = "⏭️  SKIPPED";
    private static final String DIVIDER = "═══════════════════════════════════════════════════════════";
    private static final String THIN    = "───────────────────────────────────────────────────────────";

    private int totalScenarios = 0;
    private int passedScenarios = 0;
    private int failedScenarios = 0;
    private long suiteStartTime = 0;

    private final List<String> failedScenarioNames = new ArrayList<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class,     this::onTestRunStarted);
        publisher.registerHandlerFor(TestCaseStarted.class,    this::onTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class,   this::onTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class,   this::onTestCaseFinished);
        publisher.registerHandlerFor(TestRunFinished.class,    this::onTestRunFinished);
    }

    private void onTestRunStarted(TestRunStarted event) {
        suiteStartTime = event.getInstant().toEpochMilli();
        System.out.println();
        System.out.println(DIVIDER);
        System.out.println("  🚀  MEMULAI TEST SUITE - APPIUM CUCUMBER");
        System.out.println("  🕐  " + java.time.LocalTime.now().withNano(0));
        System.out.println(DIVIDER);
        System.out.println();
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        totalScenarios++;
        String scenarioName = event.getTestCase().getName();
        System.out.println(THIN);
        System.out.println("  📋  SCENARIO #" + totalScenarios + ": " + scenarioName);
        System.out.println(THIN);
    }

    private void onTestStepFinished(TestStepFinished event) {
        // Hanya proses PickleStep (langkah Gherkin), abaikan hook (Before/After)
        if (!(event.getTestStep() instanceof PickleStepTestStep)) return;

        PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
        String stepText = step.getStep().getText();
        String keyword  = step.getStep().getKeyword().trim();
        Result result   = event.getResult();

        String status;
        switch (result.getStatus()) {
            case PASSED:   status = PASS; break;
            case FAILED:   status = FAIL; break;
            case SKIPPED:  status = SKIP; break;
            case PENDING:  status = "⏳ PENDING"; break;
            default:       status = "❓ UNKNOWN"; break;
        }

        System.out.printf("       %s  %s %s%n", status, keyword, stepText);

        // Tampilkan pesan error jika step gagal
        if (result.getStatus() == Status.FAILED && result.getError() != null) {
            String errorMsg = result.getError().getMessage();
            if (errorMsg != null) {
                // Ambil hanya baris pertama agar tidak terlalu panjang
                String firstLine = errorMsg.split("\n")[0];
                System.out.println("              💬 " + firstLine);
            }
        }
    }

    private void onTestCaseFinished(TestCaseFinished event) {
        String scenarioName = event.getTestCase().getName();
        Result result = event.getResult();
        long durationMs = result.getDuration().toMillis();

        System.out.println(THIN);
        if (result.getStatus() == Status.PASSED) {
            passedScenarios++;
            System.out.printf("  ✅  SCENARIO PASSED  (%.2f detik)%n", durationMs / 1000.0);
        } else {
            failedScenarios++;
            failedScenarioNames.add(scenarioName);
            System.out.printf("  ❌  SCENARIO FAILED  (%.2f detik)%n", durationMs / 1000.0);
        }
        System.out.println();
    }

    private void onTestRunFinished(TestRunFinished event) {
        long totalMs = event.getInstant().toEpochMilli() - suiteStartTime;

        System.out.println(DIVIDER);
        System.out.println("  📊  HASIL AKHIR TEST SUITE");
        System.out.println(DIVIDER);
        System.out.printf("  Total Scenario  : %d%n", totalScenarios);
        System.out.printf("  ✅ Passed        : %d%n", passedScenarios);
        System.out.printf("  ❌ Failed        : %d%n", failedScenarios);
        System.out.printf("  ⏱️  Total Waktu   : %.2f detik%n", totalMs / 1000.0);
        System.out.println(THIN);

        if (failedScenarios == 0) {
            System.out.println("  🎉  SEMUA SCENARIO BERHASIL! LUAR BIASA!");
        } else {
            System.out.println("  ⚠️   SCENARIO YANG GAGAL:");
            for (String name : failedScenarioNames) {
                System.out.println("       • " + name);
            }
        }
        System.out.println(DIVIDER);
        System.out.println();
    }
}
