import React, {useEffect, useState} from 'react';
import {
  SafeAreaView,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  ToastAndroid, Platform
} from 'react-native';
import {Colors} from "react-native/Libraries/NewAppScreen";

import { NativeModules } from "react-native";
const { LegacyBridge } = NativeModules;

function useNativePromise(
    invokationPromise: Promise<any>,
    defaultValue = null
) {
  const [ data, setData ] = useState(defaultValue)
  useEffect(() => {
    invokationPromise.then(setData)
    return () => {};
  }, []);
  return data;
}


const App = () => {
  // @ts-ignore
//   const message = global.LocationModule.helloWorld()
  // TODO FIX This does not work when debugger is on
  const message = global.helloWorld()
//   const message = "not working jsi"

  const isDarkMode = useColorScheme() === 'dark';
   // ToastAndroid.show("SHIBASIS" + message, 500);

  const backgroundStyle = {
    backgroundColor: Colors.darker
  };


  const test = useNativePromise(LegacyBridge?.testQuery("") || Promise.resolve(2))
  const hw = useNativePromise(LegacyBridge?.helloWorld("React says Hello") || Promise.resolve(2))
  const testWorking = useNativePromise(LegacyBridge?.useToTestWorking?.() || Promise.reject("Not working"))

  console.log(hw);
  console.log(test);
  console.log(LegacyBridge?.testQuery);
  console.log(testWorking);



  return (
    <SafeAreaView style={backgroundStyle}>
      <View>
        <Text>
          {message}
        </Text>

        {/*{*/}
        {/*  LegacyBridge.testQuery("test string")*/}
        {/*      .map((data: string) => (*/}
        {/*          <Text>*/}
        {/*            {data}*/}
        {/*          </Text>*/}
        {/*      ))*/}
        {/*}*/}
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
});

export default App;
