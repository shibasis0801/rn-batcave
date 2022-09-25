/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './package.json';

AppRegistry.registerComponent(appName, () => App);
// import {
//     SafeAreaView,
//     StyleSheet,
//     Text,
//     useColorScheme,
//     View,
//     ToastAndroid
// } from 'react-native';
// import React from "react";
// import {Colors} from "react-native/Libraries/NewAppScreen";
// AppRegistry.registerComponent(appName, () => () => {
//     const message = global.helloWorld()
//     ToastAndroid.show("SHIBSIS"+ message, 500);
//     return (
//         <SafeAreaView style={Colors.darker}>
//             <View>
//                 <Text>
//                     {"Shibasis"}
//                 </Text>
//             </View>
//         </SafeAreaView>
//     );
// });
