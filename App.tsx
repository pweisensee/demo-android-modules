import { Alert, StyleSheet, Text, TouchableOpacity, View } from 'react-native';

import { hello, processTransaction } from './modules/demo-datacap';
// Uncomment the following line to import and test the wrapper module
// import dsiEMVAndroid from './modules/dsiEMVAndroid';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>App.tsx</Text>
      <Text>Android demo launched</Text>
      {/* Uncomment the following line to import and test the wrapper module */}
      {/* <TouchableOpacity
        style={styles.button}
        onPress={() =>
          Alert.alert('Result', dsiEMVAndroid.ProcessTransaction('<xml>sample-data</xml>'))
        }
      >
        <Text style={styles.buttonText}>Run Native Module</Text>
      </TouchableOpacity> */}
      <TouchableOpacity
        style={styles.button}
        onPress={() => Alert.alert('Result', processTransaction('<xml>sample-data</xml>'))}
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
});
