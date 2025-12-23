# Privacy Policy for TXT Launcher

**Last updated: December 2025**

## Introduction

TXT Launcher is an open-source Android launcher application. This privacy policy explains how the app handles your data.

## Data Collection

**TXT Launcher does not collect, store, or transmit any personal data to external servers.** All data remains on your device.

## Permissions Used

The app requests certain permissions to provide its functionality. Here's what each permission is used for:

### Contacts (READ_CONTACTS, WRITE_CONTACTS)
- Used to display and search your contacts from the command line
- Contact data never leaves your device

### Location (ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION)
- Used only when you explicitly request location information via commands
- Location data is not stored or transmitted

### Phone (CALL_PHONE, READ_PHONE_STATE)
- Used to initiate phone calls directly from the launcher
- Used to detect call state for proper app behavior

### Camera & Flashlight (CAMERA, FLASHLIGHT)
- Used only to control the device flashlight via commands
- No photos or videos are captured

### Storage (READ/WRITE_EXTERNAL_STORAGE, MANAGE_EXTERNAL_STORAGE)
- Used to store and read configuration files in the txt folder
- Used to access files when you use file-related commands
- No files are uploaded or shared externally

### Network (INTERNET, ACCESS_NETWORK_STATE, WIFI_STATE, etc.)
- Used for RSS feed functionality and web commands
- Used to check network connectivity status
- No personal data is transmitted

### Bluetooth (BLUETOOTH, BLUETOOTH_ADMIN)
- Used to toggle Bluetooth on/off via commands
- No data is transmitted via Bluetooth by the app

### Other Permissions
- **VIBRATE**: Used for haptic feedback
- **WAKE_LOCK**: Used to keep the screen on when needed
- **QUERY_ALL_PACKAGES**: Used to list and launch installed applications

## Data Storage

All app configuration and data is stored locally on your device in the `/storage/emulated/0/txt/` folder. This data includes:
- Theme preferences
- Command aliases
- App settings

## Third-Party Services

TXT Launcher does not integrate with any third-party analytics, advertising, or tracking services.

## Open Source

TXT Launcher is open source. You can review the complete source code at:
https://github.com/jlarriba/TUI-ConsoleLauncher

## Children's Privacy

This app does not knowingly collect any information from children under 13 years of age.

## Changes to This Policy

We may update this privacy policy from time to time. Any changes will be reflected in the "Last updated" date above.

## Contact

If you have any questions about this privacy policy, please open an issue on the GitHub repository:
https://github.com/jlarriba/TUI-ConsoleLauncher/issues

---

This app is provided "as is" without warranty of any kind.
