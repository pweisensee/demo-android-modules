# Demo Android Modules

This project demonstrates how to integrate Android native modules into an Expo React Native app.

## Prerequisites

Before getting started, make sure you have the following installed on your machine:

-   Node.js
-   Expo CLI
-   Android Studio

## Getting Started

Follow these steps to create and run the project:

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/demo-android-modules.git
    ```

2. Navigate to the project directory:

    ```bash
    cd demo-android-modules
    ```

3. Install dependencies:

    ```bash
    yarn install
    ```

4. Create a new Expo project:

    ```bash
    expo init MyDemoApp
    ```

5. Choose the "blank" template when prompted.

6. Copy the contents of the `demo-android-modules` directory into the `MyDemoApp` directory, overwriting any existing files.

7. Install additional dependencies:

    ```bash
    cd MyDemoApp
    yarn install
    ```

8. Open the `android` directory in Android Studio.

9. Build and run the project using the Android emulator or a physical device.

## Usage

To use the Android native modules in your Expo React Native app, follow these steps:

1. Import the module in your JavaScript code:

    ```javascript
    import { NativeModule } from 'react-native';
    ```

2. Use the module in your app:

    ```javascript
    NativeModule.doSomething();
    ```

    Replace `doSomething()` with the actual method provided by the native module.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
