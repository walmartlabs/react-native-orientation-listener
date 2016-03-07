'use strict';

var React = require('react-native');

var { DeviceEventEmitter, NativeModules } = React;

module.exports = {
  getOrientation: function(callback) {
    NativeModules.OrientationListener.getOrientation(callback);
  },
  addListener: function(callback) {
    return DeviceEventEmitter.addListener(
      'orientationDidChange', callback
    );
  },
  removeListener: function(listener) {
    DeviceEventEmitter.removeListener(
      'orientationDidChange', listener
    );
  }
}
