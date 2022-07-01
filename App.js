/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {
  Node,
  useEffect,
  useState,
} from 'react';

import {
  NativeEventEmitter,
  NativeModules,
  SafeAreaView,
  StatusBar,
  StyleSheet,
  Text,
  TouchableOpacity,
  useColorScheme,
  View,
} from 'react-native';
import {WebView} from 'react-native-webview';
import {
  Colors,
  DebugInstructions,
  LearnMoreLinks,
} from 'react-native/Libraries/NewAppScreen';

const { CalendarModule } = NativeModules;

const Section = ({ children, title }): Node => {
  const isDarkMode = useColorScheme() === 'dark';
  return (
    <View style={styles.sectionContainer}>
      <Text
        style={[
          styles.sectionTitle,
          {
            color: isDarkMode ? Colors.white : Colors.black,
          },
        ]}>
        {title}
      </Text>
      <Text
        style={[
          styles.sectionDescription,
          {
            color: isDarkMode ? Colors.lt : Colors.dark,
          },
        ]}>
        {children}
      </Text>
    </View>
  );
};

const App: () => Node = () => {
  const [visible, setVisible] = useState(true);
  const isDarkMode = useColorScheme() === 'dark';

  const backgroundStyle = {
    flex: 1,
    height: 2000,
    width: 300,
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  useEffect(() => {
    console.log('use effect');
    const eventEmitter = new NativeEventEmitter(NativeModules.ToastExample);
    eventEmitter.addListener('EVENT_REMINDER', (event) => {
      console.log(event.eventProperty);// "someValue"
      console.log('EVENT REMINDER');
    });
  });
  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />
      <View
        contentInsetAdjustmentBehavior="automatic"
        style={backgroundStyle}>
        <WebView
          source={{ uri: 'https://infinite.red' }}
          style={{
            marginTop: 20, backgroundColor: 'green',
            flex: 1,
          }}
        />
        <View
          style={{
            backgroundColor: isDarkMode ? Colors.black : Colors.white,
          }}>
          <TouchableOpacity onPress={() => {
            console.log('asdfasdf');
            setVisible(!visible)
            // CalendarModule.createCalendarEvent('testName', 'testLocation');
          }}>
            <Section title="Step One">
              Edit <Text style={styles.highlight}>App.js</Text> to change this
              screen and then asdfasdfasdfasdfssssssssssssssssssssssscome bacasdfasdfasdk to see your edits.
            </Section>
          </TouchableOpacity>
          {visible ?
            <Section title="Step x">
              <WebView
                source={{ uri: 'https://infinite.red' }}
                style={{
                  marginTop: 20, backgroundColor: 'green',
                  flex: 1,
                }}
              />
            </Section>
            : null
          }
          <Section title="Debug">
            <DebugInstructions />
          </Section>
          <Section title="Learn More">
            Read the docs to discover what to do next:
          </Section>
          <LearnMoreLinks />
        </View>
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
