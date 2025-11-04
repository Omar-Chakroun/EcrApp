# ECR Application Project

This repository contains an Android application for ECR (Electronic Cash Register) management and a Python server for handling connections.

## Project Structure

```
├── connection.py          # Python socket server for handling ECR connections
├── ecrapp/               # Main Android application project
│   └── Tmanager/        # Android app module
│       ├── app/         # Application source code
│       └── gradle/      # Gradle wrapper files
```

## Components

### 1. Android Application (Tmanager)

An Android application built with Kotlin for managing ECR terminal operations.

**Technical Details:**

- **Language:** Kotlin
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 34 (Android 14)
- **Build Tool:** Gradle 8.2.2
- **Kotlin Version:** 1.9.22

**Features:**

- Authorization
- Configuration commands
- ECR commands
- Connection management
- Registration

**Build Instructions:**

```bash
cd ecrapp/Tmanager
./gradlew build
```

**Run on Device/Emulator:**

```bash
./gradlew installDebug
```

### 2. Python Connection Server

A simple Python socket server that listens for incoming connections from ECR devices.

**Features:**

- TCP socket server on port 5000
- Handles multiple client connections
- Receives and logs ECR registration commands
- Sends acknowledgment responses

**Run the Server:**

```bash
python3 connection.py
```

The server will start listening on `0.0.0.0:5000` by default.

## Prerequisites

### For Android Development:

- Android Studio (recommended) or Android SDK
- JDK 8 or higher
- Gradle (included via wrapper)

### For Python Server:

- Python 3.x
- No external dependencies required (uses standard library)

## Development Setup

1. **Clone the repository:**

   ```bash
   git clone <repository-url>
   cd stage
   ```

2. **Android App Setup:**

   - Open `ecrapp/Tmanager` in Android Studio
   - Sync Gradle dependencies
   - Build and run the application

3. **Python Server Setup:**
   - Ensure Python 3 is installed
   - Run the server: `python3 connection.py`

## Usage

1. Start the Python server to handle ECR device connections
2. Deploy the Android app to your device
3. Configure the app to connect to the server
4. Use the app to manage ECR operations

## Project Status

This is an active development project for ECR terminal management.

## License

[Specify your license here]

## Contributors

[Add contributors information here]

## Notes

- The server currently listens on all interfaces (`0.0.0.0`). For production use, consider security configurations.
- Make sure to configure appropriate firewall rules for the server port (5000).
