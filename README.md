# Demo Android Modules

This project demonstrates how to integrate Android native modules into an Expo React Native app.

The main issue centers on integrating a third party `.AAR` Android library file into an [Expo Build (CNG)](https://docs.expo.dev/workflow/continuous-native-generation/)

- [See reference Android project here](https://github.com/datacapsystems/DSIEMVAndroidDemo/tree/development)

- [Docs for Expo instructions](https://docs.expo.dev/modules/third-party-library/)

## Prerequisites

Before getting started, make sure you have the following installed on your machine:

- Node.js (v18.20.0+)
- Expo CLI (v6.3.10+)
- EAS CLI (v7.6.2+)
- Android Studio

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

4. Build and run the Android app:

   ```bash
   yarn android
   ```

5. (optional) Open the `android` directory in Android Studio.

6. Build and run the project using the Android emulator or a physical device.

## Demo Initialization Steps

1. `yarn create expo-app -t expo-template-blank-typescript`

2. Test build works using `npx expo run:android --no-build-cache`

3. create a local native module: `npx create-expo-module --local demo-datacap`

4. Import the native module to run consume it in `App.tsx`

5. Run `npx expo run:android --no-build-cache` and verify app is working with native integration

6. Run `npx create-expo-module --local demo-datacap`

   - `.aar` file located at: `demo-android-modules/modules/demo-datacap/android/libs/DSIEMVAndroid.aar`
   - Create a Kotlin wrapper around the `android/libs/DSIEMVAndroid.aar` library file
   - This build.gradle and `expo-module.config.json` setup does not appear to work when running `npx expo run:android --no-build-cache`

7. Run `npx create-expo-module --local dsiEMVAndroid`

   - `.aar` file located at: `demo-android-modules/modules/dsiEMVAndroid/android/libs/DSIEMVAndroid.aar`
   - Create Expo Module to directly import `android/libs/DSIEMVAndroid.aar` library file
   - This build.gradle and `expo-module.config.json` setup does not appear to work when running `npx expo run:android --no-build-cache`

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## License

This project has no license for use other than debugging build issues.
