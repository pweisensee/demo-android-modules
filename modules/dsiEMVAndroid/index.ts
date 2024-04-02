import { requireNativeModule } from 'expo-modules-core';

type ProcessTransaction = (xmlString: string) => string;

interface NativeAarLib {
  ProcessTransaction: ProcessTransaction;
}

// It loads the native module object from the JSI or falls back to
// the bridge module (from NativeModulesProxy) if the remote debugger is on.
const nativeAarLib: NativeAarLib = requireNativeModule('dsiEMVAndroid');

export default nativeAarLib;
