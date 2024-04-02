// Import the native module, on native platforms to DemoDatacap.ts
import DemoDatacapModule from './src/DemoDatacapModule';

type ProcessTransaction = (xmlString: string) => string;

export function hello(): string {
  return DemoDatacapModule.hello();
}

export const processTransaction = DemoDatacapModule.ProcessTransaction as ProcessTransaction;
