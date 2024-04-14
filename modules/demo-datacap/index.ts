// Import the native module, on native platforms to DemoDatacap.ts
import DemoDatacapModule from './src/DemoDatacapModule';

type ProcessTransaction = (xmlString: string) => string;

export function ProcessTransaction(
  xmlString: string,
  onResponse: (response: string) => void
): string {
  return DemoDatacapModule.ProcessTransaction(xmlString, onResponse);
}
