/**
 * @format
 */

import {AppRegistry} from 'react-native';

import App from './App';
import {name as appName} from './app.json';
import XView from './XView';

AppRegistry.registerComponent(appName, () => App);
AppRegistry.registerComponent('xview', () => XView);
