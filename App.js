/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {useState, useEffect} from 'react';
import {
  ToastAndroid,
  View,
  Text,
  StatusBar,
  TouchableOpacity,
} from 'react-native';

import {
  Header,
  LearnMoreLinks,
  Colors,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';


import IPModule from './IPModule'; //Local
import GetIP from 'react-native-ip-address'; // Git hub

const App = () => {
  const [address, setAddress] = useState('')
  const fetchAddress = async () => {
    const address1 = await GetIP.getIP()
    setAddress(address1)
    ToastAndroid.show('Get IP address success', 2000)
  }
  return (
    <View style={{flex: 1, alignItems: 'center',justifyContent: 'center'}}>
      <StatusBar barStyle="dark-content" />
      <Text>{address|| '___.___.__.__'}</Text>
      <TouchableOpacity onPress={fetchAddress} style={{backgroundColor: 'pink', marginTop:5}}><Text style={{color: 'white', padding: 5}}>Get IP address</Text></TouchableOpacity>
    </View>
  );
};

export default App;
