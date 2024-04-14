import { useState } from 'react';
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { ProcessTransaction } from './modules/demo-datacap';

export default function App() {
  const [result, setResult] = useState<string | null>(null);

  return (
    <View style={styles.container}>
      <Text>App.tsx</Text>
      <Text>Android demo launched</Text>

      {result === null ? null : (
        <Text style={styles.text}>
          Result: {`${typeof result === 'string' ? result : typeof result}`}
        </Text>
      )}

      <TouchableOpacity
        style={styles.button}
        onPress={() => ProcessTransaction('<xml>sample-data</xml>', setResult)}
      >
        <Text style={styles.buttonText}>Run Demo Module</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  button: { backgroundColor: '#F2a000', borderRadius: 5, padding: 10, width: '50%' },
  buttonText: { color: '#fff', fontSize: 20, textAlign: 'center' },
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'space-evenly',
  },
  text: {
    fontSize: 20,
    textAlign: 'center',
    color: '#d3e',
    fontWeight: 'bold',
  },
});
