# ECR Simulator

An Android application that simulates an Electronic Cash Register (ECR) communicating with payment terminals via TCP/IP sockets using the ZVT protocol.

## Overview

The ECR Simulator is a fully interactive Android application designed from the ground up to enable real-time transaction emulation and command handling through a user-friendly interface. This project demonstrates professional ECR terminal operations and payment terminal communication protocols.

**Technology Stack:**
- **Kotlin** - Primary programming language
- **Android Studio** - Development environment
- **TCP/IP** - Network communication protocol
- **ZVT Protocol** - Payment terminal communication standard

## Project Structure

```
├── connection.py          # Python socket server for handling ECR connections
├── ecrapp/               # Main Android application project
│   └── Tmanager/        # Android app module
│       ├── app/         # Application source code
│       └── gradle/      # Gradle wrapper files
```

## Components

### 1. ECR Simulator Android Application

A fully interactive ECR simulation application built with Kotlin that enables real-time transaction emulation and command handling.

**Key Features:**
- **Real-time Transaction Emulation:** Simulate payment transactions including purchases, refunds, and reversals
- **ZVT Protocol Implementation:** Communicates with payment terminals using industry-standard ZVT protocol
- **TCP/IP Socket Communication:** Network-based communication with payment terminals
- **Interactive Command Handling:** Supports authorization, registration, configuration, and ECR-specific commands
- **Connection Management:** Robust connection handling with status monitoring
- **User-Friendly Interface:** Intuitive Android UI for managing all ECR operations

**Technical Details:**
- **Language:** Kotlin
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 34 (Android 14)
- **Build Tool:** Gradle 8.2.2
- **Kotlin Version:** 1.9.22
- **Protocol:** ZVT (Zahlungsverkehrs-Terminal)
- **Communication:** TCP/IP Sockets

**Core Components:**
- `main.kt` - Main application entry point and UI controller
- `connectionmanager.kt` - Manages TCP/IP socket connections
- `ecr_commands.kt` - ECR command implementations
- `authorisation.kt` - Authorization and authentication handling
- `registration.kt` - Terminal registration procedures
- `configuration_commands.kt` - Terminal configuration management
- `connection_status.kt` - Connection state monitoring

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

A TCP socket server that simulates payment terminal responses for testing the ECR application.

**Features:**
- TCP socket server on port 5000
- Handles multiple client connections
- Receives and logs ECR registration commands
- Sends acknowledgment responses to simulate terminal behavior
- Useful for development and testing without physical terminals

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

### Running the Complete System

1. **Start the Python server** to simulate payment terminal responses:
   ```bash
   python3 connection.py
   ```
   The server will listen on `0.0.0.0:5000`

2. **Deploy the Android app** to your device or emulator:
   ```bash
   cd ecrapp/Tmanager
   ./gradlew installDebug
   ```

3. **Configure the connection** in the app:
   - Enter the server IP address and port (5000)
   - Test the connection status

4. **Simulate ECR operations**:
   - Perform registration and authorization
   - Execute payment transactions
   - Test configuration commands
   - Monitor real-time communication with the terminal

### Supported Operations

- **Registration:** Terminal registration with the payment system
- **Authorization:** User authentication and authorization
- **Payment Processing:** Purchase transactions via ZVT protocol
- **Refunds:** Transaction reversal and refund operations
- **Configuration:** Terminal configuration and settings management
- **Status Monitoring:** Real-time connection and transaction status

## Project Highlights

- **Fully Interactive Simulation:** Complete ECR functionality designed and implemented from scratch
- **Industry-Standard Protocol:** Implements ZVT (Zahlungsverkehrs-Terminal) protocol used by real payment terminals
- **Real-Time Communication:** TCP/IP socket-based communication for instant transaction processing
- **Professional Architecture:** Clean code structure with separation of concerns and modular components
- **Comprehensive Feature Set:** Covers all essential ECR operations including payments, refunds, registration, and configuration

## Technical Achievements

- Designed and implemented a complete ECR simulation system from the ground up
- Integrated ZVT protocol for authentic payment terminal communication
- Built robust TCP/IP socket communication layer for reliable network operations
- Created intuitive Android UI/UX for seamless user interaction
- Implemented real-time transaction emulation with command handling capabilities

## Project Status

Active development project demonstrating professional ECR terminal management and payment processing simulation.

## License

[Specify your license here]

## Contributors

[Add contributors information here]

## Notes

- The Python server simulates payment terminal responses for development and testing purposes
- The server currently listens on all interfaces (`0.0.0.0`). For production use, implement proper security configurations
- Ensure appropriate firewall rules are configured for the server port (5000)
- The ZVT protocol implementation follows industry standards for payment terminal communication
- This is a simulation/educational project - consult with payment service providers for production deployment

## Learn More

**ZVT Protocol:** The ZVT (Zahlungsverkehrs-Terminal) protocol is a German standard for communication between POS systems and payment terminals, widely used in European payment processing.

**Use Cases:**
- Learning payment terminal protocols
- Testing ECR integrations without physical hardware
- Developing and debugging payment applications
- Educational purposes for understanding payment systems
