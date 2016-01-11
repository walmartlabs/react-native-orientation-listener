'use strict';

var React = require('react-native');
var RCTDeviceEventEmitter = require('react-native/Libraries/Device/RCTDeviceEventEmitter');

var {NativeModules} = React;

module.exports = {
  getOrientation: function(callback) {
    NativeModules.OrientationListener.getOrientation(callback);
  },
  addListener: function(callback) {
    return RCTDeviceEventEmitter.addListener(
      'orientationDidChange', callback
    );
  },
  removeListener: function(listener) {
    RCTDeviceEventEmitter.removeListener(
      'orientationDidChange', listener
    );
  }
}
