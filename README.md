# PAD Appium BDD

This project runs Appium-based BDD tests with Cucumber for a React Native Android app.

## Quick start

1. Start Appium server on your machine.
2. Connect an Android device or start an emulator.
3. Run tests with your desired configuration overrides.

## Configuration overrides

The driver reads values from system properties or environment variables:

- `APP_PACKAGE`
- `APP_ACTIVITY`
- `APP_WAIT_ACTIVITY` (optional)
- `DEVICE_NAME`
- `APPIUM_SERVER_URL`

Examples:

```powershell
mvn test -DAPP_PACKAGE=com.your.app -DAPP_ACTIVITY=com.your.app.MainActivity -DDEVICE_NAME=emulator-5554
```

```powershell
$env:APP_PACKAGE="com.your.app"
$env:APP_ACTIVITY="com.your.app.MainActivity"
$env:DEVICE_NAME="emulator-5554"
$env:APPIUM_SERVER_URL="http://127.0.0.1:4723"

mvn test
```

## Test runners

- `src/test/java/runners/TestRunnerAdd.java` runs `add_matkul.feature` only.
- `src/test/java/runners/TestRunnerEdit.java` runs all features under `src/test/resources`.

