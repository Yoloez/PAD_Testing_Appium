# PAD Appium BDD

This project runs Appium-based BDD tests with Cucumber for a React Native Android app.

## Quick start

1. Start Appium server on your machine.
2. Connect an Android device or start an emulator.
3. Run tests with your desired configuration overrides.

## Teammate setup checklist (after git clone)

System prerequisites:
- Install Node.js (needed for `npm`).
- Install Android SDK + set `ANDROID_HOME` and `PATH` for `adb`.
- Ensure a device or emulator is available and visible to `adb`.

Appium installation (run once):

```powershell
npm install -g appium
appium driver install uiautomator2
```

Device preparation:
- Enable Developer Options and USB Debugging on the phone.
- Install the React Native app APK on the device.
- Verify device is detected:

```powershell
adb devices
```

Optional configuration overrides (if app package/activity or device name differ):
- `APP_PACKAGE`, `APP_ACTIVITY`, `APP_WAIT_ACTIVITY`, `DEVICE_NAME`, `APPIUM_SERVER_URL`

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

